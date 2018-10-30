<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Bem vindo ao sistema de pedidos ${authUser} </h1>
</div>
<div class="container text-center">

    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=CadastrarCliente">
                        <h5 class="card-title">Criar conta</h5>
                        <i class="material-icons" style="font-size:100px;"> account_circle </i>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=FazerPedido">
                        <h5 class="card-title">Faça um Pedido</h5>
                        <i class="material-icons" style="font-size:100px;">local_dining</i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="jspf/rodape.jspf" %>