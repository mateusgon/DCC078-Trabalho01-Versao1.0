<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Lista de restaurantes </h1>
</div>
<div class="container">
    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Restaurante </th>
                <th> Informações </th>
                <th> Cardápio </th>
                <th> Compra </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="restaurantes"  items="${restaurantes}">
                <tr>
                    <td>${restaurantes.nome}</td>
                    <td><a href="FrontController?action=VerInformacoesRestaurante&id=${restaurantes.restaurantecod}"> Ver informações  </a></td>
                    <td><a href="FrontController?action=VerCardapio&id=${restaurantes.restaurantecod}"> Ver cardápio  </a></td>
                    <td><a href="FrontController?action=FazerPedido&id=${restaurantes.restaurantecod}&id2=${idUsuario}"> Fazer pedido </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>