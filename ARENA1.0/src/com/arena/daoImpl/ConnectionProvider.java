package com.arena.daoImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
	
	static Connection con = null;
	static Properties prop = null;
	
	static
	{
		try
		{
			prop = new Properties();
		    prop.load(new FileInputStream("D:/NIIT/PROJECT/workspace/ARENA1.0/src/db.properties"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	 }
    public static Connection getConnection(){
    	try
    	{
            //MySQL Driver
            //Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "root");
            
            //Oracle Driver
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SUVANORACLE", "suvan123");
    		
    		Class.forName(prop.getProperty("driver"));
    		con = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
            
        }
    	catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();;
        }
        return con;
    }

}
