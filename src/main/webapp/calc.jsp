<%--
  Created by IntelliJ IDEA.
  User: PukanBombit
  Date: 04.11.2021
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="calc" method="post">
    <input name="num1" type="text" placeholder="Number 1">
    <input name="action" type="text" placeholder="Operation">
    <input name="num2" type="text" placeholder="Number 2">
    <button>Calculate</button>
</form>
<p>${requestScope.message}${requestScope.result}</p>
<form action="operation" method="post">
    <p>Watch my operation history.</p>
    <button>Watch</button>
</form>
</body>
</html>
