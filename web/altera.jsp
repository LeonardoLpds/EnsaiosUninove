<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar</title>
    </head>
    <body>
        <h1>Alterar</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="id" value="0" />
            <p><label>Nome: <input type="text" name="nome" value="Nome do Cliente"></label></p>
            <p><label>Data: <input type="date" name="data" value="2015-1-1" min="1970-1-1" max="2015-3-6"></label></p>
            <p><label>Valor: <input type="number" name="valor" value="1" min="1" max="99999"></label></p>
            <p><input type="submit" value="Alterar"></p>
        </form>
        <p><a href="controle?acao=default">Voltar</a></p>
    </body>
</html>