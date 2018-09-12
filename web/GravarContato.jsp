<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Contatos</h1>
        <form action="FrontController?action=GravarContatoPost" method="post">
            Entre com seu nome
            <input type="text" name="textNome"/><br/>
            Entre com seu email
            <input type="text" name="textEmail"/><br/>
            Empresa
            <select name="valor">
            <c:forEach var="empresas" items="${empresas}">
                    <option value="${empresas.codigo}"> ${empresas.nome} </option>
            </c:forEach>
            </select>        <br/>
            <input type="submit"/>
        </form>    
    </body>
</html>
