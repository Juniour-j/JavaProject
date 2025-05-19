<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details - Retail Purchase Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body { background-color: #f8f9fa; }
        .page-header { background-color: #007bff; color: white; padding: 20px 0; margin-bottom: 20px; }
        .product-info { background-color: #e9ecef; padding: 15px; border-radius: 5px; margin-bottom: 20px; }
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
                <li class="nav-item"><a class="nav-link" href="<c:url value='/categories'/>">Categories</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/stores'/>">Stores</a></li>
            </ul>
            <div class="d-flex">
                <a href="<c:url value='/logout'/>" class="btn btn-outline-light btn-sm">Logout</a>
            </div>
        </div>
    </div>
</nav>
<div class="page-header">
    <div class="container">
        <h1>Product Details</h1>
        <p>View and manage product information and store assignments</p>
    </div>
</div>
<div class="container">
    <c:if test="${not empty success}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${success}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
    <div class="product-info">
        <div class="row">
            <div class="col-md-8">
                <h3>${product.name}</h3>
                <p><strong>Price:</strong> $${product.price}</p>
                <p><strong>Category:</strong> ${product.categoryName}</p>
                <p><strong>ID:</strong> ${product.id}</p>
            </div>
            <div class="col-md-4 text-md-end">
                <a href="<c:url value='/products/edit/${product.id}'/>" class="btn btn-warning">
                    <i class="fas fa-edit"></i> Edit
                </a>
                <a href="<c:url value='/products'/>" class="btn btn-secondary">
                    <i class="fas fa-arrow-left"></i> Back to List
                </a>
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
