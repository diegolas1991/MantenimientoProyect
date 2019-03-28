package com.getafe.curso;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class listUser
 */
@WebServlet("/listUser")
public class listUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public listUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginalog = null;
		String resultado = "";
		try {
			HttpSession sesion= request.getSession(true);
			
			if(sesion.getAttribute("logado").toString() == "true") {
				Class.forName("com.mysql.jdbc.Driver").newInstance(); 
				
				Connection con = DriverManager.getConnection ("jdbc:mysql://10.1.4.252:3306/cursohack","root", "root");
				
				PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM agendapersonal where id_usuario=?");
				preparedStatement.setInt(1, Integer.parseInt(sesion.getAttribute("id").toString()));
				
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					if(rs.getString("id_usuario").equals(sesion.getAttribute("id"))) {
						resultado = resultado + "<p>" + rs.getString("id_usuario")+ "------"+ rs.getString("nombre")+ "------"+ rs.getString("telefono") + "</p>";
					}
				}
				sesion.setAttribute("resultadoBusqueda", resultado);
				
				preparedStatement.close();
			    con.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		paginalog="listUsers.jsp";
		
		response.sendRedirect(paginalog);
	}
}
