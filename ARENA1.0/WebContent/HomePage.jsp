<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ARENA.com</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
    <style>
		img:hover{opacity:0.8;}
		
		#comingSoon{
			color:red;
			font-size:24px;
		}
		
		#limited{
			color:red;
			font-size:24px;
			margin-top:5px;
		}
		
		#admin{
			background-color: black;
			color: white;
		}
	</style>
   
</head>
	
<body style="background-color:lightgray">

<!-- <%
		String role2 = (String)session.getAttribute("CustomerRole");
		if(role2 != null && role2.equals("Admin"))
		{	
	%>	<jsp:forward page="AdminPage.jsp"></jsp:forward>
	<%
		}
	%>	-->
	
<jsp:include page="UserHeader.jsp"></jsp:include>

<!-- Container for the carousel -->
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-8">		
		<div class="container" style="height:60%; width:100%" >
			<div id="myCarousel" class="carousel slide" data-ride="carousel" >
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			  </ol>

			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" >
				<div class="item active">
				  <a href="ProductDetails.jsp?name=Shadow Of The Tomb Raider"><img src="Images/ShadowOfTombRaider.jpg" alt="Shadow Of Tomb Raider" style="width:100%"></a>
				  <div class="carousel-caption">
					<h3><i>Shadow Of Tomb Raider</i></h3>
				  </div>
				</div>

				<div class="item">
				  <a href="ProductDetails.jsp?name=WWE 2019"><img src="Images/WWE2019.jpg" alt="WWE 2019" style="width:100%"></a>
				  <div class="carousel-caption">
					<h3><i>WWE 2019</i></h3>
				  </div>
				</div>

				<div class="item">
				  <a href="ProductDetails.jsp?name=Hitman 2"><img src="Images/Hitman2.jpg" alt="Hitman 2" style="width:100%"></a>
				  <div class="carousel-caption">
					<h3><i>Hitman 2</i></h3>
				  </div>
				</div>
			  </div>

			  <!-- Left and right controls -->
			  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				<span class="sr-only">Next</span>
			  </a>
			  
			</div>
		<center id="limited">LIMITED EDITION</center>
		</div>
		</div>

		<!-- Coming Soon Slider -->
		<div class="col-sm-4" id="AdSlider">
			<iframe src="AdSlider.html" style="height:440px;width:470px;border:none;background-color:lightgrey"></iframe>   
			<center id="comingSoon">COMING SOON</center>
		</div>
	</div>
</div>

<br/>
	
<!-- SLIDERS -->
<div id="PCGameSlider">
	<!-- <marquee behavior="alternate" scrollamount="15" direction="left"><h3 style="color:#300;font-family:Verdana, Geneva, sans-serif;font-size:36px">PC GAMES</h3></marquee> -->
	<center><h1>Top PC Games</h1></center>
	<iframe src="PCGameSlider.jsp" style="height:380px;width:100%;border:none"></iframe>
</div>
<br/>

<div id="XboxGameSlider">
	<!-- <marquee behavior="alternate" scrollamount="15" direction="left"><h3 style="color:#300;font-family:Verdana, Geneva, sans-serif;font-size:36px">XBOX-ONE GAMES</h3></marquee> -->
	<center><h1>Top Xbox-One Games</h1></center>
	<iframe src="XboxGameSlider.jsp" style="height:380px;width:100%;border:none"></iframe>
</div>

<div id="PS4GameSlider">
	<!-- <marquee behavior="alternate" scrollamount="15" direction="left"><h3 style="color:#300;font-family:Verdana, Geneva, sans-serif;font-size:36px">PS4 GAMES</h3></marquee> -->
	<center><h1>Top PS4 Games</h1></center>
	<iframe src="PS4GameSlider.jsp" style="height:380px;width:100%;border:none"></iframe>
</div>

<jsp:include page="Footer.html"></jsp:include>

</body>

</html>