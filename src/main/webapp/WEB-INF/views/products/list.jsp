<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products - Retail Purchase Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body { background-color: #f8f9fa; }
        .page-header { background-color: #007bff; color: white; padding: 20px 0; margin-bottom: 20px; }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<c:url value='/dashboard'/>">Retail Purchase Management</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto">
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
        <h1>Products</h1>
        <p>Manage product listings and categories</p>
    </div>
</div>
<div class="container">
    <c:if test="${not empty success}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${success}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
    <div class="row mb-3">
        <div class="col-md-6">
            <form action="<c:url value='/products/search'/>" method="get" class="d-flex">
                <input type="text" name="searchText" class="form-control me-2" placeholder="Search products..." value="${searchText}">
                <button type="submit" class="btn btn-outline-primary">
                    <i class="fas fa-search"></i> Search
                </button>
            </form>
        </div>
        <div class="col-md-6 text-md-end">
            <a href="<c:url value='/products/add'/>" class="btn btn-primary">
                <i class="fas fa-plus"></i> Add New Product
            </a>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <c:choose>
                <c:when test="${empty products}">
                    <div class="alert alert-info">No products found. Please add a product.</div>
                </c:when>
                <c:otherwise>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Category</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="product" items="${products}">
                                <tr>
                                    <td>${product.id}</td>
                                    <td>${product.name}</td>
                                    <td>$${product.price}</td>
                                    <td>${product.categoryName != null ? product.categoryName : 'Uncategorized'}</td>
                                    <td>
                                        <a href="<c:url value='/products/details/${product.id}'/>" class="btn btn-info btn-sm">
                                            <i class="fas fa-info-circle"></i> Details
                                        </a>
                                        <a href="<c:url value='/products/edit/${product.id}'/>" class="btn btn-warning btn-sm">
                                            <i class="fas fa-edit"></i> Edit
                                        </a>
                                        <a href="<c:url value='/products/delete/${product.id}'/>" class="btn btn-danger btn-sm"
                                           onclick="return confirm('Are you sure you want to delete this product?')">
                                            <i class="fas fa-trash"></i> Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
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