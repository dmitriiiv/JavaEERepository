<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<html>
<head>
<%@ include file="include/style.jsp"%>
<link href="include/css/tour-style.css" rel="stylesheet" />
<title><fmt:message key="tour.title" /></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default col-md-12">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><fmt:message key="tour.brand" /></a>
					</div>
					<div class="collapse navbar-collapse" id="navbar-main">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="controller?command=logout">${sessionScope.user.login}<fmt:message
										key="tour.logout" /></a></li>
						</ul>
						<form class="navbar-form navbar-right" method="post"
							action="controller">
							<input type="hidden" name="command" value="add_news">
							<c:forEach var="role" items="${sessionScope.user.roles}">
								<c:if test="${role.id == 1 }" >
								<button type="submit" class="btn btn-default">
									<fmt:message key="tour.list.submit" />
								</button>
								</c:if>
							</c:forEach>
						</form>
					</div>
				</div>
			</nav>

			<div class="article col-md-12">
				<h1 class="h2 page-header">${requestScope.tour.heading}</h1>
				<p>${requestScope.tour.text}</p>
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
