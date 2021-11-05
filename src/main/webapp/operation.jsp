<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>My operations</title>
</head>
<body>
<p>My operations:</p>
<c:forEach var="operation" items="${requestScope.operationList}">
    <c:out value="${operation.num1}${operation.action}${operation.num2}=${operation.result}"/><p/>
</c:forEach>
</body>
</html>