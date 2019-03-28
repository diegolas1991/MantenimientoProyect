package com.getafe.curso;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String pass= request.getParameter("password");
		String idUser=null;
		Boolean logado=false;
		String paginalog=null;
		DocumentBuilderFactory dfg = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			
			Connection con = DriverManager.getConnection ("jdbc:mysql://10.1.4.252:3306/cursohack","root", "root");
			
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM usuarios where nombre = ?");
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				if(pass.equals(rs.getString("password"))) {
					logado = true;
					idUser= rs.getString("id");
				}
			}
			
			if(logado==true){
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("id",idUser);
			    sesion.setAttribute("nombre",name);
				sesion.setAttribute("password",pass);
				sesion.setAttribute("logado",logado);
				paginalog = "logado.jsp";
			} else {
				System.out.println("ERROR DE USUARIO O CONTRASENIA");
				paginalog = "index.jsp";
			}

			preparedStatement.close();
		    rs.close();
		    con.close();
		    
			
		} catch (Exception e) {
			paginalog="index.jsp";
			e.printStackTrace();
		}
		response.sendRedirect(paginalog);
	}
	
}