package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.Name;

import fasam.jdbc.Login;
import javafx.scene.control.Alert;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String nome = request.getParameter("Login");
		String senha = request.getParameter("Senha");

		if (Login.validate(nome, senha)) {
			
			out.print("Bem vindo " + nome.toString() + "!");
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
			rd.include(request, response);

		} else {
			out.print("E-mail ou senha incorretos!");
			RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
			rd.include(request, response);
		}

		out.close();
	}

	private void Alert(String string) {
		// TODO Auto-generated method stub
		
	}
}
