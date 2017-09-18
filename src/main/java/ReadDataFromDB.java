import dimas.com.DBCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dkuzmich on 6/21/2017.
 */
@WebServlet("/ReadDataFromDB")
public class ReadDataFromDB extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        DBCon dbCon=new DBCon();
        dbCon.dbConnection();
        dbCon.getDatafromDB();
        dbCon.getUsetListfromDB();

        ArrayList usrList=dbCon.getUsetListfromDBinListFormat();
        req.setAttribute("userlistdb",usrList);

        getServletContext().getRequestDispatcher("/UserList.jsp").forward(req, resp);


    }
/*    public void getDataTable(){
        ArrayList usrList;


        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");

        usrList=dbCon.getUsetListfromDBinListFormat();
        out.print("<html><body><h2>Employee Details</h2>");
        out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
        out.print("<th>Employee Name</th>");
        out.print("<th>Employee Email</th>");
        out.print("<th>Employee Country</th>");
        out.print("<th>Employee Pass</th>");
        for(int y=0; y<usrList.size();y++){
            User user= (User)usrList.get(y);
            out.print("<tr>");
            out.print("<td>"+user.getName()+"</td>");
            out.print("<td>"+user.getEmail()+"</td>");
            out.print("<td>"+user.getCountry()+"</td>");
            out.print("<td>"+user.getPass()+"</td>");

        }
        out.print("</table></body><br/>");
        out.print("</html>");

    }*/
}
