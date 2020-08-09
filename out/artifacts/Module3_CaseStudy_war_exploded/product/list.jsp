<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maulo
  Date: 8/4/2020
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Product Management</h1>

    <h2>
        <a href="/product?action=create">Add New Product</a>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><a href="/product?action=show&id=${product.id}"><c:out value="${product.id}"/></a></td>
<%--                <td><a href="/product?action=show&nid=${product.id}"><c:out value="${product.name}"/></a></td>--%>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.brand}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td>
                    <a href="/product?action=edit&id=${product.id}">Edit</a>
                    <a href="/product?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
