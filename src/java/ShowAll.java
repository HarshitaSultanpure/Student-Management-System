import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ShowAll extends HttpServlet
{
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException
	{
            System.out.println("Comming in mrnu demo");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='mymenu'>");
		out.println("<u1><li>Home</li><li><a href='InsertDemo.html' style='text-decoration:none'> Insert </a></li><li><a href='searchdemo.html' style='text-decoration:none'> Search </a></li><li><a href='UpdateDemo.html' style='text-decoration:none'> Update </a></li><li><a href='ShowAll' style='text-decoration:none'> ShowAll </a></li><li><a href='DeleteDemo.html' style='text-decoration:none'> Delete </a></li><li><a href='Logout.html' style='text-decoration:none'> Logout </a></li></ul> ");
		out.println("</div>");
		
		out.println("<div id='mydata'>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava88?useSSL=false","root","root");
			Statement st = con.createStatement();
			String q = "select * from insmarks";
			ResultSet rs = st.executeQuery(q);
			out.println("<center>");
			out.println("<table cellpadding='12'>");
			out.println("<tr>");
			out.println("<td> RNO </td>");
			out.println("<td> Name </td>");
			out.println("<td> Phy </td>");
			out.println("<td> Che </td>");
			out.println("<td> Maths </td>");
			out.println("</tr>");
			
			while(rs.next())
			{
			out.println("<tr>");
			out.println("<td>" + rs.getString(1) + "</td>");
			out.println("<td>" + rs.getString(2) + "</td>");
			out.println("<td>" + rs.getString(3) + "</td>");
			out.println("<td>" + rs.getString(4) + "</td>");
			out.println("<td>" + rs.getString(5) + "</td>");
			out.println("</tr>");
			}
			out.println("</table>");
			out.println("</center>");
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