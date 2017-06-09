/**
 * Created by dkuzmich on 5/24/2017.
 *
 *
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/requestLoggingFilter")
public class requestLoggingFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.context =filterConfig.getServletContext();
        this.context.log("requestLoggingFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        Enumeration<String> params=req.getParameterNames();
        while(params.hasMoreElements()){
            String name=params.nextElement();
            String value =request.getParameter(name);
            this.context.log(req.getRemoteAddr()+"::Request param::{"+name+"="+value+"}");

        }

        Cookie[] cookies=req.getCookies();
        if(cookies!=null){
            for (Cookie cookie:cookies){
                this.context.log(req.getRemoteAddr()+"::Cookies::"+cookie.getName()+", "+cookie.getValue() );
            }
        }

            chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
