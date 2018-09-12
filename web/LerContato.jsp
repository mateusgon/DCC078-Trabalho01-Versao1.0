<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Ler contatos </h1>
        <form action="FrontController?action=LerContatoPost" method="post">
            Entre com o nome a ser encontrado
            <input type="text" name="textNome"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
