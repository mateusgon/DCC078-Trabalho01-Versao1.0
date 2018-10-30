<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Edite um restaurante </h1>
    </div>
     <div class="container">
            <form action="FrontController?action=EditarRestaurantePost" method="post">
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input name="nome" class="form-control" value="${restaurante.nome}" required>     
                </div>

                <div class="form-group">
                    <label for="usr">Nome Fantasia</label>
                    <input type="text" name="nomeFantasia" value="${restaurante.nomeFantasia}" class="form-control" required>     
                </div>

                <div class="form-group">
                    <label for="usr">Sigla</label>
                    <input  type="text" name="sigla" value="${restaurante.sigla}" class="form-control" required>     
                </div>
                
                <div class="form-group">
                    <label for="usr">Telefone:</label>
                    <input type = "phone" name="telefone" value="${restaurante.telefone}" class="form-control" required>     
                </div>
                
                <div class="form-group">
                    <label for="usr">Endereço:</label>
                    <input  type = "text"  name="endereco" value="${restaurante.endereco}" class="form-control" required>     
                </div>
                
                <input type ="hidden" name="idRestaurante" value="${restaurante.restaurantecod}">
                
                <input class="btn btn-primary btn" type ="Submit" value="Enviar"/> 
                <input class="btn btn-primary btn" type ="Reset" value ="Limpar" /> 
            </form>
</div>
<%@include file="jspf/rodape.jspf" %>