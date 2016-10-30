<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<jsp:include page="../fragments/header.jsp"/>

<div align="center" style="width: 100%; margin-left: 1px">


    <h2 style="text-align: center; color: #23527c">Contact</h2>

    <table class="find">
        <div style="text-align: left">
            <spring:url value="/find" var="indexActionUrl"/>
            <form:form class="form-horizontal" method="get" action="${indexActionUrl}">
                <div class="container">
                    <div class="row">
                        <div class="search">
                            <input type="text" class="form-control input-sm" name="lastname"
                                   placeholder="Find contact by Last Name"/>
                            <br>
                            <button type="submit" class="btnn btn-primary btn-sm">Find</button>
                        </div>
                    </div>
                </div>

            </form:form>
        </div>
    </table>


    <table class="sort" align="center" border="1" width="800" class="table table-striped">
        <thead style="color:white;background-color:#2e6da4">
        <tr>
            <td>Last Name</td>
            <td>First Name</td>
            <td>Middle name</td>
            <td>Mobile</td>
            <td>Phone</td>
            <td>Address</td>
            <td>E-mail</td>
            <th colspan="2" align="center">Опции</th>
        </tr>
        </thead>
        <tr>
            <td>${contactic.lastname}</td>
            <td>${contactic.firstname}</td>
            <td>${contactic.middlename}</td>
            <td>${contactic.mobile}</td>
            <td>${contactic.telephone}</td>
            <td>${contactic.address}</td>
            <td>${contactic.email}</td>

            <td style="align-items: center; width: 20px">
                <spring:url value="/contacts/${contact.id}/update" var="updateUrl"/>
                <a href="${updateUrl}">Edit</a>
            </td>

            <td style="align-items: center; width: 20px">
                <spring:url value="/contacts/${contact.id}/delete" var="deleteUrl"/>
                <a href="${deleteUrl}">Delete</a>
            </td>

        </tr>

    </table>
</div>
<br/>
<div align="center">
        <a href="/contacts" button type="submit" class="btn-lg btn-primary">My contacts</a>
</div>

<div class="footer">
    <jsp:include page="../fragments/footer.jsp"/>
</div>


</body>


</html>