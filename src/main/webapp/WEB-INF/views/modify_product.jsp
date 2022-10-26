<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
<style type="text/css">
.box {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 400px;
    padding: 40px;
    background: rgba(0, 0, 0, .8);
    box-sizing: border-box;
    box-shadow: 0 15px, 30px rgba(0, 0, 0, .5);
    border-radius: 10px;
}
.box h2{
    margin: 0, 0, 30px;
    padding: 0;
    color: #fff;
    text-align: center;
}
.box .inputBox{
    position: relative;
}
.box .inputBox input{
    width: 100%;
    padding: 10px 0;
    font-size: 16px;
    color:rgba(242, 224, 196, 0.684);
    letter-spacing: 2px;
    margin-bottom: 30px;
    border: none;
    border-bottom: solid #fff;
    background: transparent;
    outline: none;
}
.box .inputBox label{
    position: absolute;
    top : 0;
    left: 0;
    font-size: 16px;
    padding: 10px 0;
    color: #fff;
    pointer-events: none;
    transition: .5s;
}
.box .inputBox input:focus +label,
.box .inputBox input:valid +label
{
   top: -18px;
    left:0;
    font-size: 10px;
    color: rgb(82, 180, 230);  
}
.box input[ type="submit" ]{
   background: transparent;
   outline: none;
   border: none;
  padding: 10px;
  color:#fff;
  background:rgb(56, 168, 227);
  cursor: pointer;
  border-radius: 2px;
}
</style>
</head>
<body style="background-color: #DEB887;">
	<div class ="box">
		<h2>Edit Product</h2>
		<form:form action="saveproduct" method="post" modelAttribute="product">
			<div class ="inputBox">
			    
					
					<form:input path="id" required ="" />
				   <label> Id:</label>
				</div>
				<div class ="inputBox">
				
					<form:input path="productName" required =""/>
					  <label> Product Name:</label>   
				
				</div>
				<div class ="inputBox">
					
					<form:input path="productModel" />
					<label> Product Model:</label>   
				</div >
				<div class ="inputBox">
					
					<form:input path="productMadeIn" />
					<label> Product MadeIn:</label> 
				</div>
				<div class ="inputBox">
					
					<form:input path="productPrice" />
					<label> Product Price:</label> 
				</div>
				<div class ="inputBox">
					
					<form:input path="description" />
					<label> Description:</label> 
				</div>
				<div>
				<input type="submit" value="Save">
				</div>
		</form:form>
	</div>
</body>
</html>
