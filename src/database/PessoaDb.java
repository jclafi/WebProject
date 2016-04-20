package database;

//Teste annotation
import annotation.Constructor;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import annotation.Class;
import annotation.Method;

//annotation
@Class( nomeClasse = "PessoaDb")
public class PessoaDb {
	
	@Constructor( nomeConstrutor = "public PessoaDb()")
	public PessoaDb() {
		
	}
	
	@Method(nomeMetodo = "public long getPessoaPk() throws SQLException")	
	public long getPessoaPk() throws SQLException {
		//Comando SQL
		String sql = null;
		
		//Statement
		Statement stmt = null;
		
		//ResultSet
		ResultSet rs = null;
		
		Connection connect = ConnectDatabse.getConnection();		
		try {			
			//Prepara o comando SQL
			sql = "select max(id_geral) +1 as id_geral from pessoa";
			try {
				
				//Executa o comando sql
				stmt = connect.createStatement();
				rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					if (rs.getLong("ID_GERAL") <= 0)
						return 1;
					else					
						return rs.getLong("ID_GERAL");
				}
				else
					throw new SQLException("Não foi possível identificar a PK!");					
			}
			catch (SQLException ex) {
				throw new SQLException("Exceção ao buscar a PK:" + ex.getMessage());
			}
		}
		finally {
			ConnectDatabse.closeConnection(connect, stmt);
			if (connect != null)
				connect = null;
			if (stmt != null)
				stmt =null;
			if (rs != null)
			{
				if (! rs.isClosed())
					rs.close();
				rs = null;
			}
		}		
	}	
	
	@Method(nomeMetodo = "public boolean gravaPessoa(String nome, String eMail)")
	public boolean gravaPessoa(String varNome, String varEmail) {
		//Comando SQL
		String sqlUpdate = null;		
		String sqlSelect = null;
		
		//Id Geral
		long idGeral = 0;
		
		//Statement
		Statement stmt = null;
		
		//ResultSet
		ResultSet rs = null;
				
		//Conecttion
		Connection connect = ConnectDatabse.getConnection();		
		try {
			//Valida conexão com a Base
			if (connect == null) {
				System.out.println("Não foi possível conectar com a Base de Dados!");
				return false;
			}
			
			//Valida o comando SQL Select
			sqlSelect = " select id_geral from pessoa where nome = '" + varNome + "' ";
			
			//Prepara o Statement
			stmt = connect.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			
			//Armazena o id_geral da Pessoa
			if (rs.next())
				idGeral = rs.getLong("id_geral");
			
			//Fecha ResultSet			
			if (! rs.isClosed())
				rs.close();
			if (! stmt.isClosed())
				stmt.close();
			
			//Verifica se exist eo Cliente
			if (idGeral > 0) {
				//Atualiza comando Update
				sqlUpdate = "update pessoa set email = '" + varEmail + "' where id_geral = " + idGeral;
				
				//Cria o Statemente e Executa a Query
				stmt = connect.createStatement();
				switch (stmt.executeUpdate(sqlUpdate)) {
					case 0 : { 
							      System.out.println("Falha ATZ eMail!"); 
							      return false; 
							 }
					case 1 : System.out.println("e-Mail atualizado!");
				}
			}
			else
			{
				System.out.println("Pessoa não identificada: " + varNome);
				return false;				
			}
		
		}
		catch (SQLException ex) {
			System.out.println("Exceção ao Salvar e-Mail: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}		
		return true;		
	}
	
	@Method(nomeMetodo = "public void finalize()")
	public void finalize() {
		System.out.println("Finalize!");
	}
}
