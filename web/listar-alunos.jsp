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


        <table style="width: 76px;">
            <tr>
                <td >&nbsp;ALUNO</td>
                <td >ESTADO</td>
                <td >MATRICULAR</td>
                <td >FORMAR</td>
                <td >TRANCAR</td>
            </tr>

            <tbody>
                <c:forEach var="alunos"  items="${alunos}">

                    <tr>
                        <td>${alunos.nome}</td>
                        <td>${alunos.estado.nome}</td>
                        <td>Matricular</td>
                        <td>Formar</td>
                        <td>Trancar</td>
                    </tr>

                </c:forEach>


            </tbody>
        </table>

    </body>
</html>