<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Bem vindo ao sistema de pedidos </h1>
</div>
<div class="container text-center">

    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=CadastrarRestaurante">
                        <h5 class="card-title">Cadastrar restaurantes</h5>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-sm-4" >
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=ListarRestaurantes&id2=1">
                        <h5 class="card-title">Listar restaurantes</h5>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="jspf/rodape.jspf" %>