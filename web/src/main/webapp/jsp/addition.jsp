<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"
	language="java"%>
<%@ include file="include/head.jsp"%>
<html>
<head>
<%@ include file="include/style.jsp"%>
<link href="include/css/addition-style.css" rel="stylesheet" />
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
						<ul class="nav navbar-nav navbar-right">
							<li><a href="controller?command=logout">${sessionScope.user.login}<fmt:message
										key="addition.logout" /></a></li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="col-md-12">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<form class="form-signin form-horizontal" method="post"
							action="controller">
							<input type="hidden" name="command" value="save_tour">

							<h2 class="form-signin-heading">
								<fmt:message key="addition.form.head" />
							</h2>

							<div class="form-group">
								<label for="inputHeading" class="control-label col-md-2"><fmt:message
										key="addition.label.title" /></label>

								<div class="col-md-10">
									<input type="text" class="form-control" id="inputHeading"
										name="heading" maxlength="100"
										placeholder="<fmt:message key="addition.title.placeholder"/>"
										required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputDuration" class="control-label col-md-4"><fmt:message
										key="addition.label.duration" /></label>

								<div class="col-md-8">
									<input type="text" class="form-control" id="inputDuration"
										name="duration" maxlength="3"
										placeholder="<fmt:message key="addition.duration.placeholder"/>"
										required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPrice" class="control-label col-md-2"><fmt:message
										key="addition.label.price" /></label>

								<div class="col-md-10">
									<input type="text" class="form-control" id="inputPrice"
										name="price" maxlength="9"
										placeholder="<fmt:message key="addition.price.placeholder"/>" 
										required>
								</div>
							</div>
							<textarea class="form-control" name="text" maxlength="65535"
								cols="40" rows="5"
								placeholder="<fmt:message key="addition.text.placeholder"/>"
								required></textarea>
							<p>${requestScope.errorAdditionNews}</p>
							<button class="btn btn-lg btn-primary btn-block" type="submit">
								<fmt:message key="addition.submit" />
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
