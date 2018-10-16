<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Restaurantes cadastrados </h1>
    </div>
    
<div class="container">
        

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Restaurante</th>
                        <th>Nome Fantasia</th>
                        <th>Sigla</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
               
            <tbody>
                <c:forEach var="restaurantes"  items="${restaurantes}">

                    <tr>
         
                        <td>${restaurantes.nome}</td>
                        <td>${restaurantes.nomeFantasia}</td>
                        <td>${restaurantes.sigla}</td>
                        <td><a href="FrontController?action=ExcluirRestaurante&id=${restaurantes.restaurantecod}">Excluir</a></td>
                    </tr>

                </c:forEach>


            </tbody>
            </table>
            
         
        </div>
        
    <%@include file="jspf/rodape.jspf" %>