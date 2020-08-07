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
        <tr>
            <th>ID</th>
            <th>UserName</th>
            <th>Email</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Actions</th>
        </tr>
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.phone}</td>
                <td>
                    <a href="/user?action=edit&id=${user.id}">Edit</a>
                    <a href="/user?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
    </table>
</div>
</body>
</html>
