<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Retail Purchase Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body { background-color: #f8f9fa; }
        .dashboard-header { background-color: #343a40; color: white; padding: 20px 0; margin-bottom: 30px; }
        .card { margin-bottom: 20px; transition: transform 0.3s; }
        .card:hover { transform: translateY(-5px); box-shadow: 0 10px 20px rgba(0,0,0,0.1); }
        .card-icon { font-size: 3rem; margin-bottom: 15px; }
        .products-icon { color: #007bff; }
        .customers-icon { color: #28a745; }
        .purchases-icon { color: #ffc107; }
        .store-icon { color: #6f42c1; }
        .category-icon { color: #17a2b8; }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<c:url value='/dashboard'/>">Retail Purchase Management</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link active" href="<c:url value='/dashboard'/>">Dashboard</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/products'/>">Products</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/customers'/>">Customers</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/purchases'/>">Purchases</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/categories'/>">Categories</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value='/stores'/>">Stores</a></li>
            </ul>
            <div class="d-flex">
                <span class="navbar-text me-3">Welcome, ${username}</span>
                <a href="<c:url value='/logout'/>" class="btn btn-outline-light btn-sm">Logout</a>
            </div>
        </div>
    </div>
</nav>
<div class="dashboard-header">
    <div class="container">
        <h1>Welcome to Retail Management</h1>
        <p>Manage your products, customers, and sales with ease.</p>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div class="card text-center">
                <div class="card-body">
                    <div class="card-icon products-icon"><i class="fas fa-box"></i></div>
                    <h5 class="card-title">Products</h5>
                    <p class="card-text">Manage your product listings and pricing.</p>
                    <a href="<c:url value='/products'/>" class="btn btn-primary">Manage Products</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center">
                <div class="card-body">
                    <div class="card-icon customers-icon"><i class="fas fa-users"></i></div>
                    <h5 class="card-title">Customers</h5>
                    <p class="card-text">View and manage customer profiles and purchases.</p>
                    <a href="<c:url value='/customers'/>" class="btn btn-success">Manage Customers</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center">
                <div class="card-body">
                    <div class="card-icon purchases-icon"><i class="fas fa-shopping-cart"></i></div>
                    <h5 class="card-title">Purchases</h5>
                    <p class="card-text">Track and manage purchase transactions.</p>
                    <a href="<c:url value='/purchases'/>" class="btn btn-warning">Manage Purchases</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center">
                <div class="card-body">
                    <div class="card-icon category-icon"><i class="fas fa-tags"></i></div>
                    <h5 class="card-title">Categories</h5>
                    <p class="card-text">Organize and classify your products.</p>
                    <a href="<c:url value='/categories'/>" class="btn btn-info">Manage Categories</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center">
                <div class="card-body">
                    <div class="card-icon store-icon"><i class="fas fa-store"></i></div>
                    <h5 class="card-title">Stores</h5>
                    <p class="card-text">Manage store locations and inventories.</p>
                    <a href="<c:url value='/stores'/>" class="btn btn-secondary">Manage Stores</a>
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