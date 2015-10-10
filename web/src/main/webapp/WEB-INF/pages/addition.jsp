<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"
	language="java"%>
<%@ include file="include/head.jsp"%>
<html>
<head>
<%@ include file="include/style.jsp"%>
<link href=<c:url value="/pages/css/addition-style.css" /> rel="stylesheet">
<title><fmt:message key="addition.title" /></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default col-md-12">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><fmt:message
								key="addition.brand" /></a>
					</div>
					<div class="collapse navbar-collapse" id="navbar-main">
						<sec:authorize access="isAuthenticated()" var="isAuth" />
						<ul class="nav navbar-nav navbar-right">
							 <c:if test="${isAuth == true}">
								<li><a href='<spring:url value="/logout" htmlEscape="true"/>'><sec:authentication property="principal.username"/><fmt:message
										key="addition.logout" /></a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</nav>

			<div class="col-md-12">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<c:url value="/addition" var="addTour"/>
						<form:form cssClass="form-signin form-horizontal" modelAttribute="tourParam" method="post"
							action="${addTour}">
						
							<h2 class="form-signin-heading">
								<fmt:message key="addition.form.head" />
							</h2>

							<div class="form-group">
								<form:label path="heading" class="control-label col-md-2"><fmt:message
										key="addition.label.title" /></form:label>

								<div class="col-md-10">
									<span class="text-danger"><form:errors path="heading"/></span>
									<form:input type="text" cssClass="form-control" id="heading"
										path="heading" maxlength="100"
										placeholder="Введите заголовок" />
								</div>
							</div>
							
							<div class="form-group">
								<form:label path="duration" class="control-label col-md-4"><fmt:message
										key="addition.label.duration" /></form:label>

								<div class="col-md-8">
									<span class="text-danger"><form:errors path="duration"/></span>
									<form:input type="number" cssClass="form-control" id="duration" path="duration"
									 placeholder="Введите длительность"
									 min="1" max="999" step="1" />
								</div>
							</div>
							
							<div class="form-group">
								<form:label path="price" class="control-label col-md-2"><fmt:message
										key="addition.label.price" /></form:label>

								<div class="col-md-10">
									<span class="text-danger"><form:errors path="price"/></span>
									<form:input type="number" class="form-control" id="price" path="price"
									placeholder="Введите стоимость"
									min="0" max="999999999" step="1000" />
								</div>
							</div>
							
							<span class="text-danger"><form:errors path="paragraphs"/></span>
							<form:textarea class="form-control" path="paragraphs" maxlength="65535"
								cols="40" rows="5"
								placeholder="Введите описание"></form:textarea>
								
							<button class="btn btn-lg btn-primary btn-block" type="submit">
								<fmt:message key="addition.submit" />
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
