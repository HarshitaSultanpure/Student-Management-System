import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisDemo extends HttpServlet
{
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("u1");
		String s2 = request.getParameter("u2");
		String s3 = request.getParameter("u3");
		
		out.println("<html>");
		out.println("<body>");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///ajava88?allowPublicKeyRetrieval=true&&useSSL=false","root","root");
			Statement st = con.createStatement();
			String q = "insert into regis values('"+s1+"' , '"+s2+"' , '"+s3+"' )";
			st.executeUpdate(q);
			response.sendRedirect("logindemo.html");
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