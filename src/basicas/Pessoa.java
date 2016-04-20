package basicas;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//Teste annotation
import annotation.Field;
import annotation.Constructor;
import annotation.Class;
import annotation.Method;

//annotation
@Class (nomeClasse = "public class Pessoa")
public class Pessoa {
	//Enumeração
	public enum TipoPessoa {PESSOA_FISICA, PESSOA_JURIDICA};	
	//Atributo usando enumerador
	private TipoPessoa pessoaFisicaJuridica;	
	
	//Atributos normais
	private long idGeral;
	//annotation
	@Field(nomeCampo = "Rg:")
	private String rg;	
	//annotation
	@Field(nomeCampo = "Nome:")
	private String nome;	
	//annotation
	@Field(nomeCampo = "SobreNome:")
	private String sobreNome;
	//annotation
	@Field(nomeCampo = "dataNasc")
	private Date dataNasc;
	//annotation
	@Field(nomeCampo = "telefones")
	private String[] telefones;
	//annotation
	@Field(nomeCampo = "temCarro")	
	private boolean temCarro;
	//annotation
	@Field(nomeCampo = "eMail")
	private String eMail;
	//annotation
	@Field(nomeCampo = "sessionId")
	private String sessionId; 
	
	//annotation
	@Constructor(nomeConstrutor = "Pessoa(String varRg, String varNome, String varSobreNome, Date varDataNasc, String[] varTelefones, TipoPessoa varTipoPessoa)")
	public Pessoa(String varRg, String varNome, String varSobreNome, Date varDataNasc, String[] varTelefones, TipoPessoa varTipoPessoa) {
		setRg(varRg);
		setNome(varNome);
		setSobreNome(varSobreNome);
		setDataNasc(varDataNasc);
		setTelefones(varTelefones);
		setTipoPessoa(varTipoPessoa);
	}

	//annotation
	@Constructor(nomeConstrutor = "Pessoa(String varRg, String varNome, String varSobreNome, Date varDataNasc)")	
	public Pessoa(String varRg, String varNome, String varSobreNome, Date varDataNasc) {
		setRg(varRg);
		setNome(varNome);
		setSobreNome(varSobreNome);
		setDataNasc(varDataNasc);				
	}

	//annotation
	@Constructor(nomeConstrutor = "Pessoa(long varIdGeral, String varRg, String varNome, String varSobreNome, Date varDataNasc, TipoPessoa varTipoPessoa)")
	public Pessoa(long varIdGeral, String varRg, String varNome, String varSobreNome, Date varDataNasc, TipoPessoa varTipoPessoa) { 
		setIdGeral(varIdGeral);
		setRg(varRg);
		setNome(varNome);
		setSobreNome(varSobreNome);
		setDataNasc(varDataNasc);
		setTipoPessoa(varTipoPessoa);				
	}
	
	//annotation
	@Constructor(nomeConstrutor = "Pessoa(String varRg, String varNome)")	
	public Pessoa(String varRg, String varNome) { 
		setRg(varRg);
		setNome(varNome);
	}
	
	//annotation
	@Constructor(nomeConstrutor = "Pessoa(String varRg, String varNome)")	
	public Pessoa(String varRg, String varNome, String[] varTelefone) { 
		setRg(varRg);
		setNome(varNome);
		setTelefones(varTelefone);
	}
	
	//annotation
	@Constructor(nomeConstrutor = "Pessoa()")	
	public Pessoa() { 
						
	}		
	
	public void setIdGeral (long varIDGeral) { idGeral = varIDGeral; }
	public long getIdGeral() { return idGeral; }
	public void setTipoPessoa(TipoPessoa varTipoCliente) { pessoaFisicaJuridica = varTipoCliente; }
	public TipoPessoa setTipoCliente() { return pessoaFisicaJuridica; }	
	public String getRg() { return rg; }
	public void setRg(String varRg) { rg = varRg; }	
	public String getNome() { return nome; }
	public void setNome(String varNome) { nome = varNome; }	
	public String getSobreNome() { return sobreNome; }
	//Exemplo de uso de THIS	
	public void setSobreNome(String sobreNome) { this.sobreNome = sobreNome; }	
	public String getDataNasc(String format) {	
		DateFormat dateFormat = ((format.equals("")) ? new SimpleDateFormat("dd/MM/yyyy") : new SimpleDateFormat(format));
		return dateFormat.format(dataNasc);  
	}
	public Date getDataNasc() { return this.dataNasc; }	
	public void setDataNasc(Date varDataNasc) { dataNasc = varDataNasc; }	
	public String[] getTelefone() { return telefones; }
	public void setTelefones(String[] varTelefones) { telefones = varTelefones; }	
	public boolean isCarroDisponivel() { return temCarro; }
	public void setCarroDispopnivel(boolean varTemCarro) { temCarro = varTemCarro; }
	public void setEmail(String varEmail) { eMail = varEmail; }
	public String getEmail() { return  eMail; }	
	public void setSessionId(String varId) { 
		sessionId = varId; 
	}
	public String getSession() { return sessionId; }
	
	//Coleções sobrescrever método equals
	//annotation
	@Method (nomeMetodo = "public boolean equals(Object o)")	
	public boolean equals(Object o) {
		//O parâmetro não pode se rnulo
		if (o == null) return false;
		
		//Se não for um objeto da classe Pessoa retorna nulo
		if (! (this.getClass().equals(o.getClass()))) return false;
		
		Pessoa outra = (Pessoa) o;
		
		//Verifica rg igual
		boolean rgigual = (this.getRg() == outra.getRg());

		//Verifica Nime igual
		boolean nomeigual = (this.getNome() == outra.getNome());
		
		return (rgigual && nomeigual);		
	}	

	//Coleçõs sobrescrever método harsCode
	//annotation
	@Method (nomeMetodo = "public int hashCode()")		
	public int hashCode() {
		String atributos = (nome + rg);
		return atributos.hashCode();
	}		

	//annotation
	@Method (nomeMetodo = "public void imprimeDadosPesssoa(int varNumero)")	
	public void imprimeDadosPesssoa(int varNumero) {
		//Exit do método que não rerotna nada 
		if (varNumero == 22)
			return;
		System.out.println(	"Nome: " + nome + "\n" +
							"Sobre Nome: " + sobreNome + "\n" +
							"Data Nasc: " + dataNasc + "\n" +
							"Tem Carro: " + temCarro + "\n" +
							"Tipo Pessoa: " + pessoaFisicaJuridica + "\n" +							
							"Telefones: " + telefones[0] + " - " + telefones[1] + "\n" +
							"Número: " + varNumero); 
	}

	//annotation
	@Method (nomeMetodo = "public void imprimeDadosPesssoa()")	
	public void imprimeDadosPesssoa() {
		System.out.println(	"Nome: " + nome + "\n" +
							"Sobre Nome: " + sobreNome + "\n" +
							"Data Nasc: " + dataNasc + "\n" +
							"Tem Carro: " + temCarro + "\n" +
							"Tipo Pessoa: " + pessoaFisicaJuridica + "\n" +
							"Telefones: " + telefones[0] + " - " + telefones[1]);
	}
	
	//Método usado no componente JList
	//annotation
	@Method (nomeMetodo = "public String toString()")	
	public String toString() {
		return "["+ rg +"]" + " - " + nome;
	}
	
	//annotation
	@Method (nomeMetodo = "public void finalize()")
	public void finalize() {
		telefones = null;
		System.out.println("Finalize !");
	}
}
