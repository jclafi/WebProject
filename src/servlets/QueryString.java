package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contador
 */
@WebServlet("/Contador")
public class QueryString extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int intContador;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Identifica os par�metros j� fazendo cast pois a origem � String
		int intInicio = 0; 
		int intFim = 0;		
		try {
			//Integer intInicio = new Integer(request.getParameter("inicio"));
			//Integer intFim = new Integer(request.getParameter("fim"));
			
			//Outro modelo de CAST
			String strInicio = request.getParameter("inicio");
			intInicio = Integer.parseInt(strInicio);
			String strFim = request.getParameter("fim");
			intFim = Integer.parseInt(strFim);
		}
		catch (NumberFormatException ex) {
			throw new ServletException(ex);
		}
		
		//Define a comunica��o com o Cliente text/html
		response.setContentType("text/html");	
		
		//Cria a p�gina de retorno do contador
		PrintWriter out = response.getWriter();		
		try {
			out.println("<html>");
			out.println("<head><title>Contador!</title></head>");
			out.println("<body>");
			//Query String - Par�metros na URL
			out.println("<h1>QueryString: " + request.getQueryString() + "</h1>");			
			//URL + Query String
			out.println("<h1>Request URL + QueryString: " + request.getRequestURI() + "?" + request.getQueryString() + "</h1>");			
			//URL Completa String Buffer 			
			StringBuffer strRequest = request.getRequestURL();
			out.println("<h1>RequestURL via StringBuffer: " + strRequest + "</h1>");		
			//URL Completa String Buffer + Query String
			out.println("<h1>RequestURL via StringBuffer: " + strRequest + "?" + request.getQueryString() + "</h1>");			
			out.println("<h1>Contador!</h1>");
			//Dados da request do Servlet 	
			out.println("<h2> In�cio: " + intInicio +"</h2>");
			out.println("<h2> Fim: " + intFim +"</h2>");			
			out.println("<h2> In�cio do Contador Din�nico </h2>");
			//Utiliza os par�metros percorrendo o Loop
			for (int index = intInicio; index < intFim; index++) {
				out.println("<h2> Posi��o: "+ index +"</h2>");
			}		
			out.println("<h1> Fim do Contador Din�nico </h1>");
			out.println("");			
			out.println("<h1> Contador est�tico: " + intContador++ +"</h1>");
			out.println("</body>");
			out.println("</html>");
		}
		finally {
			out.close();
		}
	}
}
