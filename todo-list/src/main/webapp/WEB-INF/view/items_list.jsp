<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- JSTL Tag declared  -->
<html>  
<head>
<title>To do Items</title>
</head>
<body>
	<div align = "center">
		
		<table border = "1" cellpadding="5">
		
			<caption><h2>To do Items</h2></caption>
			
			<tr>  <!-- table row -->
				<th>Title</th>  <!-- table header for the row -->
				<th>Deadline</th>	
			</tr>
			
			<c:forEach var = "item" items="${todoData.getItems()}"> <!-- todoData.items also works, since it automatically calls the getter -->
			
				<tr>
					<td><c:out value="${item.title}"/></td>
					<td><c:out value="${item.deadLine}"/></td>
				</tr>
				
			</c:forEach>
			
		</table>
	
	</div>
</body>
</html>