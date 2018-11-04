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
                <th> Endereço </th>
                <th> Ver Itens </th>
            </tr>
        </thead>
        <tbody>
    
            
       <!-- Apagar isso -->
        <tr>
                    <td>2313</td>
                    <td>Cliente</td>
                    <td>Rua numero 12</td>
                    <td>Itens do Pedido</td>
                    
        </tr>
                
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>