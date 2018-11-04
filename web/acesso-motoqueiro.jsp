<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1>Lista De Pedidos Abertos </h1>
</div>

<div class="container">

    <div class="dropdown">
        <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Pedidos Fechados:
            <span class="caret"></span></button>
        <ul class="dropdown-menu" role="menu" aria-labelledby="menu1"  style="background-color: white">
            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Pedidos Fechados</a></li>

        </ul>
    </div>   
    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Número do Pedido </th>
                <th> Cliente </th>
                <th> Endereço </th>
                <th> Status </th>
            </tr>
        </thead>
        <tbody>


            <c:forEach var="pedidos"  items="${pedidos}">
                <tr>
                    <td>${pedidos.numeroPedido}</td>
                    <td>${pedidos.cliente.nome}</td>
                    <td>${pedidos.cliente.endereco}</td>
                    <td><a href="FrontController?action=MudaEstadoPedido&id=${pedidos.numeroPedido}"> ${pedidos.nomeEstado} </a></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>