package action;

import PadraoStateObserverMemento.Pedido;
import controller.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PedidoDAO;

public class MudarEstadoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idPedido = Integer.parseInt(request.getParameter("id"));
        Integer idChefe = Integer.parseInt(request.getParameter("id2"));
        Pedido pedido = PedidoDAO.getInstance().searchPedidoNumPedido(idPedido);
        String nomeEstado = null;
        if (pedido.getNomeEstado().equals("Aberto")) {
            nomeEstado = "Preparar";
        } else if (pedido.getNomeEstado().equals("Preparar")) {
            nomeEstado = "Pronto";
        } else if (pedido.getNomeEstado().equals("Pronto")) {
            nomeEstado = "Enviar";
        } else if (pedido.getNomeEstado().equals("Enviar")) {
            nomeEstado = "Receber";
        }
        request.setAttribute("estadoAtual", pedido.getNomeEstado());
        request.setAttribute("estadoFuturo", nomeEstado);
        request.setAttribute("idPed", idPedido);
        request.setAttribute("idChefe", idChefe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-mudar-estado.jsp");
        dispatcher.forward(request, response);
    }

}
