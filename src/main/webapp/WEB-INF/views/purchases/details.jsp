<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Purchase Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Purchase Details</h1>

    <div class="mb-3"><strong>ID:</strong> ${purchase.id}</div>
    <div class="mb-3"><strong>Customer:</strong> ${purchase.customerName}</div>
    <div class="mb-3"><strong>Product:</strong> ${purchase.productName}</div>
    <div class="mb-3"><strong>Date:</strong> ${purchase.purchaseDate}</div>

    <div class="text-end">
        <a href="${pageContext.request.contextPath}/purchases" class="btn btn-secondary">Back to List</a>
    </div>
</div>
</body>
</html>
