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
                <td>ALUNO</td>
                <td>ESTADO</td>
                <td>MATRICULAR</td>
                <td>FORMAR</td>
                <td>TRANCAR</td>
                <td>RESTAURAR</td>
            </tr>

            <tbody>
                <c:forEach var="alunos"  items="${alunos}">

                    <tr>
         
                        <td>${alunos.nome}</td>
                        <td>${alunos.estado.nome}</td>
                        <td><a href="FrontController?action=MatricularAluno&id=${alunos.codigoAluno}">Matricular</a></td>
                        <td><a href="FrontController?action=FormarAluno&id=${alunos.codigoAluno}">Formar</a></td>
                        <td><a href="FrontController?action=TrancarAluno&id=${alunos.codigoAluno}">Trancar</a></td>
                        <td><a href="FrontController?action=RestaurarAluno&id=${alunos.codigoAluno}">Restaurar</a></td>

                    </tr>

                </c:forEach>


            </tbody>
        </table>

    </body>
</html>