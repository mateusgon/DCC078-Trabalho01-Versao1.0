<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Veja Cardapio e faço seu pedido </h1>
</div>
<div class="container">
    

            <table class="table table-bordered" style="background-color: white">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Prato</th>
                        <th>Valor</th>
                        <th>Avaliação</th>
                      
                    </tr>
                </thead>
               
            <tbody>
               

                    <tr>
                        <td>Codigo</td>
                        <td>Combo 1</td>
                        <td>Valor</td>
                        <td>Top</td>
                    <tr>    
                         <tr>
                        <td>Codigo</td>
                        <td>Combo 1</td>
                        <td>Valor</td>
                        <td>Top</td>
                    <tr>    
                      
                           <tr>
                        <td>Codigo</td>
                        <td>Combo 1</td>
                        <td>Valor</td>
                        <td>Top</td>
                    <tr>    
                      
                           <tr>
                        <td>Codigo</td>
                        <td>Combo 1</td>
                        <td>Valor</td>
                        <td>Top</td>
                    <tr>    
                      
                           <tr>
                        <td>Codigo</td>
                        <td>Combo 1</td>
                        <td>Valor</td>
                        <td>Top</td>
                    <tr>    
                      
               



            </tbody>
            </table>
            
    <hr>
    <form action="FrontController?action=CadastrarSuperUsuarioPost" method="post">

        <div class="form-group">
            <label for="usr">Restaurante</label>
            <input  type="text" name="restauranteCod" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr">Codigo do prato</label>
            <input type = "phone" name="telefone" class="form-control" required>     
        </div>

        <div class="form-group">
            <label for="usr">Tamanho:</label>
            <div class="radio">
                <label><input type="radio" name="optradio" checked>Tamanho Individual</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="optradio">Tamanho Médio</label>
            </div>
            <div class="radio disabled">
                <label><input type="radio" name="optradio" disabled>Tamanho Família</label>
            </div> 
        </div>
         
         <div class="form-group">
            <label for="usr">Quantidade</label>
            <input type = "number" name="telefone" class="form-control" required>     
        </div>
            



        <input class="btn btn-primary btn" type ="Submit" value="Enviar"/> 
        <input class="btn btn-primary btn" type ="Reset" value ="Limpar" /> 
    </form>
</div>
<%@include file="jspf/rodape.jspf" %>