import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LogoutDemo extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        //Cookie ck=new Cookie("UNAME","");
        //ck.setMaxAge(0);
        //response.addCookie(ck);
        
        HttpSession session=request.getSession();
        session.invalidate();
        
        response.sendRedirect("logindemo.html");
    }
}