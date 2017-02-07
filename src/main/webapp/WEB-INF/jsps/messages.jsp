<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
    <c:forEach var="msg" items="${msgs}">
        <tr>
            <td><b>${msg.user.name}</b> : <c:out value="${msg.text}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
