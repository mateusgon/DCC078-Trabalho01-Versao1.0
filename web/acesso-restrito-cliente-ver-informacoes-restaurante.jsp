<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Informações restaurante </h1>
</div>

<div class="container text-center">
    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">

                    <label for="usr">Nome: ${restaurante.nome} </label>
                    <br/>
                    <label for="usr"> Sigla: ${restaurante.sigla} </label>
                    <br/>
                    <label for="usr">Telefone: ${restaurante.telefone} </label>
                    <br/>
                    <label for="usr">Endereço: ${restaurante.endereco} </label>
                    <br/>

                </div>
            </div>

        </div>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">

                    <i class="material-icons" style="font-size:123px;">
                        restaurant
                    </i>

                </div>
            </div>

        </div>
    </div>
</div>

<%@include file="jspf/rodape.jspf" %>