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
	<!-- COMENT�RIO HTML SER� ENVIADO AO BROWSER -->
	Declara��o de uma vari�vel que n�o ser� Impressa "strString" ! <br>
	
	<% String strString = "TESTE"; %>
	Valor da Vari�vel strString: <%= strString %>
	<br>	
	
	<%-- COMENT�RIO JSP N�O SER� ENVIADO AO BROWSER --%>
	La�o for com 10 posi��es
    
    <br>
	<% for (int index = 0; index < 10; index++) { %>
		Conte�do do la�o com dez posi��es: Nr: <%= index %> <br>
	<% } %>	
</body>
</html>