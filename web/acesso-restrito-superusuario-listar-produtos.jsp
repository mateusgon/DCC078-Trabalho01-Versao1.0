<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Lista de restaurantes cadastrados </h1>
</div>
<div class="container">
    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Produto </th>
                <th> Valor </th>
                <th> Editar </th>
                <th> Excluir </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produtos"  items="${produtos}">
                <tr>
                    <td>${produtos.nome}</td>
                    <td>${produtos.valor}</td>
                    <td><a href="FrontController?action=EditarItem&id=${produtos.produtocod}&id2=${idRest}"> Editar  </a></td>
                    <td><a href="FrontController?action=ExcluirItem&id=${produtos.produtocod}&id2=${idRest}"> Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>