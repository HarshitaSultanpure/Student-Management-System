import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SearchDemo extends HttpServlet
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
		out.println("<u1><li>Home</li><li><a href='InsertDemo.html' style='text-decoration:none'> Insert </a></li><li><a href='searchdemo.html' style='text-decoration:none'> Search </a></li><li><a href='UpdateDemo.html'> Update </a></li><li><a href='ShowAll'> ShowAll </a></li><li><a href='DeleteDemo.html'> Delete </a></li><li><a href='Logout.html'> Logout </a></li></ul> ");
		out.println("</div>");
		
		out.println("<div id='mydata'>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava88?useSSL=false","root","root");
			Statement st = con.createStatement();
			String s1 = request.getParameter("u1");
			String q = "select * from insmarks where UNAME='"+s1+"'";
			ResultSet rs = st.executeQuery(q);
			out.println("<center>");
                        out.println("<form action='UpdateDemo'>");
			out.println("<table cellpadding='12'>");
			
			if(rs.next())
			{
			out.println("<tr>");
			out.println("<td> RNO </td>");
			out.println("<td><input type='text' name='u1' value='" + rs.getString(1) + "'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> Name </td>");
			out.println("<td><input type='text' name='u2' value='" + rs.getString(2) + "'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> Phy </td>");
			out.println("<td><input type='text' name='u3' value='" + rs.getString(3) + "'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> Che </td>");
			out.println("<td><input type='text' name='u4' value='" + rs.getString(4) + "'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td> Maths </td>");
			out.println("<td><input type='text' name='u5' value='" + rs.getString(5) + "'></td>");
			out.println("</tr>");
                        
                        out.println("<tr>");
                        out.println("<th colspan='2'><input type='submit' class='B' value='update'> </th>");
                        out.println("</tr>");
			}
			else
			{
                            out.println("Invalid RNO");
			}
			out.println("</table>");
                        out.println("</form>");
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