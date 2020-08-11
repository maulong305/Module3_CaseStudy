<%--
  Created by IntelliJ IDEA.
  User: maulo
  Date: 8/9/2020
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Bootstrap core CSS -->
    <link href="/docs/4.5/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/4.5/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/4.5/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/4.5/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/4.5/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/4.5/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
    <link rel="icon" href="/docs/4.5/assets/img/favicons/favicon.ico">
    <meta name="msapplication-config" content="/docs/4.5/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <script src="cssfile/js/bootstrap.bundle.js"></script>
    <script src="cssfile/js/bootstrap.js"></script>
    <link href="album.css" rel="stylesheet">
    <link rel="stylesheet" href="cssfile/css/bootstrap.css">
    <link rel="stylesheet" href="cssfile/css/bootstrap-grid.css">
    <link rel="stylesheet" href="cssfile/css/bootstrap-reboot.css">
</head>
<body>

<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) userName = cookie.getValue();
        }
    }
    if (userName == null) response.sendRedirect("/login");
%>
<h6>Hi <%=userName %>, Login successful.</h6>
<br>
<a href="/product?action=create">
    <button>Add new Product</button>
</a>
<a href="/user">
    <button>User Management</button>
</a>
<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white">About</h4>
                    <p class="text-muted">Add some information about the album below, the author, or any other
                        background context. Make it a few sentences long so folks can pick up some informative tidbits.
                        Then, link them off to some social networking sites or contact information.</p>
                </div>
                <div class="col-sm-4 offset-md-1 py-4">
                    <h4 class="text-white">Contact</h4>
                    <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Follow on Twitter</a></li>
                        <li><a href="#" class="text-white">Like on Facebook</a></li>
                        <li><a href="#" class="text-white">Email me</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container d-flex justify-content-between">
            <a href="#" class="navbar-brand d-flex align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor"
                     stroke-linecap="round" stroke-linejoin="round" stroke-width="2" aria-hidden="true" class="mr-2"
                     viewBox="0 0 24 24" focusable="false">
                    <path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path>
                    <circle cx="12" cy="13" r="4"></circle>
                </svg>
                <strong>Album</strong>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader"
                    aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
</header>

<main role="main">
    <div class="album py-5 bg-light">
        <div class="container">

            <div class="row">
                <c:forEach var="product" items="${listProduct}">
                <div class="col-md-4 col-sm-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="${product.imgItem}" width="100%" height="100%">
                        <div>
                            <lable> Product Name :</lable><span style="font-style: italic"><c:out value="${product.name}"/></span>
                            <br>
                            <lable>Price :</lable><span><c:out value="${product.price}"/></span>
                        </div>
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <a href="product?action=view&id=${product.id}">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                    </a>
                                    <a href="/product?action=edit&id=${product.id}">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Update</button>
                                    </a>
                                    <a href="/product?action=delete&id=${product.id}">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Delete</button>
                                    </a>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>


</main>


</body>
</html>
