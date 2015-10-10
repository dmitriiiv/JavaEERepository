<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<html>
<head>
<%@ include file="include/style.jsp"%>
<link href=<c:url value="/pages/css/login-style.css" /> rel="stylesheet">
<title><fmt:message key="registration.title" /></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default col-md-12">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><fmt:message
								key="registration.brand" /></a>
					</div>
				</div>
			</nav>
			
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
					<c:url var="saveUser" value="/registration"/>
					<form:form cssClass="form-login" modelAttribute="userParam" action="${saveUser}" method="post">
					<h2 class="form-login-heading">
						<fmt:message key="registration.form.head" />
					</h2>
					
					<span class="text-danger"><form:errors path="login"/></span>
					<form:input type="email" cssClass="form-control" path="login" id="login"
								placeholder="Введите адресс интернет-почты"/> 
								 
					<span class="text-danger"><form:errors path="password"/></span>			 
					<form:input type="password" class="form-control" path="password" id="password"
								placeholder="Введите пароль"/>

        			<button class="btn btn-lg btn-primary btn-block" type="submit">
							<fmt:message key="registration.submit" />
					</button>
    				</form:form>
				</div>
				<div class="col-md-3"></div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="include/bgScript.jsp"%>
</body>
</html>