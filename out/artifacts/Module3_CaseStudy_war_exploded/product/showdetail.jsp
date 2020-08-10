<%--
  Created by IntelliJ IDEA.
  User: maulo
  Date: 8/10/2020
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../cssfile/js/bootstrap.bundle.js"></script>
    <script src="../cssfile/js/bootstrap.js"></script>
    <title>${requestScope.product.name}</title>
    <link rel="stylesheet" href="../cssfile/css/bootstrap.css">
    <link rel="stylesheet" href="../cssfile/css/bootstrap-grid.css">
    <link rel="stylesheet" href="../cssfile/css/bootstrap-reboot.css">

</head>
<body style="background-image: linear-gradient(#5aabd0, #ffffff);">
<%--Header--%>
<!--Content-->
<div class="container-fluid">
<div class="col-lg-3 col-md-4 mb-3">
    <div class="card h-10">
        <h1 style="color: #2A2A2A">${requestScope.product.name}</h1>
        <a href="product?action=detail&id=${product.id}">
            <img src="<c:url value="${product.imgItem}"/>" class="card-img-top" alt="...">
        </a>
        <div >
        <table class="table table-borderless">
            <tbody>
            <tr>
                <th scope="row"><h2><small>Name: </small></h2></th>
                <td><h2><small>${requestScope.product.name}</small></h2></td>
            </tr>
            <tr>
                <th scope="row"><h2><small>Brand: </small></h2></th>
                <td><h2><small>${requestScope.product.brand}</small></h2></td>
            </tr>
            <tr>
                <th scope="row"><h2><small>Price: </small></h2></th>
                <td><h2><small>${requestScope.product.price}</small></h2></td>
            </tr>
            </tbody>
        </table>
    </div>
    <a href="/cart?action=cart&id=${requestScope.product.id}">
        <button type="button" class="btn btn-primary" style="width: 100%; height: 60px; margin-right: 0">Add to Cart</button>
    </a>
</div>
    <div>
        <a href="/cart?action=show&id=${requestScope.product.id}"><button type="button" class="btn btn-primary" style="width: 100%; height: 60px; margin-right: 0">Show Cart</button></a>
    </div>
</div>
</div>

<%--Footer--%>
</body>
</html>