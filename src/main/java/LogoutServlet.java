import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by dkuzmich on 5/24/2017.
 */
@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet{
    private static final long serialVersionUID=1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     resp.setContentType("text/html");
        Cookie [] cookies=req.getCookies();
        if(cookies!=null){
            for (Cookie cookie:cookies){
                if(cookie.getName().equals("JSESSIONID")){
                    System.out.println("JSESSIONID="+cookie.getValue());
                    break;
                }
            }

        }

        HttpSession session=req.getSession(false);
        System.out.println("User="+session.getAttribute("user"));
        if(session!=null){
            session.invalidate();
        }
        resp.sendRedirect("login.jsp");
    }
}
