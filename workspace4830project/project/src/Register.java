

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String password = request.getParameter("psw1");
        String password2 = request.getParameter("psw2");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        if (password.equals(password2))
        {
        Connection connection = null;
        String sql = "INSERT INTO user (id, EMAIL, PASSWORD, NAME, PHONE) values (default, ?, ?, ?, ?)";
        try
        {
        	DBConnection.getDBConnection();
        	connection = DBConnection.connection;
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, password);
            preparedStmt.setString(3, name);      
            preparedStmt.setString(4, phone);   
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
              "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap.min.css\"></head>\n" + //
              "<body bgcolor=\"#f0f0f0\">\n" + //
              "<h2 align=\"center\">" + title + "</h2>\n" +
              "  <p align=\"center\">" + name + "</p>\n" + //
              "  <p align=\"center\">" + email + "</p>\n" + //
              "  <p align=\"center\">" + password + "</p>\n" + //
              "  <p align=\"center\">" + phone + "</p>\n" + //
        "<p align=\"center\">Sign in here <a href=\"login.html\">Sign in</a>.</p>"
        		);
        out.println("</body></html>");
        }
        else
        {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String title = "Registeration Failed!";
            String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
            out.println(docType + //
                  "<html>\n" + //
                  "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap.min.css\">\n"+
                  "<style> .content {max-width: 500px; margin: auto; }</style>\n" +
                  "</head>\n" + //
                  "<body bgcolor=\"#f0f0f0\">\n" + //
                  "<div class=\"content\">" +
                  "<h2 align=\"center\">" + title + "</h2>\n" + //
                  "  <p align=\"center\">" + "Two password not match" + "</p>\n" + //
                  "<p align=\"center\">Try to register again here! <a href=\"register.html\">Register</a>.</p>" +
                  "</div>" 
                    );
            out.println("</body></html>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
