<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flat HTML5/CSS3 Login Form</title>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">

<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="<c:url value="/resources/js/index.js"/>"></script>
</head>

<script type="text/javascript">
$(document).ready(function() {		
	showOperatorLogin();
})

function showAdminLogin() {
	$("#login-admin-div").show();
	$("#login-operator-div").hide();
}

function showOperatorLogin() {
	$("#login-admin-div").hide();
	$("#login-operator-div").show();
}
</script>



<body>
	<%
		if (session.getAttribute("username") != null && session.getAttribute("password") != null
				&& session.getAttribute("role") != null) {
			System.out.println("Inside JSP Page Value is " + session.getAttribute("username"));
			System.out.println("Inside JSP Page Value is " + session.getAttribute("password"));
			System.out.println("Inside JSP Page Value is " + session.getAttribute("role"));
			session.setAttribute("userName", session.getAttribute("username"));
			session.setAttribute("userPassword", session.getAttribute("password"));
			session.setAttribute("userRole", session.getAttribute("role"));
			//request.setAttribute("User", session.getAttribute("user"));
	%>

	<c:redirect url="./login.do"></c:redirect>
	<%
		}
	%>
	<div
		style="height: 30px; margin-top: 90px; position: relative; background-color: lightslategrey;">
		<ul style="height: 30px;">
			<li onclick="showOperatorLogin()"
				style="float: left; list-style: none; color: white; margin-right: 25px; height: 25px; margin-top: 5px; cursor: pointer;">Operator
				Login</li>
			<li onclick="showAdminLogin()"
				style="float: left; list-style: none; color: white; margin-right: 25px; height: 25px; margin-top: 5px; cursor: pointer;">Admin
				Login</li>
		</ul>

	</div>


	<%@include file="admin_login.jsp"%>

	<%@include file="operator_login.jsp"%>


</body>
</html>