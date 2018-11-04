<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Cadastre um super-usu�rio </h1>
</div>
<div class="container">
    <form action="FrontController?action=EditarSuperUsuarioPost" method="post">
        <div class="form-group">
            <label for="usr">Nome:</label>
            <input name="nome" value="${pessoa.nome}" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr">Email</label>
            <input type="email" name="email" value="${pessoa.email}" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr">Senha:</label>
            <input type="password" name="senha" value="${pessoa.senha}" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr">Telefone:</label>
            <input type = "phone" value="${pessoa.telefone}" name="telefone" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr">Endere�o:</label>
            <input  type = "text" value="${pessoa.endereco}"  name="endereco" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr"> Cargos </label>
            <select class="form-control" name="cargos" id="cargos">
                <option value="2"> Atendente </option>
                <option value="3"> Chefe easy </option>
                <option value="4"> Chefe medium </option>
                <option value="5"> Chefe hard </option>
                <option value="6"> Motoboy </option>
            </select>
        </div>

        <input type ="hidden" name="idUsuario" value="${pessoa.pessoaCod}">
        <input type ="hidden" name="idRestaurante" value="${pessoa.restauranteCod}">
        <input class="btn btn-primary btn" type ="Submit" value="Enviar"/> 
        <input class="btn btn-primary btn" type ="Reset" value ="Limpar" /> 
    </form>
</div>
<%@include file="jspf/rodape.jspf" %>