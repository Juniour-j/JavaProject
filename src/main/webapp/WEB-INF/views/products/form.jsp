<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${product.id == null ? 'Add' : 'Edit'} Product - Retail Purchase Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body { background-color: #f8f9fa; }
        .page-header { background-color: #007bff; color: white; padding: 20px 0; margin-bottom: 20px; }
        .form-error { color: #dc3545; font-size: 0.875rem; margin-top: 0.25rem; }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<c:url value='/dashboard'/>">Retail Purchase Management</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link" href="<c:url value='/dashboard'/>">Dashboard</a></li>
                <li class="nav-item"><a class="nav-link active" href="<c:url value='/products'/>">Products</a></li>
            </ul>
            <div class="d-flex">
                <a href="<c:url value='/logout'/>" class="btn btn-outline-light btn-sm">Logout</a>
            </div>
        </div>
    </div>
</nav>
<div class="page-header">
    <div class="container">
        <h1>${product.id == null ? 'Add New' : 'Edit'} Product</h1>
        <p>${product.id == null ? 'Create a new product' : 'Update product information'}</p>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <div class="card">
                <div class="card-body">
                    <form:form action="/products/save" method="post" modelAttribute="product">
                        <form:hidden path="id" />

                        <div class="mb-3">
                            <label for="name" class="form-label">Product Name</label>
                            <form:input path="name" class="form-control" id="name" />
                            <form:errors path="name" cssClass="form-error" />
                        </div>

                        <div class="mb-3">
                            <label for="price" class="form-label">Price</label>
                            <form:input path="price" class="form-control" id="price" type="number" step="0.01" />
                            <form:errors path="price" cssClass="form-error" />
                        </div>

                        <div class="mb-3">
                            <label for="categoryId" class="form-label">Category</label>
                            <select name="categoryId" id="categoryId" class="form-select">
                                <option value="">-- Select a category --</option>
                                <c:forEach var="category" items="${categories}">
                                    <option value="${category.id}" ${product.categoryId == category.id ? 'selected' : ''}>
                                            ${category.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            <a href="<c:url value='/products'/>" class="btn btn-secondary me-md-2">
                                <i class="fas fa-times"></i> Cancel
                            </a>
                            <button type="submit" class="btn btn-success">
                                <i class="fas fa-save"></i> Save
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="bg-dark text-white mt-5 py-3">
    <div class="container text-center">
        <p class="mb-0">&copy; 2025 Retail Purchase Management System. All rights reserved.</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>