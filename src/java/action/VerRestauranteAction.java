
package action;

import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;


public class VerRestauranteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //aqui acho que teremos que passar o codigo do usuario
        //devemos setar o cardapio
        List <Restaurante> restaurantes =  RestauranteDAO.getInstance().listAll();
        request.setAttribute("restaurantes", restaurantes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pedido-restaurantes.jsp");
        dispatcher.forward(request, response);
    }
    
}
