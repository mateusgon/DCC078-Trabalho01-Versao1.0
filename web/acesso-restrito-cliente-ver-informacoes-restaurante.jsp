<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Informações restaurante </h1>
</div>
<div class="container">
    <label for="usr">Nome: ${restaurante.nome} </label>
    <br/>
    <label for="usr"> Sigla: ${restaurante.sigla} </label>
    <br/>
    <label for="usr">Telefone: ${restaurante.telefone} </label>
    <br/>
    <label for="usr">Endereço: ${restaurante.endereco} </label>
    <br/>
</div>
<%@include file="jspf/rodape.jspf" %>