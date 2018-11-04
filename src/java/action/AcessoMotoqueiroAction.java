package action;

import PadraoStateObserverMemento.Pedido;
import controller.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PedidoDAO;

public class AcessoMotoqueiroAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        List<Pedido> pedidos = PedidoDAO.getInstance().searchPedidoRestaurante(idRestaurante);
        List<Pedido> pedidosLista = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNomeEstado().equals("Pronto"))
            {
                pedidosLista.add(pedido);
            }
        }
        request.setAttribute("pedidos", pedidosLista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-motoqueiro.jsp");
        dispatcher.forward(request, response);
    }

}
