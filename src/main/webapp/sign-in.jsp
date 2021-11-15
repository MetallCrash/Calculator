<%--
  Created by IntelliJ IDEA.
  User: PukanBombit
  Date: 04.11.2021
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<ul class="nav justify-content-center">
    <c:if test="${empty sessionScope.sessionId}">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="registration">Registration</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="sign-in">Sign in</a>
        </li>
    </c:if>
    <c:if test="${not empty sessionScope.sessionId}">
        <li class="nav-item">
            <a class="nav-link" href="calc">Calculator</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="operation">My operations</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="log-out">Log out</a>
        </li>
    </c:if>
    <c:if test="${sessionScope.user.get().role=='ADMIN'}">
        <li class="nav-item">
            <a class="nav-link" href="users">Users</a>
        </li>
    </c:if>
</ul>
<form action="sign-in" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input name="login" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
<p>${requestScope.message}</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
