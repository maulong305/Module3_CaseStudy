<%--
  Created by IntelliJ IDEA.
  User: maulo
  Date: 8/7/2020
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
    <h1>User Management</h1>

    <h2>
        <a href="/product?action=create">Add New User</a>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Show Product</h2></caption>
        <c:if test="${product != null}">
            <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
        </c:if>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.brand}</td>
                <td>${product.price}</td>
                <td>
                    <a href="/product?action=edit&id=${product.id}">Edit</a>
                    <a href="/product?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
    </table>
</div>
</body>
</html>
