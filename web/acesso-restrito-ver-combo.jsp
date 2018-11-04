<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Combo ${combo.nome} </h1>
</div>
<div class="container">
    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Produto </th>
                <th> Valor </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="combos"  items="${combo.itens}">
                <tr>
                    <td>${combos.nome}</td>
                    <td>${combos.valor}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<%@include file="jspf/rodape.jspf" %>