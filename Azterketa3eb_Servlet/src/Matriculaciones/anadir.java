package Matriculaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class anadir
 */
@WebServlet("/anadir.jr")
public class anadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	
	   static final String DB_URL = "jdbc:mysql://localhost/";
	   static final String USER = "root";
	   static final String PASS = "zubiri";
	   
	   Connection conn = null;
	   Statement stmt = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public anadir() {
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
		// TODO Auto-generated method stub
	
		response.setContentType("text/html; charset=iso-8859-1");
	    PrintWriter out = response.getWriter();
		   
	    out.print("<html>");
	      out.print("<head><title>Ikasleak</title>");
	      out.print("</head>");
	      out.print("<body>");
	      out.println("<table align='center'>  ");
	      out.println("<td>	DNI </td>");
	      out.println("<td>	Izena </td>");
	      out.println("<td>Abizena </td>");
	      out.println("<td>Jaioteguna</td>");

	      out.println("</tr>");
	     
	      	String dni = request.getParameter("dni");
	    	String izena = request.getParameter("nombre");
	        String abizena = request.getParameter("apellido");
	        String jaioteguna = request.getParameter("ano");

	        

	        out.println("<tr>");
	        out.println("<td> "+ dni + "</td>");
	        out.println("<td>" + izena + "</td>");
	        out.println("<td>" + abizena + "</td>");
	        out.println("<td>" + jaioteguna + "</td>");

	        out.println("</tr>");
	      
	      out.println("</table");
	      out.print("</body>");
	      out.print("</html>");
	    

		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		          
		      stmt = conn.createStatement();
		      
		      String sql = "CREATE DATABASE IF NOT EXISTS Matriculas";
		      stmt.executeUpdate(sql);
		      stmt = conn.createStatement();
		      
		      String sql3 = "USE Matriculas ";
		      stmt.executeUpdate(sql3);
		      
		      String sql2 = "CREATE TABLE IF NOT EXISTS Ikasleak (DNI VARCHAR(7),  Izena VARCHAR(50), Abizena VARCHAR(50), Jaioteguna VARCHAR(10), PRIMARY KEY ( DNI ))";

		      stmt.executeUpdate(sql2);
		      
		      
		      
		      stmt.executeUpdate("INSERT INTO Ikasleak (DNI,Izena,Abizena,Jaioteguna) VALUES ('" + 
		        request.getParameter("dni") + "', '" + request.getParameter("nombre") + "','" + request.getParameter("apellido") + "','" + request.getParameter("ano") + "')");
		   }
		    
		    catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }		
	}
}

