<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Bem vindo ao sistema de pedidos </h1>
</div>
<div class="container text-center">
    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-4" >
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=CadastrarSuperUsuarioRestaurante">
                        <h5 class="card-title">Cadastrar super-usuários</h5>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-sm-4" >
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=ListarSuperUsuarios">
                        <h5 class="card-title"> Listar super-usuários</h5>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="jspf/rodape.jspf" %>