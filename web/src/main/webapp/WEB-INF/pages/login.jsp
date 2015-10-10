<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<html>
<head>
<%@ include file="include/style.jsp"%>
<link href=<c:url value="pages/css/login-style.css" /> rel="stylesheet">
<title><fmt:message key="login.title" /></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default col-md-12">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><fmt:message
								key="login.brand" /></a>
					</div>
					<div class="collapse navbar-collapse" id="navbar-main">
						<c:url var="registrationUrl" value="/registration"/>
						<form class="navbar-form navbar-right" action="${registrationUrl}" method="get">
							<button type="submit" class="btn btn-primary">
								<fmt:message key="login.registration.submit" />
							</button>	
						</form>
					</div>
				</div>
			</nav>
			
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<c:url var="loginUrl" value="/j_spring_security_check"/>
						<form class="form-login" method="post" action="${loginUrl}">
							<h2 class="form-login-heading">
								<fmt:message key="login.form.head" />
							</h2>
							 <input
								type="email" class="form-control" name="j_username"
								placeholder="<fmt:message key="login.email.placeholder"/>"
								required> 
							<input type="password" class="form-control"
								name="j_password"
								placeholder="<fmt:message key="login.pass.placeholder"/>"
								required>

							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me">
								<fmt:message key="login.checkbox" />
								</label>
							</div>
							<c:if test="${param.error != null}">
                    			<p style="color: #ff0000;"><fmt:message key="error.registration.input.message"/></p>
                			</c:if>
							<button class="btn btn-lg btn-primary btn-block" type="submit">
								<fmt:message key="login.submit" />
							</button>
						</form>
					</div>
					<div class="col-md-3"></div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="include/bgScript.jsp"%>
</body>
</html>
