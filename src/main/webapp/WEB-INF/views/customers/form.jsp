<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${customer.id == null ? 'Add' : 'Edit'} Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>${customer.id == null ? 'Add New' : 'Edit'} Customer</h1>
    <form:form modelAttribute="customer" action="/customers/save" method="post">
        <form:hidden path="id" />

        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <form:input path="name" class="form-control" />
            <form:errors path="name" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" cssClass="text-danger" />
        </div>

        <div class="text-end">
            <a href="/customers" class="btn btn-secondary">Cancel</a>
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form:form>
</div>
</body>
</html>
