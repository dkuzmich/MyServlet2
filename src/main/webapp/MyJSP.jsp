<%--
  Created by IntelliJ IDEA.
  User: dkuzmich
  Date: 19.04.2017
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devcolibri.com</title>
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

<h3> Hi <%=userName %>, Login Successful. You session ID=<%=sessionID %></h3>



<form action="UploadDownloadFileServlet" method="post" enctype="multipart/form-data">
    Select File to Upload:<input type="file" name="fileName">
    <br>
    <input type="submit" value="Upload">
</form>

<h2>Upload File Response</h2>
<h2>${requestScope.message}</h2>

<a href="login.jsp">BACK to Login page</a>
<br>
Please LogOut after work
<form action="LogoutServlet" method="post">
 <input type="submit" value="Logout">

</form>
</body>
</html>