import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='mymenu'>");
		out.println("<u1><li>Home</li><li><a href='InsertDemo.html'> Insert </a></li><li><a href='searchdemo.html'> Search </a></li><li><a href='UpdateDemo.html'> Update </a></li><li><a href='ShowAll'> ShowAll </a></li><li><a href='DeleteDemo.html'> Delete </a></li><li><a href='Logout.html'> Logout </a></li></ul> ");
		out.println("</div>");
		
		out.println("<div id='mydata'>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava88?useSSL=false","root","root");
			Statement st = con.createStatement();
			String s1 = request.getParameter("u1");
			String q = "delete from insmarks where UNAME='"+s1+"'";
			st.executeUpdate(q);
			response.sendRedirect("ShowAll");
                        out.println("</div>");
			
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