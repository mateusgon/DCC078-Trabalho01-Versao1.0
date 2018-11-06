package action;

import PadraoComposite.ItemDeVenda;
import PadraoStateObserverMemento.Pedido;
import controller.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PedidoDAO;

public class VerInformacoesDoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idPedido = Integer.parseInt(request.getParameter("id"));
        Pedido pedido = PedidoDAO.getInstance().searchPedidoNumPedido(idPedido);
        List<ItemDeVenda> combos = new ArrayList<>();
        List<ItemDeVenda> produtos = new ArrayList<>();
        List<ItemDeVenda> itens = pedido.getItens();
        for (Iterator i = itens.iterator(); i.hasNext();) {
            ItemDeVenda iten = (ItemDeVenda) i.next();
            if (iten.getNome().contains("Combo")) {
                combos.add(iten);
            } else {
                produtos.add(iten);
            }
        }
        request.setAttribute("pedido", pedido);
        request.setAttribute("combos", combos);
        request.setAttribute("produtos", produtos);
        request.setAttribute("idRest", pedido.getIdRestaurante());
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-ver-pedido.jsp");
        dispatcher.forward(request, response);
    }

}
