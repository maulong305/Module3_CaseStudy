<%--
  Created by IntelliJ IDEA.
  User: maulo
  Date: 8/4/2020
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product Management Application</title>
    <script src="js/bootstrap.bundle.js"></script>
    <script src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/bootstrap-reboot.css">
    <link rel="stylesheet" href="css/bootstrap-grid.css">
    <link rel="stylesheet" href="css/bootstrap.css">

</head>
<body>
<div style="text-align: center;">
    <h1>Product Management</h1>
    <h2>
        <a href="/product">Home</a>
    </h2>
</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${product.name}"
                    />
                </td>
            </tr>
            <tr>
                <th>Brand:</th>
                <td>
                    <input type="text" name="brand" size="45"
                           value="${product.brand}"
                    />
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="15"
                           value="${product.price}"
                    />
                </td>
            </tr>

            <tr>
                <th>ImgItem:</th>
                <td>
                    <input type="text" name="imgItem" size="15"
                           value="${product.imgItem}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
