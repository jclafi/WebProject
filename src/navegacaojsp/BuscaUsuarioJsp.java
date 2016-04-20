package navegacaojsp;

import basicas.Pessoa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuscaUsuarioJsp
 */
@WebServlet("/BuscaUsuarioJsp")
public class BuscaUsuarioJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaUsuarioJsp() {
        super();
    }

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
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Pessoa 1
		String arrayTelefone[] = {"9610-7070", "3206-3739"};
		Pessoa p1= new Pessoa("5.532.664-55", "Julio Cesar", arrayTelefone);
		p1.setEmail("jclafi@gmail.com");
		
		//Pessoa 2
		arrayTelefone[0] = "3205-3685";
		arrayTelefone[1] = "9952-4588";		
		Pessoa p2= new Pessoa("5.532.664-55", "Julio Cesar", arrayTelefone);
		p2.setEmail("jclafi@gmail.com");		
		
		//Pessoa 3;
		arrayTelefone[0] = "2485-6955";
		arrayTelefone[1] = "9412-8544";
		Pessoa p3= new Pessoa("5.532.664-55", "Julio Cesar", arrayTelefone);
		p3.setEmail("jclafi@gmail.com");		

		//Array de Pessoa
		Pessoa pessoa[] = {p1, p2, p3};
		
		request.setAttribute("Pessoa", pessoa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/listaUsuariosJsp.jsp");
		
		rd.forward(request, response);		
	}

}
