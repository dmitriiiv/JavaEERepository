<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<html>
<head>
<%@ include file="include/style.jsp"%>
<link href="include/css/tour-style.css" rel="stylesheet" />
<title><fmt:message key="tour.list.title" /></title>
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
						<ul class="nav navbar-nav navbar-right">
							<li><a href="controller?command=logout">${sessionScope.user.login}<fmt:message
										key="tour.list.logout" /></a></li>
						</ul>
						<form class="navbar-form navbar-right" method="post"
							action="controller">
							<input type="hidden" name="command" value="add_tour">
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
	        	<table class="table table-striped article col-md-12">
	        		<tr>
	        			<th class="col-md-4">
	        				<fmt:message key="tour.list.heading.title" />
	        			</th>
	        			<th class="col-md-4">
	        				<fmt:message key="tour.list.duration.title" />
	        			</th>
	        			<th class="col-md-4">
	        				<fmt:message key="tour.list.price.title" />
	        			</th>
	        		</tr>
	        		<c:forEach var="tour" items="${requestScope.tourList}">
	        		<tr>
	        			<td>
	        				<p>
	                    		<a href="controller?command=tour&id=${tour.id}">${tour.heading}</a>
	               			</p>
	        			</td>
	        			<td>
	        				<p>
	        					${tour.duration} 
								<fmt:message key="tour.list.days.label" />
							</p>
	        			</td>
	        			<td>
	        				<p>
	        					${tour.price}
	        					<fmt:message key="tour.list.money.label" />
	        				</p>
	        			</td>
	        		</tr>
	            	</c:forEach>
	        	</table>
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

