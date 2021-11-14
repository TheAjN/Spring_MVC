<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- JSTL Tag declared  -->
<%@page import="com.ajn.util.Mappings" %>
<html>  
<head>   <!-- DELETE index.html,since we have already created our default homepage (home.jsp) -->
<title>To do Items</title>
</head>
<body>
	<div align = "center">
	
		<c:url var="addItemLink" value = "${Mappings.ADD_ITEM}"/>
		<h2><a href="${addItemLink}">New Item</a></h2>
		
		<table border = "1" cellpadding="5">
		
			<caption><h2>To do Items</h2></caption>
			
			<tr>  <!-- table row -->
				<th>Title</th>  <!-- table header for the row -->
				<th>Deadline</th>	
				<th>Delete</th>
				<th>Edit</th>
				<th>View</th>
			</tr>
			
			<c:forEach var = "item" items="${todoData.getItems()}"> <!-- todoData.items also works, since it automatically calls the getter -->
			
				<c:url var="deleteItemLink" value="${Mappings.DELETE_ITEM}"> <!-- initializing delete url on every row of the items -->
					<c:param name="id" value="${item.id}"/> <!-- providing a parameter "id" with the value from todoData id in the url -->
				</c:url>
				
				<c:url var = "editItemLink" value = "${Mappings.ADD_ITEM}">
					<c:param name="id" value="${item.id}"/>
				</c:url>
				
				<c:url var = "viewItemLink" value = "${Mappings.VIEW_ITEM}">
					<c:param name="id" value="${item.id}"/>
				</c:url>
				
				<tr>
					<td><c:out value="${item.title}"/></td>
					<td><c:out value="${item.deadLine}"/></td>
					<td><a href="${deleteItemLink}">Delete</a></td> <!-- implementing Delete url with unique id in every column -->
					<td><a href="${editItemLink}">Edit</a></td>
					<td><a href="${viewItemLink}">View</a></td>
				</tr>
							
			</c:forEach>
			
		</table>
	
	</div>
</body>
</html>