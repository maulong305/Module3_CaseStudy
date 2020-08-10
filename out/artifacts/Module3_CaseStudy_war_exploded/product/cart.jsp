<%--
  Created by IntelliJ IDEA.
  User: maulo
  Date: 8/4/2020
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <script src="js/bootstrap.bundle.js"></script>
    <script src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/bootstrap-reboot.css">
    <link rel="stylesheet" href="css/bootstrap-grid.css">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div style="text-align: center;">
       <h2>
        <a href="/product">Home</a>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Cart</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Price</th>
            <th>ImgItem</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="cart" items="${listCart}">
            <tr>
                <td><a href="/cart?action=show&id=${cart.id}"><c:out value="${cart.id}"/></a></td>
                    <%--                <td><a href="/product?action=show&nid=${product.id}"><c:out value="${product.name}"/></a></td>--%>
                <td><c:out value="${cart.name}"/></td>
                <td><c:out value="${cart.brand}"/></td>
                <td><c:out value="${cart.price}"/></td>
                <td><c:out value="${cart.imgItem}"/></td>
                <td>
                    <a href="/cart?action=delete&id=${cart.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
