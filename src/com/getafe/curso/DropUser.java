package com.getafe.curso;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DropUser")
public class DropUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DropUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String paginalog=null;
		
		HttpSession sesion= request.getSession(true);
		if(sesion.getAttribute("logado").toString() == "true" &&  name.isEmpty()==false){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance(); 
				
				Connection con = DriverManager.getConnection ("jdbc:mysql://10.1.4.252:3306/cursohack","root", "root");
				
				PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM agendapersonal WHERE nombre=?");
				preparedStatement.setString(1, name);
				
				preparedStatement.executeUpdate();
				
				preparedStatement.close();
			    con.close();
			    
			} catch (Exception e) {
				e.printStackTrace();
			}
			paginalog="logado.jsp";
		} else{
			sesion.invalidate();
			paginalog="index.jsp";
		}
		response.sendRedirect(paginalog);
	}
}
