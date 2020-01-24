<%--
  Created by IntelliJ IDEA.
  User: Ya Boi
  Date: 10/23/2019
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <!--
    Assignment 2 - CIS 4318
    Fall 2019
    Produced By:
    Jonathan Mangus
    Shawn Dominguez
    -->
  </head>
  <body>
  <div>
  <form action="doSomething" method="post">
    <input type="hidden" name ="fromPage" value="startPage">

    <label>First Name:</label>
    <input type="text" name="fn" required><br>
    <label>Last Name:</label>
    <input type="text" name="ln" required><br>
    <label>User Name:</label>
    <input type="text" name="un" required><br>
    <label>Password:</label>
    <input type="password" name="pw" required><br>

    <input type="submit" value="SignUp" >

  </form>
  </div>



  </body>
</html>
