<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Customer Product Info</title>

<style>
body{
background: url("/images/products.jpg");
background-size: cover;
}

 .box{
    position: absolute;
    left: 50%;
    top: 50%;
    transform : translate(-50%, -50%);
    width: 800px;
    padding: 80px;
    color:#fff;
    font-size: 16px;
    background: rgba(0, 0, 0, .8);
    box-sizing: border-box;
    box-shadow: 0 15px, 30px rgba(0, 0, 0, .5);
    border-radius: 10px;
} 

.button {
  background-color: #4CAF50; 
  border: none;
  color: white;
  padding: 4px 18px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  border-radius: 4px;
  cursor: pointer;
}
.button2 {background-color: #4CAF50;;}
.button3 {background-color: #f44336;} /* Red */
.button4 {border-radius: 30%;} 
</style>
</head>
<body style="background-color: #C0C0C0;">
	<div align="center">
		<h2>Customer Products</h2>
	<form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
       <button class="button button4" value="Search" > search</button>
    </form>

       <h3>
			<a href="/showNewProductForm">New Product</a>
		</h3>
		
 	    <br>
		<table border="1" class ="box">
		
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Product Model</th>
			    <th> Product MadeIn</th>
				<th>Product Price</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listProduct}" var="product">
				 <tr>
					  <td>${product.id}</td>
					  <td>${product.productName}</td>
					  <td>${product.productModel}</td>
					  <td>${product.productMadeIn}</td>
					  <td>${product.productPrice}</td>
					  <td>${product.description}</td>		
			          <td>
                          <a href="/edit?id=${product.id}">Edit</a>
                          &nbsp;&nbsp;
                          <a href="/delete?id=${product.id}">Delete</a>
                     </td>
				</tr>
			</c:forEach>
		</table>
	</div><br><br>
  <%-- <div align="center">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <button class="button button3" onclick="document.forms['logoutForm'].submit()" >Logout</button>
    </c:if>
  </div> --%>

</body>
</html>