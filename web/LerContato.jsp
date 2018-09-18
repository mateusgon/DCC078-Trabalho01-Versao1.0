<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Ler contatos </h1>
        <c:forEach var="alunos"  items="${alunos}">
        <tr>
            <td>${alunos.nome}</td>
        </tr>
    
    </c:forEach>
</body>
</html>
