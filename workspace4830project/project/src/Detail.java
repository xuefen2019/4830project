

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Detail
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String[] foodlist = {"Beef with broccoli","Pork with bell pepper", "Eggs drop soup", "Fried chicken wings", "Mongolian Beef", "Vegetable Salad", "Hot Sour Soup", "Moo-shu Pork", "Orange Chicken", "Seasame Chicken", "Spring rolls"};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "Your Order Details";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head>    <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap.min.css\">" + "\n" +
	            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"table.css\"></head>\n" + //
	              
	            "<body>\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      

	      Connection connection = null;
	      PreparedStatement preparedStatement = null;
          String foodresult = "";
	      try {
	         DBConnection.getDBConnection();
	         connection = DBConnection.connection;

	         String selectSQL = "SELECT * FROM ordered WHERE NAME LIKE ?";
	         String theUserName = Login.user + "%";
	         preparedStatement = connection.prepareStatement(selectSQL);
	         preparedStatement.setString(1, theUserName);
	         ResultSet rs = preparedStatement.executeQuery();
	         out.println("<div class=\"limiter\">" + "\n" + 
	         		"		<div class=\"container-table100\">" + "\n" + 
	         		"	        <div class=\"wrap-table100\">" + "\n" + 
	         		"	           <div class=\"table100 ver1 m-b-110\">" + "\n" + 
	         		"	              <div class=\"table100-head\">" + "\n" + 
	         		"	            		<table>" + "\n" + 
	         		"	            			<thead>" + "\n" + 
	         		"	            				<tr class=\"row100 head\">" + "\n" +
	         											"<th class=\"cell100 column1\">Id</th>" + "\n" +
												        "<th class=\"cell100 column2\">FOOD</th>" + "\n" +
												        "<th class=\"cell100 column3\">PAY</th>" + "\n" +
												        "<th class=\"cell100 column4\">ADDRESS</th>" + "\n" +
												        "<th class=\"cell100 column5\">STATUS</th>" + "\n" +
	        "                        				</tr>" + "\n" +
	         		"                        	</thead>" + "\n" +
	         		"                    	</table>" + "\n" +
	         		"                 </div>"+ "\n" +
	         		
	         		
	         		
                "<div class=\"table100-body js-pscroll\">\n" +
                    "<table>\n" +
                    	"<tbody>\n"); 
	         		

	         while (rs.next()) {
         	    out.println("<tr class=\"row100 body\">");
	            int id = rs.getInt("id");
	            String food = rs.getString("FOOD").trim();
	            String pay = rs.getString("PAY").trim();
	            String address = rs.getString("ADDRESS").trim();
	            String status = rs.getString("STATUS").trim();
	            String foodtem[] = food.split(",");
	            for (int a = 0; a <= foodtem.length - 1; a++)
	            {
	            	if (!foodtem[a].equals("0"))
	            	{
	            		foodresult += foodlist[a];
	            		foodresult += " * ";
	            		foodresult += foodtem[a];
	            		foodresult += "<br />";
	            	}
	            }
	            out.println("<td class=\"cell100 column1\">" + id + "</td>\n" +
	            		"<td class=\"cell100 column2\">" + foodresult + "</td>\n" +
	            		"<td class=\"cell100 column3\">" + pay + "</td>\n" +
	            		"<td class=\"cell100 column4\">" + address + "</td>\n" +
	            		"<td class=\"cell100 column5\">" + status + "</td>\n"
	            		);
         	    out.println("</tr>\n");
         	   foodresult = "";
	         }
	         out.println(
	      		"                 </tbody>"+ "\n" +
	      		"                 </table>"+ "\n" +
	      		"                 </div>"+ "\n" +
      		"                 </div>"+ "\n" +
      		"                 </div>"+ "\n" +
      		"                 </div>"+ "\n" +
      		"                 </div>");
	         out.println("<a href=\"customer.html\">Go back to home page</a> <br>");
	         out.println("</body></html>");
	         rs.close();
	         preparedStatement.close();
	         connection.close();
	      } catch (SQLException se) {
	         se.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if (preparedStatement != null)
	               preparedStatement.close();
	         } catch (SQLException se2) {
	         }
	         try {
	            if (connection != null)
	               connection.close();
	         } catch (SQLException se) {
	            se.printStackTrace();
	         }
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
