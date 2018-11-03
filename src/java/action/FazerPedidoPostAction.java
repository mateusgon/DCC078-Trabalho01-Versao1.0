package action;

import PadraoStateObserverMemento.Pedido;
import controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FazerPedidoPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pedido pedido = new Pedido();
        Integer pagamento = Integer.parseInt(request.getParameter("pagamento"));
        Integer idUsr = Integer.parseInt(request.getParameter("idUsr"));
        Integer idRest = Integer.parseInt(request.getParameter("idRest"));
        pedido.setIdCliente(idUsr);
        pedido.setIdCliente(idRest);
        String[] posicoes = request.getParameterValues("entrada");
        String[] posicoes2 = request.getParameterValues("principal");
        String[] posicoes3 = request.getParameterValues("bebida");
        String[] posicoes4 = request.getParameterValues("sobremesa");
        String[] posicoes5 = request.getParameterValues("combo");
        if (posicoes != null && posicoes.length > 0) {
            Integer[] requisicao = new Integer[posicoes.length];
            for (int i = 0; i < posicoes.length; i++) {
                requisicao[i] = Integer.parseInt(posicoes[i]);
            }
        }
        if (posicoes2 != null && posicoes2.length > 0) {
            Integer[] requisicao2 = new Integer[posicoes2.length];
            for (int i = 0; i < posicoes2.length; i++) {
                requisicao2[i] = Integer.parseInt(posicoes2[i]);
            }
        }
        if (posicoes3 != null && posicoes3.length > 0) {
            Integer[] requisicao3 = new Integer[posicoes3.length];
            for (int i = 0; i < posicoes3.length; i++) {
                requisicao3[i] = Integer.parseInt(posicoes3[i]);
            }
        }
        if (posicoes4 != null && posicoes4.length > 0) {
            Integer[] requisicao4 = new Integer[posicoes4.length];
            for (int i = 0; i < posicoes4.length; i++) {
                requisicao4[i] = Integer.parseInt(posicoes4[i]);
            }
        }
        if (posicoes5 != null && posicoes5.length > 0) {
            Integer[] requisicao5 = new Integer[posicoes5.length];
            for (int i = 0; i < posicoes5.length; i++) {
                requisicao5[i] = Integer.parseInt(posicoes5[i]);
            }
        }
    }

}
