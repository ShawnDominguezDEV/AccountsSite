<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ya Boi
  Date: 10/23/2019
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="doSomething" method="post">
        <input type="hidden" name="fromPage" value="page2">
        <table border="1">
            <th>Number</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Password</th>
            <c:forEach var="pr" items="${asdf}">
                <tr>
                    <td>
                        <c:out value="${pr.user_id}"></c:out>
                    </td>

                    <td>
                        <c:out value="${pr.user_fn}"></c:out>
                    </td>

                    <td>
                        <c:out value="${pr.user_ln}"></c:out>
                    </td>

                    <td>
                        <c:out value="${pr.user_un}"></c:out>
                    </td>

                    <td>
                        <c:out value="${pr.user_pw}"></c:out>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <input type="number" name="userid" placeholder="id" required>
        <input type="text" name="userfn" placeholder="fn">
        <input type="text" name="userln" placeholder="ln">
        <input type="text" name="userun" placeholder="un">
        <input type="text" name="userpw" placeholder="pw"><br>

        <input type="submit" name="update" value="Update">
        <input type="submit" name="delete" value="Delete">
    </form>
</div>
</body>
</html>
