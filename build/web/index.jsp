<%@page import="java.util.List"%>
<%@page import="br.uninove.ensaio.Ensaio"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.uninove.ensaio.EnsaioService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ensaios</title>
        <style type="text/css">
            table{border-collapse: collapse;}
            th{background-color: green; color: whitesmoke;}
            th, td{padding: 10px;}
            table, th, td{border: 2px solid black}
            a{font-weight: bold; color: green;}
            a:link, a:visited{text-decoration: none;}
            a:hover, a:active{text-decoration: underline;}
            
        </style>
    </head>
    <body>
        <%
            EnsaioService service = new EnsaioService();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat formatoNumero = new DecimalFormat("R$ #,##0.00");
            List<Ensaio> ensaios = service.selecionarTodos();
            String msg = service.getMsg();
            if (!msg.equals("Sucesso")) {
                response.sendRedirect(String.format("controle?acao=exibirErro&msg=%s", msg));
            }
        %>
        <h1>listagem</h1>
        <table>
            <thead>
                <tr>
                    <th>Nome</th><th>Data</th><th>Valor</th><th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (ensaios != null) {
                        for (Ensaio ensaio : ensaios) {
                %>
                <tr>
                    <td><%= ensaio.getNome()%></td>
                    <td><%= formato.format(ensaio.getDtEnsaio())%></td>
                    <td><%= formatoNumero.format(ensaio.getValor())%></td>
                    <td>
                        <a href="controle?acao=excluir&id=<%= ensaio.getId()%>">Excluir</a>&nbsp;
                        <a href="controle?acao=excluir&id=<%= ensaio.getId()%>">Alterar</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
