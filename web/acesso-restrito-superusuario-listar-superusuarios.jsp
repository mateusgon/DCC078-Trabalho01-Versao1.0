<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Lista de super-usuários cadastrados por restaurante </h1>
</div>
<div class="container">
    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Restaurante </th>
                <th> Super-usuário </th>
                <th> Editar Super-Usuário </th>
                <th> Excluir Super-Usuário </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="restaurantes"  items="${restaurantes}">
                <c:forEach var="superusuarios" items="${restaurantes.superUsuarios}">
                    <tr>
                        <td>${restaurantes.nome}</td>
                        <td>${superusuarios.nome}</td>
                        <td><a href="FrontController?action=EditarSuperUsuario&id=${superusuarios.pessoaCod}"> Editar  </a></td>
                        <td><a href="FrontController?action=ExcluirSuperUsuario&id=${superusuarios.pessoaCod}"> Excluir</a></td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>