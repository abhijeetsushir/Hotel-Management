

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class contact
 */
@WebServlet("/contact")
public class contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String subject = request.getParameter("subject");
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
			Connection con1 = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/hotel"
							,"root","Mp09qx3169#");
			System.out.println("Connection Created!");
			String qry = "insert into contact values(?,?,?)";
			PreparedStatement pr1 = con1.prepareStatement(qry);
			pr1.setString(1, name);
			pr1.setString(2, contact);
			pr1.setString(3, subject);
			
			int i = pr1.executeUpdate();
			response.getWriter().append("<h1>Your Message is Successfully Submitted. </h1><a href='index.html'>Go to Index page</a>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	}


