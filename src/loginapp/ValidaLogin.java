package loginapp;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basicas.Pessoa;

/**
 * Servlet implementation class ValidaLogin
 */
@WebServlet("/ValidaLogin")
public class ValidaLogin extends HttpServlet {
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

		//Identifica o Usuário e Senha do Login definidos nos parâmetros
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Dados de retorno caso login gere erro
		String msg= "";
		String urlDestino = "";
		
		//Verifica se a senha e Usuário são validos
		if (((user != null) && (! user.equals(""))) && 
			((password != null) &&(! password.equals("") ))) {
			
			//Cria o objeto Pessoa
			Pessoa objPessoa = new Pessoa("5.365.256.99", "Julio Cesar Ledo");
			
			//Adiciona o objeto pessoa a Sessão 
			request.getSession().setAttribute("pessoa", objPessoa);
			//Em segundos o total que a sessão poderá ficar ociosa
			request.getSession().setMaxInactiveInterval(60);
			//Define o ID Token da sessão no ObjPessoa 
			objPessoa.setSessionId(request.getSession().getId());
			
			//Dispacha o início da Aplicação
			urlDestino = "/iniciaAplicacao";			
		}		
		else
		{
			//Verifica erros de Login Senha
			if ((user == null) || (user.equals(""))) {
				msg = "Atenção defina o usuário!";
			}
			else
				if ((password == null) || (password.equals(""))) {
					msg = "Atenção defina a senha!";					
				}
			
			//Valida mensagem e destino recursivo erro de login
			urlDestino = "/geraTelaLogin"; 	
			
			//Seta o atributo de erro
			request.setAttribute("msg", msg);
		}
		
		//Cria o dispacher
		RequestDispatcher dispatcher = request.getRequestDispatcher(urlDestino); 
		
		//Encaminha a request para Login ou Iniciar Aplicação		
		dispatcher.forward(request, response);
	}
}
