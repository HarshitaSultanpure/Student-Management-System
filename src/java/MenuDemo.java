import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MenuDemo extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        PrintWriter out=response.getWriter();
        //String s1=request.getParameter("u1");
        //String s2=request.getParameter("u2");
        
        //Cookie ck[]=request.getCookies();
        HttpSession session=request.getSession();
        String s1=(String)session.getAttribute("uname");
        if(s1!=null)
        {
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel = 'stylesheet' href = 'abc.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='InsertDemo' method='post'>");
            out.println("<div id='mymenu'>");
            out.println("<ul>");
            out.println("<li> Home </li>");
            out.println("<li> <a href = 'InsertDemo.html' style='text-decoration:none'> Insert </a> </li>");
            out.println("<li> <a href = 'searchdemo.html' style='text-decoration:none'> Search </a> </li>");
            out.println("<li> <a href = 'UpdateDemo.html' style='text-decoration:none'> Update </a> </li>");
            out.println("<li> <a href = 'ShowAll' style='text-decoration:none'> ShowAll </a> </li>");
            out.println("<li> <a href = 'DeleteDemo.html' style='text-decoration:none'> Delete </a> </li>");
            out.println("<li> <a href = 'LogoutDemo' style='text-decoration:none'> Logout </a> </li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("<center>");
            //out.println("Welcome  "+ck[0].getValue());
            out.println("Welcome "+s1);
            out.println("</center>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.println("");
        }
        else
        {
            response.sendRedirect("logindemo.html");
        }
    }
}