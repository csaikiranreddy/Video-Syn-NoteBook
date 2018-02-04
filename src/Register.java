

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String usr=request.getParameter("usr");
		String pwd=request.getParameter("pass");
		String pwd2=request.getParameter("pass2");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chinna","root","nani");
			//PrintWriter out= response.getWriter();
			if(pwd.equals(pwd2))
			{
			PreparedStatement ps =con.prepareStatement("insert into login values(?,?)");
			ps.setString(1, usr);
			ps.setString(2, pwd);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				getServletContext().getRequestDispatcher("/ulogin.jsp").forward(request, response);
				
			}
			else
			{
				getServletContext().getRequestDispatcher("/error2.jsp").forward(request, response);
			}
			}
			else
			{
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			
		}
	}

}
