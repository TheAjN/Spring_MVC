<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- JSTL Tag declared  -->
<%@ page import= "com.ajn.util.Mappings" %>
<html>  
<head>
<title>(INDEX) Todo List Application(I</title>
</head>
<body>
	<div align = "center">
	
	<c:url var="itemLink" value="${Mappings.ITEMS}" />
	<h2><a href = "${itemLink}">Show Todo Items</a></h2>
		
		
	</div>
</body>
</html>