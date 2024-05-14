

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Registration() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Assuming this code is within a servlet class

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("name");
		String mail = request.getParameter("mail");
		String psw = request.getParameter("psw");
	

		String qry = "INSERT INTO student(name, mail, psw) VALUES (?, ?, ?)";

		try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pyq", "root", "root");
		   PreparedStatement stmt = con.prepareStatement(qry);

		   stmt.setString(1, username);
		   stmt.setString(2, mail);
		   //stmt.setString(3, dob);
		   stmt.setString(3, psw);
		   //stmt.setString(5, ano);

		   stmt.executeUpdate();

		   response.sendRedirect("Pyqspage.html");

		} catch (Exception e) {
		   System.out.println(e);
		} finally {
		   if (out != null) {
		       try {
		           out.close();
		       } catch (Exception e) {
		           // Handle any potential errors while closing the PrintWriter
		    	   response.sendRedirect("login.html");
		       }
		   }
		}

	}

}
