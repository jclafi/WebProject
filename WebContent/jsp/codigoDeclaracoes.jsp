<%@ page language="java" 
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Declara��o de uma vari�vel e m�todo usando Declara��es--%>
	
	Chamada do m�todo passando por par�metro a vari�vel <br> <br>
	<%= metodoRetorna(valor) %>
	
	<%-- Valor da vari�vel --%>
	Valor da vari�vel <br> <br>	
	Valor: <%= valor %>

</body>
</html>

<%!
	public String valor = "Texto da Vari�vel";

    public String metodoRetorna(String varTexto) {
    	return "Vari�vel Retornada pelo M�todo: " + varTexto; 
    }

%>