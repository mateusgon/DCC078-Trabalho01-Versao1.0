<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Lista de mensagens </h1>
</div>
<div class="container">
    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Mensagens </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="mensagens"  items="${mensagens}">
                <tr>
                    <td>${mensagens.mensagem}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>