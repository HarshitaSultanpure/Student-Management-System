import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Search extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        PrintWriter out=response.getWriter();
        
        out.println("<html>");
        out.println("<body>");
		
        out.println("<div id='mydata'>");
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql:///ajava88?useSSL=false","root","root");
            Statement st=con.createStatement();
            String s1=request.getParameter("u1");
            String q="select * from insmarks where UNAME='"+s1+"'";
            ResultSet rs=st.executeQuery(q);
            out.println("<center>");
                        out.println("<form action='update'>");
			out.println("<table cellpadding='12'>");
			
            if(rs.next())
            {
                
                out.println("<tr>");
                out.println("<td><input type='text' name='u1' value='"+rs.getString(1)+"'></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                out.println("<td><input type='text' name='u2' value='" + rs.getString(2) + "'></td>");
               out.println("</tr>");	
               
                out.println("<tr>");
                out.println("<td><input type='text' name='u3' value='"+rs.getString(3)+"'></td>");
                out.println("</tr>");
                
                
                out.println("<tr>");
                out.println("<td><input type='text' name='u4' value='"+rs.getString(4)+"'></td>");
                out.println("</tr>");
                
                
                out.println("<tr>");
                out.println("<td><input type='text' name='u5' value='"+rs.getString(5)+"'></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                out.println("<th colspan='5'> <input type='submit' value='update'></th>");
                out.println("</tr>");
            }
            else
            {
                out.print("invalid");
            }
            out.println("</table >");
	out.println("</form>");
			
            out.println("</center>");
                        
        }
        catch(Exception e)
        {
            out.println(e);
        }
        
        
        
        out.println("</body>");
        out.println("</html>");
    }
}