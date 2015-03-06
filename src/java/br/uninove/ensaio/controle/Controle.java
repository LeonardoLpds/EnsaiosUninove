package br.uninove.ensaio.controle;

import br.uninove.ensaio.Ensaio;
import br.uninove.ensaio.EnsaioService;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controle", urlPatterns = {"/controle"})
public class Controle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        EnsaioService servico = new EnsaioService();
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        String acao = request.getParameter("acao");
        if (acao == null) {
            acao = "default";
        }
        if (acao.equals("")) {
            acao = "default";
        }

        String msg = request.getParameter("msg");
        String id = request.getParameter("id");
        int idN;
        String nome = request.getParameter("nome");
        String data = request.getParameter("data");
        Date dataD;
        String valor = request.getParameter("valor");
        if (valor == null) {
            valor = "-1";
        }
        if (valor.equals("")) {
            valor = "-1";
        }
        BigDecimal valorBD;

        switch (acao) {
            case "formIncluir":
                rd = request.getRequestDispatcher("insere.jsp");
                break;
            case "formaAlterar":
                idN = Integer.parseInt(id);
                Ensaio ensaio = servico.selecionarPorId(idN);
                msg = servico.getMsg();
                if (msg.equals("Sucesso")) {
                    rd = request.getRequestDispatcher("alterar.jsp");
                    request.setAttribute("ensaio", ensaio);
                } else {
                    rd = request.getRequestDispatcher("mensagem.jsp");
                    request.setAttribute("msg", msg);
                }
                break;
            case "alterar":
                idN = Integer.parseInt(id);
                try {
                    dataD = formato.parse(data);
                } catch (ParseException ex) {
                    dataD = new Date();
                }
                valorBD = BigDecimal.valueOf(Double.parseDouble(valor));
                servico.alterar(idN, nome, dataD, valorBD);
                msg = servico.getMsg();
                if(!msg.equals("Sucesso")){
                    rd = request.getRequestDispatcher("mensagem.jsp");
                    request.setAttribute("msg", msg);
                }
                break;
            case "inserir":
                try {
                    dataD = formato.parse(data);
                } catch (ParseException ex) {
                    dataD = new Date();
                }
                valorBD = BigDecimal.valueOf(Double.parseDouble(valor));
                servico.inserir(nome, dataD, valorBD);
                msg = servico.getMsg();
                if(!msg.equals("Sucesso")){
                    rd = request.getRequestDispatcher("mensagem.jsp");
                    request.setAttribute("msg", msg);
                }
                break;
                
            case "excluir":
                idN = Integer.parseInt(id);
                servico.apagar(idN);
                msg = servico.getMsg();
                if(!msg.equals("Sucesso")){
                    rd = request.getRequestDispatcher("mensagem.jsp");
                    request.setAttribute("msg", msg);
                }
                break;
                
            case "exibirErro":
                rd = request.getRequestDispatcher("mensagem.jsp");
                request.setAttribute("msg", msg);
                break;
            case "default":
            default:
                break;
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
