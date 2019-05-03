<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <title>Add Customer</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h2>Add New Customer</h2>
    </div>
</div>
    <div class="container">

        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            <form:hidden path="id"/>
            <div class="form-group">
                <label for="firstNameInput">First Name</label>
                <form:input path="firstName" class="form-control" id="firstNameInput" aria-describedby="emailHelp" placeholder="Enter First Name"/>
            </div>
            <div class="form-group">
                <label for="lastNameInut">Last Name</label>
                <form:input path="lastName" type="text" class="form-control" id="lastNameInut" placeholder="Enter Last Name"/>
            </div>
            <div class="form-group">
                <label for="emailInput">E-Mail</label>
                <form:input path="email" type="email" class="form-control" id="emailInput" placeholder="Enter E-Mail"/>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form:form>
    </div>

    <div class="container">
        <a href="${pageContext.request.contextPath}/customer/list" class="btn btn-danger">Back To List</a>
    </div>
</body>
</html>
