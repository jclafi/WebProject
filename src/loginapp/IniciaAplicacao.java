package loginapp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import basicas.Pessoa;

/**
 * Servlet implementation class IniciaAplicacao
 */
@WebServlet("/IniciaAplicacao")
public class IniciaAplicacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pega o objeto Pessoa da Sessão realizando o cast
		Pessoa objPessoa = (Pessoa) request.getSession().getAttribute("pessoa");
		
		//Define o tipo da Response
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head><title>Bem Vindo a Aplicação !</title></head>");
			out.println("<body>");
			out.println("<h1>Dados do Usuário !</h1>");			
			if (objPessoa != null) {
				out.println("<h1>Nome: " + objPessoa.getNome() + "</h1>");			
				out.println("<h1>R.G: " + objPessoa.getRg() + "</h1>");		
				out.println("<h1>Sessão: " + objPessoa.getSession() + "</h1>");
				
				out.println("<a href='efetuaLogout'>Logout</a>");
			}
			else
			{
				out.println("<h1>Nome: Não Idenfificado !</h1>");			
				out.println("<h1>R.G: Não Idenfificado !</h1>");		
				out.println("<h1>Sessão: Não Idenfificado !</h1>");				
			}
			out.println("</body>");
			out.println("</html>");
		}
		finally {
			out.close();
		}
		
	}
	
}
