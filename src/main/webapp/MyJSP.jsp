<%@ page import="java.util.ArrayList" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dimas.com</title>
</head>
<body>
<h1>You login successful! </h1>

<h1>Hello ${user}</h1>>
<%

    String user=null;
    if(session.getAttribute("user")==null){
        response.sendRedirect("login.jsp");
    }
    else user=(String) session.getAttribute("user");

    String userName=null;
    String sessionID=null;
    Cookie [] cookies=request.getCookies();
    if(cookies!=null){
        for (Cookie cookie: cookies){
            if(cookie.getName().equals("user")) userName=cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID=cookie.getValue();

        }
    }
%>

<h3> Hi <%=userName %>, Login Successful.</h3>
You session ID=<%=sessionID %>
<br>


<form action="UploadDownloadFileServlet" method="post" enctype="multipart/form-data">
    Select File to Upload:<input type="file" name="fileName">
    <br>
    <input type="submit" value="Upload">
</form>

<br>

<h2>Upload File Response</h2>
<h2>${requestScope.message}</h2>
<h2>${requestScope.mFileInfo}</h2>
<a href=${requestScope.mFileInfo} > Download File</a>
<br>



<br>

Read info from Table:
<form action="ReadDataFromDB" method="post">
    <input type="submit" value="ReadFromDB">
    <br>
</form>
<br>

<br>

<h3>Reguister new user</h3>
<form action="RegisterUser" method="post">
    <strong>Email </strong>:<input type="text" name="Remail"><br>
    <strong>Password</strong>:<input type="password" name="Rpassword">
    <strong>Name</strong>:<input type="text" name="Rname"><br>
    <strong>Country</strong>:<input type="text" name="Rcountry"><br>
    <input type="submit" value="Register">

</form>

<br>
<br>
    Please LogOut after work
<form action="LogoutServlet" method="post">
 <input type="submit" value="Logout">
</form>

<br>
<a href="login.jsp">BACK to Login page</a>
<br>

</body>
</html>