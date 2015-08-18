<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<html>
<head>
<%@ include file="include/style.jsp"%>
<link href="include/css/login-style.css" rel="stylesheet">
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
				</div>
			</nav>
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<form class="form-login" method="post" action="controller">
							<h2 class="form-login-heading">
								<fmt:message key="login.form.head" />
							</h2>
							<input type="hidden" name="command" value="login"> <input
								type="email" class="form-control" name="login"
								placeholder="<fmt:message key="login.email.placeholder"/>"
								required> <input type="password" class="form-control"
								name="pass"
								placeholder="<fmt:message key="login.pass.placeholder"/>"
								required>

							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me">
								<fmt:message key="login.checkbox" />
								</label>
							</div>
							<p>${requestScope.errorLoginPassMessage}</p>
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
