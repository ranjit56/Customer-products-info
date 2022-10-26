<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>

</head>
<body style="background-color: #C0C0C0;">
	<div align="center">
		    
		<h2>Search Result</h2>
		    
		<table border="1">
		
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Product Model</th>
			    <th> Product MadeIn</th>
				<th>Product Price</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${result}" var="product">
				 <tr>
					<td>${product.id}</td>
					<td>${product.productName}</td>
					<td>${product.productModel}</td>
					<td>${product.productMadeIn}</td>
					<td>${product.productPrice}</td>
					<td>${product.description}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	   
</body>
</html>