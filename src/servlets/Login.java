package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuarios;



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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String usuarioPost = request.getParameter("usuario");
		String contraseniaPost = request.getParameter("contrasenia");
		boolean logined = false;
		
		try {
			LinkedList<Usuarios> usuarios = bd.ConsultasBD.login(usuarioPost, contraseniaPost);

			if ( ! usuarios.isEmpty() ) {
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/inicio.jsp");
				dispatcher.forward(request, response);
				
			} else {
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
