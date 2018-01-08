package com.accolite.mini_au.assignment1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_assignment1
 */
public class Servlet_assignment1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_assignment1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static int id = 0;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		String name = request.getParameter("name");
   		String email = request.getParameter("email");
   		String password = request.getParameter("password");
   		String conf_pwd = request.getParameter("conf_pwd");
   		
   		Jdbc_connection con = Jdbc_connection.getConnection();
   		
   		if(password.equals(conf_pwd)) {
   		
   			try {
   				con.stmt.execute("insert into servlet_stream_exercise values("+id+",'"+name+"','"+email+"','"+password+"');");
   				id++;
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   			
   		}
   		
   		javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Assignment_2");
   		requestDispatcher.forward(request, response);
   	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
