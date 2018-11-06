package action;

import PadraoStateObserverMemento.Pedido;
import PadraoStateObserverMemento.PedidoMemento;
import controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PedidoDAO;
import persistence.PedidoMementoDAO;

public class ReverterPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idCodigoMemento = Integer.parseInt(request.getParameter("id"));
        PedidoMemento pm = PedidoMementoDAO.getInstance().searchMementoPosicao(idCodigoMemento);
        Pedido pedido = PedidoDAO.getInstance().searchPedidoNumPedido(pm.getNumeroPedido());
        pedido.restoreFromMemento(pm);
        PedidoDAO.getInstance().updatePedido(pedido, codigoEstado(pedido));
        PedidoMementoDAO.getInstance().Update(idCodigoMemento, pedido.getNumeroPedido());
    }

    public Integer codigoEstado(Pedido pedido) {
        switch (pedido.getEstado().getNomeEstado()) {
            case "Aberto":
                return 1;
            case "Preparando":
                return 2;
            case "Pronto":
                return 3;
            case "Enviado":
                return 4;
            case "Recebido":
                return 5;
            default:
                return -1;
        }
    }

}
