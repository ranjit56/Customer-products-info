<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Log-in</title>
<style>
.button {
  background-color: #4CAF50; 
  border: none;
  color: white;
  padding: 6px 25px;;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button2 {background-color: #008CBA;} /* Blue */
</style>
</head>
<body style="background-color: #EBECF0;">

	<div align="center">
		<form:form method="POST" action="${contextPath}/login" class="form-signin">
			<h2 class="form-heading">Log in</h2>
			<div class="form-group ${error != null ? 'has-error' : ''}">
				<span>${message}</span> <br><br>
				<input name="username" type="text"
					class="form-control" placeholder="Username" autofocus="true" /><br>
				<br> <input name="password" type="password"
					class="form-control" placeholder="Password" /><br> <span >${error}</span><br>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <br>

				<button class="button button2" type="submit" >Log-In</button>
				<h4 class="text-center">
					New User? <a href="${contextPath}/registration">Register here</a>
				</h4>
			</div>
		</form:form>
	</div>
</body>
</html>