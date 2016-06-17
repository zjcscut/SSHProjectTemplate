<%--
  Created by IntelliJ IDEA.
  User: zhangjinci
  Date: 2016/6/8
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>地址多个</title>
</head>
<body>
<c:if test="${ok}">
    <c:forEach var="item" items="${areas}">
        <ul>
            <li>id:${item.id}</li>
            <li>name:${item.name}</li>
            <li>pid:${item.pid}</li>
        </ul>
    </c:forEach>

</c:if>

</body>
</html>
