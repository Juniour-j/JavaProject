<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stores - Retail Purchase Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Stores</h1>
    <p>Manage list of stores</p>

    <c:if test="${not empty success}">
        <div class="alert alert-success">${success}</div>
    </c:if>

    <div class="d-flex justify-content-between mb-3">
        <form action="${pageContext.request.contextPath}/stores/search" method="get" class="d-flex">
            <input type="text" name="search" class="form-control me-2" placeholder="Search...">
            <button type="submit" class="btn btn-outline-primary">Search</button>
        </form>
        <a href="${pageContext.request.contextPath}/stores/add" class="btn btn-primary">
            <i class="fas fa-plus"></i> Add New Store
        </a>
    </div>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Location</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="store" items="${stores}">
            <tr>
                <td>${store.id}</td>
                <td>${store.name}</td>
                <td>${store.location}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/stores/details/${store.id}" class="btn btn-info btn-sm">Details</a>
                    <a href="${pageContext.request.contextPath}/stores/edit/${store.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/stores/delete/${store.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
