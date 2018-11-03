package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PedidoDAO;

public class ListarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idUsuario = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("pedidos", PedidoDAO.getInstance().searchPedido(idUsuario));
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-cliente-listar-pedido.jsp");
        dispatcher.forward(request, response);
    }

}
