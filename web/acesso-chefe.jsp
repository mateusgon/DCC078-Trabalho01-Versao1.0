<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1>Lista De Pedidos Abertos </h1>
</div>

<div class="container">


    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Número do Pedido </th>
                <th> Cliente </th>
                <th> Estado </th>
                <th> Itens do Pedido </th>
                <th> Mudar status </th>

            </tr>
        </thead>
        <tbody>

            <c:forEach var="pedidos"  items="${pedidos}">
                <tr>
                    <td>${pedidos.numeroPedido}</td>
                    <td>${pedidos.cliente.nome}</td>
                    <td>${pedidos.nomeEstado}</td>
                    <td><a href="FrontController?action=VerInformacoesDoPedido&id=${pedidos.numeroPedido}"> Ver Itens do Pedido </a></td>
                    <td><a href="FrontController?action=MudarEstado&id=${pedidos.numeroPedido}&id2=${idChefe}"> Mudar estado </a></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>