<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Pedido </h1>
</div>
<div class="container">
    <form action="FrontController?action=FazerPedidoPost" method="post">
        <div class="form-group">
            <label for="usr"> Prato de Entrada </label>
            <c:forEach var="entradas" items="${entradas}">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input"  name="entrada" value="${entradas.codigo}" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1"> ${entradas.nome} R$${entradas.valor} </label>
                </div>
            </c:forEach>
        </div>

        <div class="form-group">
            <label for="usr"> Prato Principal </label>
            <c:forEach var="principais" items="${principais}">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input"  name="principal" value="${principais.codigo}" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1"> ${principais.nome} R$${principais.valor} </label>
                </div>
            </c:forEach>
        </div>

        <div class="form-group">
            <label for="usr"> Bebidas </label>
            <c:forEach var="bebidas" items="${bebidas}">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input"  name="bebida" value="${bebidas.codigo}" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1"> ${bebidas.nome} R$${bebidas.valor} </label>
                </div>
            </c:forEach>
        </div>

        <div class="form-group">
            <label for="usr"> Sobremesas </label>
            <c:forEach var="sobremesas" items="${sobremesas}">
                <div class="form-check">

                    <input type="checkbox" class="form-check-input"  name="sobremesa" value="${sobremesas.codigo}" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1"> ${sobremesas.nome} R$${sobremesas.valor} </label>
                </div>
            </c:forEach>
        </div>

        <div class="form-group">
            <label for="usr"> Combos </label>
            <c:forEach var="combos" items="${combos}">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input"  name="combo" value="${combos.codigo}" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1"> ${combos.nome} R$${combos.valor} </label>
                    <a href="FrontController?action=VerCombo&id=${combos.codigo}&id2=${idRest}"> Ver itens do combo </a>
                </div>
            </c:forEach>
        </div>

        <div class="form-group">
            <label for="usr"> Forma de pagamento </label>
            <select class="form-control" name="pagamento" id="pagamento">
                <option value="1"> Cartão de crédito </option>
                <option value="2"> Cartão de débito </option>
                <option value="3"> Dinheiro </option>
            </select>
        </div>

        <input type ="hidden" name="idRest" value="${idRest}">
        <input type ="hidden" name="idUsr" value="${idUsuario}">
        <input class="btn btn-primary btn" type ="Submit" value="Fazer Pedido"/> 
        <input class="btn btn-primary btn" type ="Reset" value ="Limpar" /> 
    </form>
</div>
<%@include file="jspf/rodape.jspf" %>

