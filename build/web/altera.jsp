<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.uninove.ensaio.Ensaio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar</title>
    </head>
    <body>
        <%
            Ensaio ensaio = (Ensaio) request.getAttribute("ensaio");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormat formatoNumero = new DecimalFormat("###0");
        %>
        <h1>Alterar</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="id" value="<%= ensaio.getId()%>" />
            <p><label>Nome: <input type="text" name="nome" value="<%= ensaio.getNome()%>"></label></p>
             <p><label>Data: <input type="date" name="data" value="<%= formato.format(ensaio.getDtEnsaio())%>" min="<%= formato.format(new Date(1))%>" max="formato.format(new Date())%>"></label></p>
            <p><label>Valor: <input type="number" name="valor" value="<%= formatoNumero.format(ensaio.getValor())%>" min="1" max="99999"></label></p>
            <p><input type="submit" value="Alterar"></p>
        </form>
        <p><a href="controle?acao=default">Voltar</a></p>
    </body>
</html>