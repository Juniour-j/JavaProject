<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${purchase.id == null ? 'Add' : 'Edit'} Purchase</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>${purchase.id == null ? 'Add New' : 'Edit'} Purchase</h1>

    <form:form modelAttribute="purchase" action="${pageContext.request.contextPath}/purchases/save" method="post">
        <form:hidden path="id" />

        <div class="mb-3">
            <label for="customerId" class="form-label">Customer</label>
            <form:select path="customerId" class="form-select">
                <form:option value="" label="-- Select Customer --"/>
                <c:forEach var="customer" items="${customers}">
                    <form:option value="${customer.id}" label="${customer.name}"/>
                </c:forEach>
            </form:select>
            <form:errors path="customerId" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="productId" class="form-label">Product</label>
            <form:select path="productId" class="form-select">
                <form:option value="" label="-- Select Product --"/>
                <c:forEach var="product" items="${products}">
                    <form:option value="${product.id}" label="${product.name}"/>
                </c:forEach>
            </form:select>
            <form:errors path="productId" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="purchaseDate" class="form-label">Purchase Date</label>
            <form:input path="purchaseDate" class="form-control" type="date" />
        </div>

        <div class="text-end">
            <a href="${pageContext.request.contextPath}/purchases" class="btn btn-secondary">Cancel</a>
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form:form>
</div>
</body>
</html>
