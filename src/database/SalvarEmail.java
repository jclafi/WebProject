package database;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.PessoaDb;

/**
 * Servlet implementation class SalvarEmail
 */
@WebServlet("/SalvarEmail")
public class SalvarEmail extends HttpServlet {
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
		doGet(request, response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RESPONSE
		PrintWriter out = response.getWriter();
		PessoaDb objPersistente = new PessoaDb();
		try {
			//Parâmetro textNome
			String nome = request.getParameter("textNome");
			//Parâmetro textEmail
			String email = request.getParameter("textEmail");

			//Define o tipo de Objeto que está sendo respondido - RESPONSE 
			response.setContentType("text/html");			
			
			//Enviando o documento HTML para o cliente - RESPONSE
			out.println("<html>");
			out.println("<head><title>Teste Formulário</title></head>");
			out.println("<body>");
			
			//Cadastra o e-mail da Pesssoa na base d edados
			if (objPersistente.gravaPessoa(nome, email)) {
				out.println("<h2>Obrigado,</h2>" + 
							"<h2>Seu cadastro foi realizado com Sucesso !</h2>");
			}
			else
			{
				out.println("<h2>Atenção,</h2>" + 
						    "<h2>Falha ao realizar o cadastro !</h2>");
			}
			
			//Fecha o HTML
			out.println("<h1> Nome: " + nome +"</h1>");
			out.println("<h1> eMail: " + email +"</h1>");
			out.println("<a href='loginSalvaUsuarioEmail'>Retorna Login</a>");			
			out.println("</body>");
			out.println("</html>");			
		}
		finally {
			out.close();
			objPersistente = null;
		}
	}
}
