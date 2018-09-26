<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Listar Estados</title>
    </head>
    <body>
        <h1> Listar estados </h1>


        <table style="width: 76px;">
            <tr>
                <td>ESTADO</td>
                <td>Hora</td>
            
            </tr>

            <tbody>
                <c:forEach var="alunos"  items="${alunos}">

                    <tr>
         
                  
                    <td><a href="FrontController?action=RestaurarPost&id=${id}&id2=${alunos.codMemento}">${alunos.estado.nome}</a></td>

                    </tr>

                </c:forEach>


            </tbody>
        </table>

    </body>
</html>