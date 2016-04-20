package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class TstServletContext
 */
@WebServlet("/TstServletContext")
public class TstServletContext extends HttpServlet {
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
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Criar objeto Servlet Context
		ServletContext objParam = getServletContext();
		//Carrega o valor da variável de contexto
		String defaultServer = objParam.getInitParameter("database_default_server");
		
		//Define o tipo de conteúdo do response
		response.setContentType("text/html");
		
		//Retorna em formato texto/html os dados
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head><title>Parâmetros de Contexto!</title></head>");
			out.println("<body>");
			out.println("<h1>Parâmetros de Inicialização!</h1>");
			//Dados da request do Servlet 	
			out.println("<h2> Local Database: " + defaultServer +"</h2>");
			out.println("</body>");
			out.println("</html>");	
		}		
		finally {
			out.close();
		}	
	}
}
