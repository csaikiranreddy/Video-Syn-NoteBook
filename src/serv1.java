

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
 * Servlet implementation class serv1
 */
public class serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serv1() {
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
		
		String txt=request.getParameter("tarea");
		String vid=request.getParameter("vid");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chinna","root","nani");
			//PrintWriter out= response.getWriter();

			HttpSession session=request.getSession();
			String s1=(String)session.getAttribute("usern");
			PreparedStatement ps =con.prepareStatement("insert into media1 values(?,?,?)");
			ps.setString(1, vid);
			ps.setString(2, txt);
			ps.setString(3, s1);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				getServletContext().getRequestDispatcher("/logout.jsp").forward(request, response);
				
			}
			else
			{
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}
	}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
