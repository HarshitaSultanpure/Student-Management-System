import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
                out.println("<html>");
                
                String s1=request.getParameter("u1");
                String s2=request.getParameter("u2");
                String s3=request.getParameter("u3");
                String s4=request.getParameter("u4");
                String s5=request.getParameter("u5");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava88?useSSL=false","root","root");
			Statement st = con.createStatement();
			String q = "update insmarks set UPASS='"+s2+"',PHY='"+s3+"',CHE='"+s4+"',MATH='"+s5+"' where UNAME='"+s1+"'";
			st.executeUpdate(q);
			
			response.sendRedirect("ShowAll");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body>");
		out.println("</html>");
	}
}