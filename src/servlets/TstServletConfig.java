package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class TstServletConfig
 */
@WebServlet("/TstServletConfig")
public class TstServletConfig extends HttpServlet {
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
		
		//Busca os valores parâmetros de inicialização
		ServletConfig config = getServletConfig();
		String localizacao = config.getInitParameter("default_locale");
		String versão = config.getInitParameter("version");
		
		//Define o tipo de conteúdo do response
		response.setContentType("text/html");		
		
		//Lista na tela os parâmetros de inicialização recebidos
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head><title>Parâmetros de Inicialização!</title></head>");
			out.println("<body>");
			out.println("<h1>Parâmetros de Inicialização!</h1>");
			//Dados da request do Servlet 	
			out.println("<h2> Local: " + localizacao +"</h2>");
			out.println("<h2> Versão: " + versão +"</h2>");			
			out.println("</body>");
			out.println("</html>");			
		}
		finally {
			out.close();
		}	
	}
}
