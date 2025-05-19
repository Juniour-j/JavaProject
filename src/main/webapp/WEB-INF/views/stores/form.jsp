<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${store.id == null ? 'Add' : 'Edit'} Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>${store.id == null ? 'Add New' : 'Edit'} Store</h1>

    <form:form modelAttribute="store" method="post" action="${pageContext.request.contextPath}/stores/save">
        <form:hidden path="id" />

        <div class="mb-3">
            <label class="form-label">Name</label>
            <form:input path="name" class="form-control"/>
            <form:errors path="name" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Location</label>
            <form:input path="location" class="form-control"/>
            <form:errors path="location" cssClass="text-danger"/>
        </div>

        <div class="text-end">
            <a href="${pageContext.request.contextPath}/stores" class="btn btn-secondary">Cancel</a>
            <button type="submit" class="btn btn-success">Save</button>
        </div>
    </form:form>
</div>
</body>
</html>
