<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="com.ajn.util.AttributeNames" %>
<html>
<head>
<title>Add Items</title>
</head>
<body>
	<div align = "center">
		<form:form method="POST" modelAttribute = "${AttributeNames.TODO_ITEM}"> <!-- sending data to Request method processitem() -->
																				<!-- AttributeNames.TODO_ITEM is "todoItem", this "todoItem" is from
																				the modelAttribute(todoItem) in @GetMapping request method -->
			
			<table>

				<tr>
					<td><label>ID</label></td>
					<td>
						<form:input path="id" disabled="true" />
					</td>
				</tr>
				
				<tr>
					<td><label>Title</label></td>
					<td>
						<form:input path="title"/>
					</td>
				</tr>
				
				<tr>
					<td><label>Details</label></td>
					<td>
						<form:input path="details"  />
					</td>
				</tr>
				
				<tr>
					<td><label>Deadline</label></td>
					<td>
						<form:textarea path="deadLine"  />
					</td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Submit"/></td> <!-- Goes to POST method, where the URL of the POST and GET method are the same -->
				</tr>
				
			</table>
			
		</form:form>
	
	</div>
</body>
</html>