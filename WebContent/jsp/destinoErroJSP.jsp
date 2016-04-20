<%@ page language="java" 
		 contentType="text/html; charset=ISO-8859-1"
    	 pageEncoding="ISO-8859-1"%>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Destino Erro</title>
</head>
<body>
	1) Página de tratamento de erro
	<br> 
	<br>
	2) Página chamada pelo Container pois uma <%= exception.getClass().getName() %> foi gerada.
	<br> 
	<br>
	3) A Mensagem de erro é: <%= exception.getMessage() %>
  	<br> 
	<br>	
</body>
</html>