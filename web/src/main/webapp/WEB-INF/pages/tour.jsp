<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<html>
<head>
<%@ include file="include/style.jsp"%>
<link href=<c:url value="/pages/css/tour-style.css" /> rel="stylesheet">
<title><fmt:message key="tour.title" /></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default col-md-12">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><fmt:message
								key="tour.list.brand" /></a>
					</div>
					<div class="collapse navbar-collapse" id="navbar-main">
						<sec:authorize access="isAuthenticated()" var="isAuth" />
						<ul class="nav navbar-nav navbar-right">
							 <c:if test="${isAuth == true}">
								<li><a href='<spring:url value="/logout" htmlEscape="true"/>'><sec:authentication property="principal.username"/><fmt:message
										key="tour.list.logout" /></a></li>
							</c:if>
						</ul>
		
						<c:url var="additionUrl" value="/addition"/>
						<form class="navbar-form navbar-right" method="get"
							action="addition">
								<c:if test="${isAuth == true}">
									<sec:authentication property="principal.roles" var="roles"/>
									<c:forEach items="${roles}" var="r">
										<c:if test="${r.roleName == 'admin'}" >
											<button type="submit" class="btn btn-default">
											<fmt:message key="tour.list.submit" />
										</button>
										</c:if>
									</c:forEach>
								</c:if>
						</form>
					</div>
				</div>
			</nav>

			<div class="article col-md-12">
				<h1 class="h2 page-header">${requestScope.tour.heading}</h1>
				<p>${requestScope.tour.paragraphs}</p>
				<div class="row" style="font-weight: bolder">
					<div class="col-md-6 page-header-author">
						<p>
							<fmt:message key="tour.duration.title" /> 
							${requestScope.tour.duration} 
							<fmt:message key="tour.days.label"/>
						</p>
					</div>
					<div class="col-md-6 page-header-date">
						<p>
							<fmt:message key="tour.price.title" /> 
							${requestScope.tour.price}
							<fmt:message key="tour.money.label" />
						</p>
					</div>
				</div>
			</div>

			<div class="clearfix"></div>
			<div class="col-md-12">
				<footer>
					<p>
						&copy;
						<fmt:message key="project.author" />
					</p>
				</footer>
			</div>
		</div>
	</div>
	<%@ include file="include/bgScript.jsp"%>
</body>
</html>
