<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Express�es</title>
</head>
<body>
	Declara��o e uso do valor de uma Vari�vel ! <br>
	
	<% String varTeste = "Valor de Teste Nr: "; %>
	
	<% for (int index = 0; index <= 10; index++) {%>
		Teste de Express�o e Vari�vel: + <%= varTeste%> + Index: <%= index %> <br>
	<% } %>
	
</body>
</html>