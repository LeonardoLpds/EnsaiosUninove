package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import br.uninove.ensaio.Ensaio;

public final class altera_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Alterar</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Ensaio ensaio = (Ensaio) request.getAttribute("ensaio");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormat formatoNumero = new DecimalFormat("###0");
        
      out.write("\n");
      out.write("        <h1>Alterar</h1>\n");
      out.write("        <form method=\"post\" action=\"controle\">\n");
      out.write("            <input type=\"hidden\" name=\"acao\" value=\"alterar\" />\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.print( ensaio.getId());
      out.write("\" />\n");
      out.write("            <p><label>Nome: <input type=\"text\" name=\"nome\" value=\"");
      out.print( ensaio.getNome());
      out.write("\"></label></p>\n");
      out.write("             <p><label>Data: <input type=\"date\" name=\"data\" value=\"");
      out.print( formato.format(ensaio.getDtEnsaio()));
      out.write("\" min=\"");
      out.print( formato.format(new Date(1)));
      out.write("\" max=\"formato.format(new Date())%>\"></label></p>\n");
      out.write("            <p><label>Valor: <input type=\"number\" name=\"valor\" value=\"");
      out.print( formatoNumero.format(ensaio.getValor()));
      out.write("\" min=\"1\" max=\"99999\"></label></p>\n");
      out.write("            <p><input type=\"submit\" value=\"Alterar\"></p>\n");
      out.write("        </form>\n");
      out.write("        <p><a href=\"controle?acao=default\">Voltar</a></p>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
