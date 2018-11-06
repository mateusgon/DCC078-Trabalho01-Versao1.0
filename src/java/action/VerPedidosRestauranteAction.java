package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PedidoDAO;

public class VerPedidosRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("pedidos", PedidoDAO.getInstance().searchPedidoRestaurante(idRestaurante));
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-listar-pedidos.jsp");
        dispatcher.forward(request, response);
    }

}
