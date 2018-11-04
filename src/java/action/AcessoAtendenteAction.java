package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PedidoDAO;

public class AcessoAtendenteAction implements controller.Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("pedidos", PedidoDAO.getInstance().searchPedidoRestaurante(idRestaurante));
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-atendente.jsp");
        dispatcher.forward(request, response);
    }

}
