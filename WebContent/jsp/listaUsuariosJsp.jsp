<%@ page 	language="java" 
			contentType="text/html; charset=ISO-8859-1"
    		pageEncoding="ISO-8859-1"
			import = "basicas.Pessoa"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- Retorna o Array de Usuários da Request --%>
<% Pessoa[] arrayPessoa = (Pessoa[]) request.getAttribute("Pessoa"); %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Navegação JSP</title>
	</head>
	
	<body>
		<table border="1">
			<tr>
				<td>
					Objeto session (HttpSession)ID:<br/>
					<%= session.getId() %>
				</td>							
			</tr>
			
			<tr>
				<td>
					Objeto Application (ServletContext)<br/>
					ServerInfo: <%= application.getServerInfo() %>
				</td>
			</tr>
			
			<tr>
				<td>
					Lista de Usuários Cadastrados:					 
				</td>				
			</tr>	
			
			<tr>
				<td>
					<table border = "1">
						<% for(Pessoa index : arrayPessoa) { %>
							<tr>
								<td>Nome:</td>
								<td>
									<%= index.getNome() %>
								</td>
							</tr>
						
							<tr>
								<td>Email:</td>
								<td>
									<%= index.getEmail() %>
								</td>
							</tr>						
						
							<tr>
								<td>Telefones:</td>
								<td>
									<% String[] arrayTelefone = index.getTelefone(); %>
									<%= arrayTelefone[0] %>
									<%= arrayTelefone[1] %>									
								</td>
							</tr>													
						<%}%>												
					</table>
				</td>			
			</tr>		
		</table>		
	</body>
</html>