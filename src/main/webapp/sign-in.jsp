<%--
  Created by IntelliJ IDEA.
  User: PukanBombit
  Date: 04.11.2021
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<form action="sign-in" method="post">
    <input name="login" type="email" placeholder="Email">
    <input name="password" type="password" placeholder="password">
    <button>Sign in</button>
</form>
<p>${requestScope.message}</p>
</body>
</html>
