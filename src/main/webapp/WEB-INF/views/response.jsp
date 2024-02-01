<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
#container {
	width: 960px;
	margin: auto;
	padding: 20px;
}

p {
	margin-bottom: 20px;
	line-height: 24px;
}

h1, h2 {
	color: orange;
	font-size: 24px;
	margin-bottom: 20px;
	font-weight: bold;
	margin: 20px 0;
}

#hover {
	position: fixed;
	background: #000;
	width: 100%;
	height: 100%;
	opacity: .6
}

#popup {
	position: absolute;
	width: 600px;
	height: 180px;
	background: #fff;
	left: 50%;
	top: 50%;
	border-radius: 5px;
	padding: 60px 0;
	margin-left: -320px; /* width/2 + padding-left */
	margin-top: -150px; /* height/2 + padding-top */
	text-align: center;
	box-shadow: 0 0 10px 0 #000;
	#
	tweet
	{
	color
	:
	#4099FF;
}

}
#close {
	position: absolute;
	background: black;
	color: white;
	right: -15px;
	top: -15px;
	border-radius: 50%;
	width: 30px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	font-size: 8px;
	font-weight: bold;
	font-family: 'Arial Black', Arial, sans-serif;
	cursor: pointer;
	box-shadow: 0 0 10px 0 #000;
}
</style>
</head>
<body>

	<div id="hover"></div>

	<div id="popup">
		<div id="close" onclick="closePopup()">X</div>
		<h2>${status}</h2>
		<h3>${message}</h3>
	</div>

	<div id="container"></div>

	<script>
    $(document).ready(function(){
    	  
    	  //chiusura al click sulla parte scura
    	  $("#hover").click(function(){
    	    $(this).fadeOut();
    	    $("#popup").fadeOut();
    	  });
    	  
    	  //chiusura al click sul pulsante
    	  $("#close").click(function(){
    	    $("#hover").fadeOut();
    	    $("#popup").fadeOut();
    	  });
    	  
    	});
    </script>
    
    <script>
        function closePopup() {
            // Perform your URL redirect here
            window.location.href = "addHotel";
        }
    </script>

</body>
</html>
