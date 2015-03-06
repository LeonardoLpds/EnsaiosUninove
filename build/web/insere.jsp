<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir</title>
    </head>
    <body>
        <h1>Inserir</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="inserir" />
            <p><label>Nome: <input type="text" name="nome" placeholder="Digite o Nome"></label></p>
            <p><label>Data: <input type="date" name="data" placeholder="Data" min="1970-1-1" max="2015-3-6"></label></p>
            <p><label>Valor: <input type="number" name="valor" placeholder="Valor" min="1" max="99999"></label></p>
            <p><input type="submit" value="Inserir"></p>
        </form>
        <p><a href="controle?acao=default">Voltar</a></p>
    </body>
</html>
