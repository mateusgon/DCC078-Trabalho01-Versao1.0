<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Lista de funcionários do seu restaurante </h1>
    2 (Atendente), 3 (Chefe 01), 4 (Chefe 02), 5 (Chefe 03), 6 (Motoboy)
</div>
<div class="container">
    <table class="table table-bordered"  style="background-color: white">
        <thead>
            <tr>
                <th> Funcionário </th>
                <th> Telefone </th>
                <th> Email </th>
                <th> Cargo </th>
                <th> Editar </th>
                <th> Excluir </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="funcionarios"  items="${listFuncionarios}">
                <tr>
                    <td>${funcionarios.nome}</td>
                    <td>${funcionarios.telefone}</td>
                    <td>${funcionarios.email}</td>
                    <td>${funcionarios.tipoPessoa}</td>
                    <td><a href="FrontController?action=EditarFuncionario&id=${funcionarios.pessoaCod}"> Editar  </a></td>
                    <td><a href="FrontController?action=ExcluirFuncionario&id=${funcionarios.pessoaCod}&id2=${funcionarios.restauranteCod}"> Excluir </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/rodape.jspf" %>