package loginapp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class GeraTelaLogin
 */
@WebServlet("/GeraTelaLogin")
public class GeraTelaLogin extends HttpServlet {
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
		
		//O Servlet de login é recursivo, verifica aqui se tem mensagem de retorno
		String msg = (String) request.getAttribute("msg");
		
		//Define o tipo de Resposta
		response.setContentType("text/html");
		
		//Cria objeto de escrita HTML
		PrintWriter out = response.getWriter();
		try {
			
			//Cria o html de Login
			out.println("<html>");			
			
			//Cabeçalho HTML
			out.println("<head><title>Tela de Login</title></head>");			

			//Escopo HTML
			out.println("</body>");
			
			//Abre o Form e a table
			out.println("<form method='post' action='" + request.getContextPath() + "/validaLogin'>");
			out.println("<table width='30%'>");

			//Mensagem de Login com problemas
			if ((msg != null) && (! msg.equals(""))) {
				out.println("<tr> <td colspan='2'>");
				out.println(msg);
				out.println("</td></tr>");				
			}
			//Usuário
			out.println("<tr>");
			out.println("<td>Usuario</td>");
			out.println("<td><input type='text' name='username' size='20'>");
			out.println("</td></tr>");
			
			//Senha
			out.println("<tr>");
			out.println("<td>Senha</td>");
			out.println("<td><input type='text' name='password' size='20'>");
			out.println("</td></tr>");			
			
			//Botão Entrar
			out.println("<tr><td colspan='2'>");
			out.println("<button type='submit'>Entrar</button>");
			out.println("</td></tr>");			
			
			//Fecha o Form e a table
			out.println("</table>");			
			out.println("</form>");			
			
			//Fecha o Escopo HTML 
			out.println("</body>");			
			out.println("</html>");				
			
		}
		finally {
			out.close();
		}		
	}
}