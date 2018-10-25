<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Restaurantes cadastrados </h1>
    </div>
    
<div class="container">
        

            <table class="table table-bordered"  style="background-color: white">
                <thead>
                    <tr>
                        <th>Restaurante</th>
                        <th>Sigla</th>
                        <th>Cadastrar Super-Usuario</th>
                        <th>Data Criação</th>
                    </tr>
                </thead>
               
            <tbody>
                <c:forEach var="restaurantes"  items="${restaurantes}">

                    <tr>
                        <td>${restaurantes.nome}</td>
                        <td>${restaurantes.nomeFantasia}</td>
                        <td>${restaurantes.sigla}</td>
                        <td><a href="FrontController?action=CadastrarSuperUsuario&id=${restaurantes.restaurantecod}">Adicionar Usuario</a></td>
                    </tr>

                </c:forEach>


            </tbody>
            </table>
            
         
        </div>
        
    <%@include file="jspf/rodape.jspf" %>