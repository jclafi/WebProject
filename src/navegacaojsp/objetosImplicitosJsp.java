package navegacaojsp;

import java.io.IOException;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class objetosImplicitosJsp 
	extends org.apache.jasper.runtime.HttpJspBase 
		implements org.apache.jasper.runtime.JspSourceDependent {

	private static final long serialVersionUID = 1L;

	@Override
	public Map<String, Long> getDependants() {

		return null;
	}

	@Override
	public void _jspService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JspFactory _jspxFactory = null;
		PageContext pageContext = null;
//		HttpSession session = null;
//		ServletContext application = null;
//		ServletConfig config = null;
		JspWriter out = null;
//		Object page = this;
		JspWriter _jspxOut = null;
		PageContext _jspxpage_context = null;
				
		try {			
			_jspxFactory = JspFactory.getDefaultFactory();
			response.setContentType("text/html");
			pageContext = _jspxFactory.getPageContext(this, 
													  request, 
													  response, null,
													  true,
													  8192,
													  true);
			_jspxpage_context = pageContext;
			
//			application = pageContext.getServletContext();
//			config = pageContext.getServletConfig();
//			session = pageContext.getSession();
			out = pageContext.getOut();
			_jspxOut = out;
			
			out.write("<HTML>\n");
			out.write("  <TITLE> JSP> Olá Mundo ! </TITLE>\n");			
			out.write("  <BODY>\n  ");			
			out.write("		Este é o JSP Olá Mundo ! <BR>\n");			
			out.write("		");
			
			for (int index = 0; index <= 10; index++) {
				out.write("\n");			
				out.write("		O Valor de X é: ");			
				out.print(index);			
				out.write(" <BR>\n ");			
				out.write("		");				
			}
			
			out.write("\n");			
			out.write("  </BODY>\n");			
			out.write("</HTML>/n");
			out.close();
			
		}
		catch (Throwable ex) {
			if (! (ex instanceof SkipPageException)) {
				out = _jspxOut;
				
				if ((out != null) && (out.getBufferSize() != 0)) {
					out.clear();
				}
				
				if (_jspxpage_context != null) {
					_jspxpage_context.handlePageException(ex);
				}
			}
		}
		finally {		
			if (_jspxFactory != null) {
				_jspxFactory.releasePageContext(_jspxpage_context);
			}
			
		}
		
	}
	
}

