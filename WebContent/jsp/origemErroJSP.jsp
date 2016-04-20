<%@ page errorPage="destinoErroJSP.jsp" %>

<%@ 	page language="java" 
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Origem Erro</title>
</head>
<body>
	<%-- Gera uma exceção para direcionar o JSP de tratamento de erros --%>
	Gera uma exceção para direcionar o JSP de tratamento de erros <br>	
	<% int x = 2/0; %>
</body>
</html>