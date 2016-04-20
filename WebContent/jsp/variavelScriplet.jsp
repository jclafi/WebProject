<%@ page 	language="java" 
			contentType="text/html; charset=ISO-8859-1"
    		pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scriplets</title>
</head>
<body>
	<!-- COMENTÁRIO HTML SERÁ ENVIADO AO BROWSER -->
	Declaração de uma variável que não será Impressa "strString" ! <br>
	
	<% String strString = "TESTE"; %>
	Valor da Variável strString: <%= strString %>
	<br>	
	
	<%-- COMENTÁRIO JSP NÃO SERÁ ENVIADO AO BROWSER --%>
	Laço for com 10 posições
    
    <br>
	<% for (int index = 0; index < 10; index++) { %>
		Conteúdo do laço com dez posições: Nr: <%= index %> <br>
	<% } %>	
</body>
</html>