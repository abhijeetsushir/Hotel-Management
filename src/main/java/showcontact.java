

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAll1
 */
@WebServlet("/showcontact")
public class showcontact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showcontact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
			Connection con1 = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/hotel"
							,"root","Mp09qx3169#");
			System.out.println("Connection Created!");
			String qry = "select * from contact";
			PreparedStatement pr1 = con1.prepareStatement(qry);
			ResultSet rs = pr1.executeQuery();
			response.getWriter().append("<h1>Customer messages</h1>");
			response.getWriter().append("<table border='2px'><tr> <th>Sno.</th> <th>Name</th>");
			response.getWriter().append("<th>Contact</th> <th>Subject</th> </tr>");
			
			
			int i=1;
			while(rs.next())
			{
				response.getWriter().append("<tr>");
				response.getWriter().append("<td>"+ i +"</td>");
				response.getWriter().append("<td>"+ rs.getString(1)+"</td>");
				response.getWriter().append("<td>"+ rs.getString(2)+"</td>");
				response.getWriter().append("<td>"+ rs.getString(3)+"</td>");
				
				
				response.getWriter().append("</tr>");
				i++;
			} 
			
			response.getWriter().append("</table>");
			response.getWriter().append("<a href='adminpage.html'>Click to GO Back</a>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
