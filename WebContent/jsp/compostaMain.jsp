<%@ page 	language="java" 
			contentType="text/html; charset=ISO-8859-1"
    		pageEncoding="ISO-8859-1"%>
    		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Páginas Compostas</title>
</head>
<body>
	<TABLE border="1">
		<TR>
			<TD><%@ include file="compostaHeader.jsp" %></TD> 
		</TR>
		<TR>
			<TD><%@ include file="compostaUsuario.jsp" %></TD>
		</TR>	
	</TABLE>
</body>
</html>