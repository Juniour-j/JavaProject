<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Customer Details</h1>

    <div class="mb-3">
        <strong>Name:</strong> ${customer.name}
    </div>
    <div class="mb-3">
        <strong>Email:</strong> ${customer.email}
    </div>
    <div class="mb-3">
        <strong>ID:</strong> ${customer.id}
    </div>

    <div class="text-end">
        <a href="/customers/edit/${customer.id}" class="btn btn-warning">Edit</a>
        <a href="/customers" class="btn btn-secondary">Back to List</a>
    </div>
</div>
</body>
</html>
