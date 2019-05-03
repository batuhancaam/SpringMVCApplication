<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>CRM</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

  </head>
  <body>
    <div class="container">
      <div class="jumbotron">
        <h2>CRM-Customer Relationship Manager</h2>
        <p>Basic CRM Application with Spring MVC and Hibernate...</p>
      </div>
    </div>
    <div class="container">
      <input style="margin-bottom: 20px" type="button" class="btn btn-primary" onclick="window.location.href='showFormForAdd'; return false;" value="Add New Customer">
    </div>
    <div class="container">
      <div class="content">
        <table class="table">
          <thead class="table-dark">
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
          </thead>
          <c:forEach var="customer" items="${customers}">
            <c:url var="updateLink" value="/customer/showFormForUpdate">
              <c:param name="customerId" value="${customer.id}"></c:param>
            </c:url>
            <c:url var="deleteLink" value="/customer/delete">
              <c:param name="customerId" value="${customer.id}"></c:param>
            </c:url>
              <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td><a href="${updateLink}" class="btn btn-info">Update</a></td>
                <td><a href="${deleteLink}" class="btn btn-info">Delete</a></td>
              </tr>

          </c:forEach>
        </table>
      </div>

    </div>
  </body>
</html>
