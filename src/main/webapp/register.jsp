<%@ page import="dimas.com.RegisterUser" %><%--
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

<form action="RegisterUser" method="post">
    <strong>Email </strong>:<input type="text" name="Remail"><br>
    <strong>Password</strong>:<input type="password" name="Rpassword">
    <strong>Name</strong>:<input type="text" name="Rname"><br>
    <strong>Country</strong>:<input type="text" name="Rcountry"><br>
    <input type="submit" value="Register">

</form>


<form action="LoginServlet" method="post">
Username: <input type="text" name="user">
<br>
Password: <input type="password" name="pwd">
<br>
<input type="submit" value="Login">
<br>

If you are registered user, please <a href="login.jsp">login</a>.

</body>
</html>
