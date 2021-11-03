<html>
<head>
<title>Welcome</title> <!-- This jsp file is will be called 
					when the Request method welcome() returns "welcome", 
					which is equivalent to this .jsp file's name-->
</head>
<body>
	<h1>${name} </h1>  <!-- ${user} is from model.addrtibute() where "Abhishek J" is the value  -->
	<h2>Age = ${age}</h2>
	<h2>${welcomeMessage}</h2> <!-- From the @ModelAttribute in the Controller -->>
</body>
</html>