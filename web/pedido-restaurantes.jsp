<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Faça seu pedido </h1>
    </div>
    
<div class="container">
                                          
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">ORDENE POR:
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1"  style="background-color: white">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Data</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Avaliação</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Nome</a></li>
    </ul>

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
                        <td><a href="FrontController?action=FazerPedidoRestaurante&id=${restaurantes.restaurantecod}">Adicionar Usuario</a></td>
                    </tr>

                </c:forEach>


            </tbody>
            </table>
            
         
        </div>
        
    <%@include file="jspf/rodape.jspf" %>