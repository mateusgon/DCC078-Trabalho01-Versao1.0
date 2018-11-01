<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Cadastre um combo </h1>
</div>
<div class="container">
    <form action="FrontController?action=CadastrarComboPost" method="post">
        <div class="form-group">
            <label for="usr">Nome:</label>
            <input name="nome" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr">Valor:</label>
            <input type = "text" name="valor" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr"> Prato de Entrada </label>
            <select class="form-control" name="entrada" id="entrada">
                <option value="0"> Nenhum </option>
                <c:forEach var="entradas" items="${entradas}">
                    <option value="${entradas.codigo}"> ${entradas.nome} </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="usr"> Prato Principal </label>
            <select class="form-control" name="principal" id="principal">
                <option value="0"> Nenhum </option>
                <c:forEach var="principais" items="${principais}">
                    <option value="${principais.codigo}"> ${principais.nome} </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="usr"> Bebidas </label>
            <select class="form-control" name="bebida" id="bebida">
                <option value="0"> Nenhum </option>
                <c:forEach var="bebidas" items="${bebidas}">
                    <option value="${bebidas.codigo}"> ${bebidas.nome} </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="usr"> Sobremesas </label>
            <select class="form-control" name="sobremesa" id="sobremesa">
                <option value="0"> Nenhum </option>
                <c:forEach var="sobremesas" items="${sobremesas}">
                    <option value="${sobremesas.codigo}"> ${sobremesas.nome} </option>
                </c:forEach>
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