package navegacao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basicas.Pessoa;

/**
 * Servlet implementation class ListaUsuarios
 */
@WebServlet("/ListaUsuarios")
public class ListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Teste de Encaminhamento de Servlet
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Resgata o array de objetos de Pessoas
		//Origem: Object
		//Destino: Array Pessoas
		Pessoa[] arrayPessoa = (Pessoa[]) request.getAttribute("Pessoas");
		
		//Responsta em HTML
		response.setContentType("text/html");
		
		//Lista na tela as Pessoas
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head><title>Lista Usuarios!</title></head>");
			out.println("<body>");
			out.println("<h1>Teste de Encaminhamento!</h1>");

			//Dados das Pessoas do Servlet 	
			for (int index = 0; index < arrayPessoa.length; index++) {
				out.println("Nome: " + arrayPessoa[index].getNome() +"<br/>");
				out.println("RG: " + arrayPessoa[index].getRg() +"<br/>");	
				out.println("<hr/>");		
			}

			out.println("</body>");
			out.println("</html>");
		}
		finally {
			out.close();
		}
	}
}
