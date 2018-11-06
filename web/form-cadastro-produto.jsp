<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Cadastre um produto </h1>
</div>
<div class="container">
    <form action="FrontController?action=CadastrarItemPost" method="post">
        <div class="form-group">
            <label for="usr">Nome:</label>
            <input name="nome" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr">Valor: (Ex: 20.00)</label>
            <input type = "text" name="valor" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr"> Tipo de item </label>
            <select class="form-control" name="tipoItem" id="tipoItem">
                <option value="1"> Prato de Entrada </option>
                <option value="2"> Prato Principal </option>
                <option value="3"> Bebida </option>
                <option value="4"> Sobremesa </option>
            </select>
        </div>

        <div class="form-group">
            <label for="usr"> Dificuldade </label>
            <select class="form-control" name="dificuldade" id="dificuldade">
                <option value="1"> Easy </option>
                <option value="2"> Medium </option>
                <option value="3"> Hard </option>
            </select>
        </div>

        <input type ="hidden" name="idRest" value="${idRest}">
        <input class="btn btn-primary btn" type ="Submit" value="Enviar"/> 
        <input class="btn btn-primary btn" type ="Reset" value ="Limpar" /> 
    </form>
</div>
<%@include file="jspf/rodape.jspf" %>