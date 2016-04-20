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
	<%-- Declaração de uma variável e método usando Declarações--%>
	
	Chamada do método passando por parâmetro a variável <br> <br>
	<%= metodoRetorna(valor) %>
	
	<%-- Valor da variável --%>
	Valor da variável <br> <br>	
	Valor: <%= valor %>

</body>
</html>

<%!
	public String valor = "Texto da Variável";

    public String metodoRetorna(String varTexto) {
    	return "Variável Retornada pelo Método: " + varTexto; 
    }

%>