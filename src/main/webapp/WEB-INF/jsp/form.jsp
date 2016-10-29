<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${contactForm['new']}">
            <h1>Add new contact</h1>
        </c:when>
        <c:otherwise>
            <h1>Edit contact</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/contacts" var="contactActionUrl"/>

    <form:form class="form-horizontal"  method="post" modelAttribute="contactForm" action="${contactActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="lastname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Last Name</label>
                <div class="col-sm-10">
                    <form:input path="lastname" type="text" class="form-control " id="lastname" placeholder="Last Name" required="required"/>
                    <form:errors path="lastname" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="firstname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">First Name</label>
                <div class="col-sm-10">
                    <form:input path="firstname" type="text" class="form-control " id="firstname" placeholder="First Name" required="required"/>
                    <form:errors path="firstname" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="middlename">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Middle Name</label>
                <div class="col-sm-10">
                    <form:input path="middlename" type="text" class="form-control " id="middlename" placeholder="Middle Name" required="required"/>
                    <form:errors path="middlename" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="mobile">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Mobile</label>
                <div class="col-sm-10">
                    <form:input path="mobile" type="text" class="form-control " id="mobile" placeholder="Mobile" required="required"/>
                    <form:errors path="mobile" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="telephone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Phone</label>
                <div class="col-sm-10">
                    <form:input path="telephone" type="text" class="form-control " id="telephone" placeholder="Phone number"/>
                    <form:errors path="telephone" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="address">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Address</label>
                <div class="col-sm-10">
                    <form:input path="address" type="text" class="form-control " id="address" placeholder=" Address "/>
                    <form:errors path="address" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">E-mail</label>
                <div class="col-sm-10">
                    <form:input path="email" type="text" class="form-control " id="email" placeholder="email"/>
                    <form:errors path="email" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${contactForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add contact</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-left">Save contact</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>

<div class="footer">
    <jsp:include page="../fragments/footer.jsp" />
</div>
</body>
</html>