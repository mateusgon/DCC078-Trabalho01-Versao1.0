<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Lista de combos cadastrados </h1>
</div>
<div class="container">
    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Produto </th>
                <th> Valor </th>
                <th> Itens de Venda </th>
                <th> Editar </th>
                <th> Excluir </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="combos"  items="${combos}">
                <tr>
                    <td>${combos.nome}</td>
                    <td>${combos.valor}</td>
                    <td><a href="FrontController?action=VerCombo&id=${combos.codigo}&id2=${idRest}"> Ver </a></td>
                    <td><a href="FrontController?action=EditarCombo&id=${combos.codigo}&id2=${idRest}"> Editar </a></td>
                    <td><a href="FrontController?action=ExcluirCombo&id=${combos.codigo}&id2=${idRest}"> Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>