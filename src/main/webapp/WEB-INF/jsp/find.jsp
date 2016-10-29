<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>



<div align="center" style="width: 100%; margin-left: 1px">


    <h2 style="text-align: center; color: #23527c">Контакт</h2>
    <br>

    <spring:url value="/find" var="indexActionUrl"/>
    <form:form class="form-horizontal" method="get" action="${indexActionUrl}">
        <div align="center" class="container">
            <div class="row">
                <div class="search">
                    <input type="text" class="form-control input-sm" name="lastname" placeholder="Please type Last Name"/>
                    <button type="submit" class="btnn btn-primary btn-sm">Find</button>
                </div>
            </div>
        </div>
    </form:form>

    <table table class="sort" align="center" border="0.2" style="align-items: center" class="table table-striped">
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

</body>
<p><a href="/">Go home</a></p>

</html>