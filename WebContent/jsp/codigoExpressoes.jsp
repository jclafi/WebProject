<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expressões</title>
</head>
<body>
	Declaração e uso do valor de uma Variável ! <br>
	
	<% String varTeste = "Valor de Teste Nr: "; %>
	
	<% for (int index = 0; index <= 10; index++) {%>
		Teste de Expressão e Variável: + <%= varTeste%> + Index: <%= index %> <br>
	<% } %>
	
</body>
</html>