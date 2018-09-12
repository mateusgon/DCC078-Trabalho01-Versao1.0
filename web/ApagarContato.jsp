<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Apagar contatos </h1>
        <form action="FrontController?action=ApagarContatoPost" method="post">
            Entre com o nome a ser excluído
            <input type="text" name="textNome"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
