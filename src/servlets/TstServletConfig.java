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
		
		//Busca os valores par�metros de inicializa��o
		ServletConfig config = getServletConfig();
		String localizacao = config.getInitParameter("default_locale");
		String vers�o = config.getInitParameter("version");
		
		//Define o tipo de conte�do do response
		response.setContentType("text/html");		
		
		//Lista na tela os par�metros de inicializa��o recebidos
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head><title>Par�metros de Inicializa��o!</title></head>");
			out.println("<body>");
			out.println("<h1>Par�metros de Inicializa��o!</h1>");
			//Dados da request do Servlet 	
			out.println("<h2> Local: " + localizacao +"</h2>");
			out.println("<h2> Vers�o: " + vers�o +"</h2>");			
			out.println("</body>");
			out.println("</html>");			
		}
		finally {
			out.close();
		}	
	}
}
