<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="../fragments/header.jsp" />

<div align="center" class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome to Phone book</h2>
    <br>

    </c:if>
    <table class="back-picture" style="align-items:center">
        <td>
            <a href="/contacts" button type="submit" class="btn-lg btn-primary">My contacts</a>
        </td>
        <td>
            <a href="/contacts/add" button type="submit" class="btn-lg btn-primary">Add new contact</a>
        </td>
    </table>
    <br>
    <div style="margin-left: 15px">
        <table style="width: 100%">
            <tr align="center" style="vertical-align:top">
                <td>
                    <img align="center" src="<c:url value="/resources/images/iStock.jpg"/>">
                </td>
            </tr>
        </table>
    </div>
</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

<div class="footer">
<jsp:include page="../fragments/footer.jsp" />
</div>
</body>
</html>
