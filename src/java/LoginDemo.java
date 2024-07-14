import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginDemo extends HttpServlet
{
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("u1");
		String s2 = request.getParameter("u2");
		
		out.println("<html>");
		out.println("<body>");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///ajava88?useSSL=false","root","root");
			Statement st = con.createStatement();
			String q = "select * from regis where UNAME='"+s1+"' AND UPASS='"+s2+"'";
			ResultSet rs = st.executeQuery(q);
			if(rs.next())
			{
                            //Cookie ck=new Cookie("UNAME",s1);
                            //ck.setMaxAge(60*60);
                            //response.addCookie(ck);
                            
                            HttpSession session = request.getSession();
                            session.setAttribute("uname",s1);
                            response.sendRedirect("MenuDemo");
			}
			else
			{
			response.sendRedirect("logindemo.html");
			}
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