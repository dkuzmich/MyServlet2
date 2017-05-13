import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dkuzmich on 19.04.2017.
 */
@WebServlet("/")
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String logUser=req.getParameter("user");
        String logPass=req.getParameter("pwd");
        String pass = "Dima";
        String username = "Dima";
        if (username.equals(logUser)&& pass.equals(logPass)){
            req.setAttribute( "user", "logUser");
            req.getRequestDispatcher("MyJSP.jsp").forward(req,resp);
        }else
        {
            resp.sendRedirect("FailLogin.jsp");
        }
    }
}
