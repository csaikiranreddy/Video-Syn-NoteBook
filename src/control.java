

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class control
 */
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usr=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chinna","root","nani");
			
			PreparedStatement ps =con.prepareStatement("select * from login where uname=? and password=?");
			ps.setString(1, usr);
			ps.setString(2, pwd);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				HttpSession session=request.getSession();
				session.setAttribute("usern", usr);
				getServletContext().getRequestDispatcher("/furl.jsp").include(request, response);
				
				PreparedStatement ps2 =con.prepareStatement("select distinct videoid from media1 where username=?");
				ps2.setString(1, usr);
				ResultSet rs2=ps2.executeQuery();
				PrintWriter out=response.getWriter();
				out.print("<h3>your past videoid's:</h3>");
				
				out.print("<html><body>");
				out.print("<table border=1 width=30% height=30%>");
				out.print("<tr><th>Videoid</th></tr>");
				int c=1;
				while(rs2.next())
				{
					
					
					String s1=rs2.getString("videoid");
					out.println("<tr><td>"+s1+"</td></tr>");
					
					c++;
				}
				out.print("</table>");
				out.print("</html></body>");
				
				
			}
			else
			{
				getServletContext().getRequestDispatcher("/error2.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			
		}
	}
	}


