

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class control2
 */
public class control2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public control2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vid=request.getParameter("name");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chinna","root","nani");
			PrintWriter out= response.getWriter();

			HttpSession session=request.getSession();
			String s=(String)session.getAttribute("usern");
			PreparedStatement ps =con.prepareStatement("select point from media1 where videoid=? and username=?");
			ps.setString(1, vid);
			ps.setString(2, s);
			ResultSet rs=ps.executeQuery();
			int c=1;
			if(!rs.next())
			getServletContext().getRequestDispatcher("/existing.jsp").include(request, response);
			
			out.print("<html><body>");
			out.print("<table border=1 width=30% height=30%>");
			out.print("<tr><th>point</th></tr>");
			
			rs.previous();
			while(rs.next())
			{
				
				if(c==1)
				getServletContext().getRequestDispatcher("/existing.jsp").include(request, response);
				
				String s1=rs.getString("point");
				out.println("<tr><td>"+s1+"</td></tr>");
				
				c++;
			}
			out.print("</table>");
			out.print("</html></body>");
			
			
	}
		catch(Exception e){
			e.printStackTrace();
		}


         }
}
