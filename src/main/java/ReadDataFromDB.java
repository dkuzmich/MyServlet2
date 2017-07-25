import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        getServletContext().getRequestDispatcher("/MyJSP.jsp").forward(req, resp);


    }
}
