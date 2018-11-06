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
                <th> Horário </th>
                <th> Endereço </th>
                <th> Status </th>
                <th> Valor </th>
                <th> Detalhes </th>
            </tr>
        </thead>
        <tbody>


            <c:forEach var="pedidos"  items="${pedidos}">
                <tr>
                    <td>${pedidos.numeroPedido}</td>
                    <td>${pedidos.cliente.nome}</td>
                    <td>${pedidos.dataPedido}</td>
                    <td>${pedidos.cliente.endereco}</td>
                    <td>${pedidos.nomeEstado}</td>
                    <td>R$${pedidos.valor}</td>
                    <td><a href="FrontController?action=VerInformacoesDoPedido&id=${pedidos.numeroPedido}"> Ver Itens do Pedido </a></td>
                </tr>
            </c:forEach>


        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>