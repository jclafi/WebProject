package navegacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basicas.Pessoa;

/**
 * Servlet implementation class BuscaUsuarios
 */
@WebServlet("/BuscaUsuarios")
public class BuscaUsuarios extends HttpServlet {
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
		//Teste de Encaminhamento de Servlet
		doAction(request, response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Cria o array de pessoas
		Pessoa[] arrayPessoas = new Pessoa[3];
		
		//Instâncias as pessoas e carrega os atributos;
		Pessoa p1 = new Pessoa("5.539.533.99", "Julio Cesar");
		Pessoa p2 = new Pessoa("2.533.553.23", "Ademar Almeida");		
		Pessoa p3 = new Pessoa("5.534.444.23", "Claudio Kaist");
		
		//Atribui as pessoas ao objeto - teste FOR e SWITCH
		for (int index = 0; index < arrayPessoas.length; index++) {
			switch (index) { 
				case 0 : arrayPessoas[index] = p1; break;
				case 1 : arrayPessoas[index] = p2; break;
				case 2 : arrayPessoas[index] = p3; break;
			}
		}
		
		//Realiza o forward para p Servlet ListaUsuarios
		//Origem: Array Pessoas
		//Destino: Object 		
		request.setAttribute("Pessoas", arrayPessoas);
		RequestDispatcher rd = request.getRequestDispatcher("/listaUsuarios");
		rd.forward(request, response);		
	}
}
