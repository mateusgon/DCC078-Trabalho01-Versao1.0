<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Meu Restaurante </h1>
</div>
<div class="container text-center">
    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=CadastrarItem&id=${idRestaurante}" >
                        <h5 class="card-title"> Cadastar item </h5>
                        <i class="material-icons" style="font-size:48px;">done</i>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=ListarItens&id=${idRestaurante}">
                        <h5 class="card-title"> Listar itens </h5>
                        <i class="material-icons" style="font-size:48px;">
                            search
                        </i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container text-center">
    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=CadastrarCombo&id=${idRestaurante}" >
                        <h5 class="card-title"> Cadastrar combo </h5>
                        <i class="material-icons" style="font-size:48px;">attach_money</i>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-sm-6" >
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=ListarCombos&id=${idRestaurante}">
                        <h5 class="card-title"> Listar combos </h5>
                        <i class="material-icons" style="font-size:48px;">
                            search
                        </i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="jspf/rodape.jspf" %>