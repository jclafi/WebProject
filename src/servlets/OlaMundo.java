package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OlaMundo
 */
@WebServlet("/OlaMundo")
public class OlaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtendo o canal de Conumicação com o Cliente, neste caso o browser
		response.getWriter().append("<h1> Request via Get(), Path: ").append(request.getContextPath() + "</h1>");		
		
		//Define a comunicação com o Cliente text/html
		response.setContentType("text/html");		

		//Outra maneira de definir o canal de comunicação com o Cliente		
		PrintWriter out = response.getWriter();
		try {
			//Enviando o documento HTML para o cliente - RESPOSTA
			out.println("<html>");
			out.println("<head><title>Ola Mundo!</title></head>");
			out.println("<body>");
			out.println("<h1>Dados da request do Servlet!</h1>");
			//Dados da request do Servlet 	
			out.println("<h1> Tipo Request: " + request.getMethod() +"</h1>");
			out.println("<h1> Nome Server: " + request.getServerName() +"</h1>");
			out.println("<h1> Server Port: " + request.getServerPort() +"</h1>");		
			out.println("<h1> Diretório Server: " + request.getServletPath() +"</h1>");		
			out.println("<h1> URL: " + request.getRequestURI() +"</h1>");		
			out.println("<h1> Context Path: " + request.getContextPath() +"</h1>");	
			out.println("</body>");
			out.println("</html>");
		}
		finally {
			out.close();			
		}		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}