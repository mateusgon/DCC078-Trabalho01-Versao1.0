
package action;

import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;

public class VerPedidoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        //Inserir consulta de ver pedidos
        List <Restaurante> restaurantes =  RestauranteDAO.getInstance().listAll();
        request.setAttribute("restaurantes", restaurantes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ver-pedidos.jsp");
        dispatcher.forward(request, response);
    }
    
}
