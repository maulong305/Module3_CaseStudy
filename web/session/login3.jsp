<%--
  Created by IntelliJ IDEA.
  User: maulo
  Date: 8/8/2020
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form Login</title>
</head>
<body>
<div style="width: 500px; margin: 50px auto;background:#D0D01A;padding:30px">

    <form action="<%=request.getContextPath() %>/login" method="post" >
        <div>
            <label>Username: </label>
            <input type="text" name="username" value="" />
        </div>
        <br />
        <div>
            <label>Password: </label>
            <input type="password" name="password" value="" />
        </div>
        <br />
        <div>
            <input type="submit" name="submit" value="Login" />
            <input type="reset" name="reset" value="Reset" />
        </div>
    </form>
</div>
</body>
</html>