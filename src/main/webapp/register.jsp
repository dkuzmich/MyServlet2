<%--
  Created by IntelliJ IDEA.
  User: dkuzmich
  Date: 6/21/2017
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<h3>Provide all the fields for registration.</h3>
<form action="Register" method="post">
    <strong>Email </strong>:<input type="text" name="email"><br>
    <strong>Password</strong>:<input type="password" name="password">
    <strong>Name</strong>:<input type="text" name="name"><br>
    <strong>Country</strong>:<input type="text" name="country"><br>
    <input type="submit" value="Register">

</form>
If you are registered user, please <a href="login.jsp">login</a>.

</body>
</html>
