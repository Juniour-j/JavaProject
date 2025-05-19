<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Store Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Store Details</h1>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${store.name}</h5>
            <p class="card-text"><strong>ID:</strong> ${store.id}</p>
            <p class="card-text"><strong>Location:</strong> ${store.location}</p>
        </div>
    </div>

    <div class="mt-3 text-end">
        <a href="${pageContext.request.contextPath}/stores/edit/${store.id}" class="btn btn-warning">Edit</a>
        <a href="${pageContext.request.contextPath}/stores" class="btn btn-secondary">Back to List</a>
    </div>
</div>
</body>
</html>
