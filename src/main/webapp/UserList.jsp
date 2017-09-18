<%--
  Created by IntelliJ IDEA.
  User: dkuzmich
  Date: 8/1/2017
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list from DB</title>
</head>
<body>
<h2> Data from table: </h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Country</th>
        <th>Password</th>
    </tr>



     <% ArrayList userArrayList=(ArrayList) request.getAttribute("userlistdb");
     dimas.com.User usertemp;
     int sizeUserList=0;
     if(userArrayList !=null ){
     sizeUserList=userArrayList.size();
     }
     for(int i=0; i<sizeUserList;i++)
     {
          %><tr><%
         usertemp=(dimas.com.User) userArrayList.get(i);%>
        <td><%=usertemp.getName()%> </td>
        <td><%=usertemp.getCountry()%></td>
        <td><%=usertemp.getPass()%></td>

        </tr>   <%

     }

    %>

</table>

<br>
<br>
<a href="MyJSP.jsp">BACK to Main page</a>
<br>
</body>
</html>
