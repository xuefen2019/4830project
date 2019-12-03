

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String user = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
        String name = request.getParameter("NAME");
        
        Connection connection = null;
        String sql = "UPDATE ordered SET STATUS ='Completed' where id = ? and NAME = ?";
        try
        {
        	DBConnection.getDBConnection();
        	connection = DBConnection.connection;
        	PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, name);
            preparedStmt.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("admin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
