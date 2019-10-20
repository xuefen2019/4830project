

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Register")
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
		String email = request.getParameter("email");
        String password = request.getParameter("psw");
        String name = request.getParameter("name");
        
        Connection connection = null;
        String sql = "INSERT INTO exercise (id, EMAIL, PASSWORD, NAME) values (default, ?, ?, ?)";
        try
        {
        	DBConnection.getDBConnection();
        	connection = DBConnection.connection;
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, password);
            preparedStmt.setString(3, name);        
            preparedStmt.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Registeration Completed!";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType + //
              "<html>\n" + //
              "<head><title>" + title + "</title></head>\n" + //
              "<body bgcolor=\"#f0f0f0\">\n" + //
              "<h2 align=\"center\">" + title + "</h2>\n" + //
              "<ul>\n" + //
              "  <li><b>User Name</b>: " + name + "\n" + //
              "  <li><b>Email</b>: " + email + "\n" + //
              "  <li><b>password</b>: " + password + "\n" + //

        "<p>Sign in here <a href=\"login.html\">Sign in</a>.</p>" +

                "</ul>\n");
        out.println("</body></html>");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
