package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabse {
	//Atributos da conexão
	private static final String STR_DRIVER = "org.postgresql.Driver";
	private static final String NOME_BANCO = "estudosjava";
	private static final String STR_CON = "jdbc:postgresql://localhost:5432/" + NOME_BANCO;
	private static final String USER = "postgres";
	private static final String	PASSWORD = "postgres"; 

	public static Connection getConnection() {		
		try {			
			//Carrega o Driver do PostgreSQL 
			Class.forName(STR_DRIVER);
			//Conecta com o banco de dados
			return DriverManager.getConnection(STR_CON, USER, PASSWORD);			
		}
		catch (ClassNotFoundException cl) {
			System.out.println("Classe não encontrada! \n");			
			cl.printStackTrace();
			return null;
		}
		catch (SQLException ex) {
			System.out.println("Erro ao obter a conexão! \n");
			ex.printStackTrace();
			return null;			
		}	
	}
	
	public static void closeConnection(Connection connect) {
		try {
			if ((connect != null) && (! connect.isClosed()))
				connect.close();
		}
		catch (SQLException ex) {
			System.out.println("Erro ao fechar a conexão! \n");
			ex.printStackTrace();			
		}
	}
	
	public static void closeConnection(Connection connect, Statement stmt) {
		//Fecha o Statement
		try {
			if ((stmt != null) && (! stmt.isClosed()))
				stmt.close();			
		}		
		catch (SQLException ex) {
			System.out.println("Erro ao fechar a conexão! \n");
			ex.printStackTrace();			
		}
		//Fecha a conexão
		closeConnection(connect);
	}	

}

