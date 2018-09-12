<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alteração de Contatos</h1>
        <form action="FrontController?action=AlterarContatoPost" method="post">
            Entre com seu nome
            <input type="text" name="textNome"/><br/>
            Entre com seu email
            <input type="text" name="textEmail"/><br/>
            <input type="submit"/>
        </form>  
    </body>
</html>
