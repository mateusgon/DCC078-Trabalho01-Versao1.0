<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="jspf/cabecalho.jspf" %>
    <div class="container text-center">
        <h1> Ver meus pedidos </h1>
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
    <hr>
            <table class="table table-bordered"  style="background-color: white">
                <thead>
                    <tr>
                        <th>Pedido</th>
                        <th>Restaurante</th>
                        <th>Estado</th>
                        <th>Ver estados</th>
                    </tr>
                </thead>
               
            <tbody>
                <c:forEach var="pedidos"  items="${pedidos}">

                    <tr>
         
                        <td>${pedidos.nome}</td>
                        <td>${pedidos.restaurante}</td>
                        <td>${pedidos.estado}</td>
                        <td><a href="FrontController?action=ExcluirRestaurante&id=${restaurantes.restaurantecod}">Ver Estados</a></td>
                    </tr>

                </c:forEach>


            </tbody>
            </table>
            
         
        </div>
        
    <%@include file="jspf/rodape.jspf" %>