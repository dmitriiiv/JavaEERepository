<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/head.jsp"%>
<html>
<head>
    <title>Error</title>
    <%@ include file="../include/style.jsp"%>
    <link href="WEB-INF/pages/include/css/login-style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>Oops!</h1>
                <h2>Status: ${status}</h2>

                <div class="error-details">
                    The page <b>${errorUri}</b> you are looking cannot be represented.
                </div>
                <br>
                <div class="error-actions">
                    <a href='<spring:url value="/newsfeed" htmlEscape="true"/>' class="btn btn-primary btn-lg">
                        <span class="glyphicon glyphicon-home"></span>Back to news
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>