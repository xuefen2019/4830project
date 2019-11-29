

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Order
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tem3 = request.getParameter("paymentMethod");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String zip = request.getParameter("zip");
		String tem1 = Login.user;
		String tem2 = Order.Food;
		
        Connection connection = null;
        String sql = "INSERT INTO ordered (id, NAME, FOOD, PAY, ADDRESS, STATUS) values (default, ?, ?, ?, ?, ?)";
        try
        {
        	DBConnection.getDBConnection();
        	connection = DBConnection.connection;
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, tem1);
            preparedStmt.setString(2, tem2);
            preparedStmt.setString(3, "what");
            preparedStmt.setString(4, address1+", "+address2+", "+zip);
            preparedStmt.setString(5, "pending");
            preparedStmt.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        response.sendRedirect("rate.html");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
