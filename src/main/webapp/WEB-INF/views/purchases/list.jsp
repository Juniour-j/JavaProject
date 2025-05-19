<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Purchases</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Purchase List</h1>

    <c:if test="${not empty success}">
        <div class="alert alert-success">${success}</div>
    </c:if>

    <div class="mb-3 text-end">
        <a href="${pageContext.request.contextPath}/purchases/add" class="btn btn-success">Add New Purchase</a>
    </div>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Customer</th>
            <th>Product</th>
            <th>Purchase Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="purchase" items="${purchases}">
            <tr>
                <td>${purchase.id}</td>
                <td>${purchase.customerName}</td>
                <td>${purchase.productName}</td>
                <td>${purchase.purchaseDate}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/purchases/details/${purchase.id}" class="btn btn-info btn-sm">Details</a>
                    <a href="${pageContext.request.contextPath}/purchases/delete/${purchase.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
