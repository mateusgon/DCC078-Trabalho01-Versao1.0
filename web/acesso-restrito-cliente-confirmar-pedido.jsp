<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Pedido </h1>
</div>
<div class="container">

    Nome: ${nomeUsuario} <br/>
    Número do Pedido ${idPedido} <br/>
    Valor: R$${valor} <br/>
    Restaurante: ${idRest} <br/>
    <a href="FrontController?action=ListarPedido&id=${idUsr}&id2=2"> Voltar </a>
</div>
<%@include file="jspf/rodape.jspf" %>

