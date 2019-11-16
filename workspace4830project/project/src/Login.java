

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean tem = false;
        Connection connection = null;
        String sql = "SELECT * FROM user WHERE EMAIL=? and PASSWORD=?";
        String a = "Sorry, wrong password or email, plz try again";
        try
        {
        	DBConnection.getDBConnection();
        	connection = DBConnection.connection;
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, password);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                String userNametem = rs.getString("name").trim();
                a = "Congratulation!! User: " + userNametem;
                tem = true;
             }
            rs.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Home Page";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType + //
              "<html>\n" + //
              "<head><title>" + title + "</title></head>\n" + //
              "<body bgcolor=\"#f0f0f0\">\n" + //
              "<h2 align=\"center\">" + title + "</h2>\n" + //
              "<ul>\n" + //
              "  <li><b></b> " + a + "\n" + //
              "<p>Try to login again here <a href=\"login.html\">Sign in</a>.</p>" +
                "</ul>\n");
        out.println("</body></html>");
        if (tem == true)
        {
        response.sendRedirect("order.html");
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
