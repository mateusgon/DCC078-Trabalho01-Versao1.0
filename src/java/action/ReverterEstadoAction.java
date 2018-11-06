package action;

import PadraoStateObserverMemento.PedidoMemento;
import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PedidoMementoDAO;

public class ReverterEstadoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idPedido = Integer.parseInt(request.getParameter("id"));
        List<PedidoMemento> pms = PedidoMementoDAO.getInstance().searchMemento(idPedido);
        request.setAttribute("memento", pms);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-reverter-estado.jsp");
        dispatcher.forward(request, response);
    }

}
