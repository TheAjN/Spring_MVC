<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "com.ajn.util.Mappings" %> 
<html>
<head>
<title>Add Items</title>
</head>
<body>
	<div align = "center">
		<table>
			<tr>
				<th>ID</th>
					<td><c:out value="${todoItem.id}" /></td>
			</tr>
			<tr>
				<th>Title</th>
					<td><c:out value="${todoItem.title}"  /></td>
			</tr>
			<tr>
				<th>Details</th>
					<td><c:out value="${todoItem.details}"/></td>
			</tr>
			<tr>
				<th>Dead Line</th>
				<td><c:out value="${todoItem.deadLine}"  /></td>
			</tr>
			
		</table>
		
		<c:url var = "ItemsListLink" value = "${Mappings.ITEMS}"/>
		<h2><a href="${ItemsListLink}">Back to the Main Todo List</a></h2>
		
	</div>
</body>
</html>