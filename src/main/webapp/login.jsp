<%--
  Created by IntelliJ IDEA.
  User: dkuzmich
  Date: 5/12/2017
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="LoginServlet" method="post">
   Username: <input type="text" name="user">
   <br>
    Password: <input type="password" name="pwd">
    <br>
    <input type="submit" value="Login">

</form>

</body>
</html>
