
package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FazerPedidoRestauranteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       Integer restauranteCod = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("restauranteCod", restauranteCod);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-fazer-pedido.jsp");
        dispatcher.forward(request, response);
    }
    
}
