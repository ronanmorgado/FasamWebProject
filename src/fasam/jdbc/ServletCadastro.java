package fasam.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Pessoas;
import modelo.PessoasDAO;

/**
 * Servlet implementation class ServletCadastro
 */
@WebServlet("/ServletCadastro")
public class ServletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCadastro() {
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

		// pegando os parâmetros do request
		String nome = request.getParameter("Nome");
		String email = request.getParameter("Email");
		String senha = request.getParameter("Senha");

		Pessoas p = new Pessoas();
		p.setNome(nome);
		p.setEmail(email);
		p.setSenha(senha);
		
		// salva o contato
		PessoasDAO pess = new PessoasDAO();
		try {
			pess.salvar(p);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// imprime o nome do contato que foi adicionado
		out.print(nome.toString() + " seu cadastro foi realizado com sucesso!");
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.include(request, response);
	}
}
