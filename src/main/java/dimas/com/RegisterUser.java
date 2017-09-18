package dimas.com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = (String) req.getParameter("Remail");
       String password = (String)  req.getParameter("Rpassword");
       String name = (String) req.getParameter("Rname");
       String country = (String)  req.getParameter("Rcountry");
        DBCon dbcon=new DBCon();
        System.out.println(dbcon.checkIfExistUserInDB(name,email));
        dbcon.addRegisteredUserToDB(name,email,password,password);
        dbcon.getDatafromDB();

       System.out.println("Hello "+name+" from "+country+"with Mail = "+email);

       getServletContext().getRequestDispatcher("/MyJSP.jsp").forward(req,resp);

    }
}
