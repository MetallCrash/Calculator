<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>My operations</title>
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
<p>My operations:</p>
<c:forEach var="operation" items="${requestScope.operationList}">
    <c:out value="${operation.num1}${operation.action}${operation.num2}=${operation.result}"/><p/>
</c:forEach>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>