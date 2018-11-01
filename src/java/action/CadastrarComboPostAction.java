package action;

import PadraoComposite.Bebida;
import PadraoComposite.Combo;
import PadraoComposite.ItemDeVenda;
import PadraoComposite.PratoDeEntrada;
import PadraoComposite.PratoPrincipal;
import PadraoComposite.Sobremesa;
import controller.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ComboDAO;
import persistence.ProdutoDAO;

public class CadastrarComboPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("idRest"));
        String nome = request.getParameter("nome");
        Double valor = Double.parseDouble(request.getParameter("valor"));
        Integer itensCombo[] = new Integer[4];
        itensCombo[0] = Integer.parseInt(request.getParameter("entrada"));
        itensCombo[1] = Integer.parseInt(request.getParameter("principal"));
        itensCombo[2] = Integer.parseInt(request.getParameter("bebida"));
        itensCombo[3] = Integer.parseInt(request.getParameter("sobremesa"));
        Integer dificuldade = Integer.parseInt(request.getParameter("dificuldade"));
        Boolean cadastrouItem = false;
        List<ItemDeVenda> itens = new ArrayList<>();
        ItemDeVenda combo = new Combo(itens, -1, nome, valor, dificuldade, idRestaurante);
        for (Integer i = 0; i < 4; i++) {
            if (itensCombo[i] != 0) {
                cadastrouItem = true;
                Produto produto = ProdutoDAO.getInstance().listProduto(itensCombo[i]);
                if (produto.getTipoItem() == 1) {
                    ItemDeVenda entrada = new PratoDeEntrada(produto.getProdutocod(), produto.getNome(), produto.getValor(), produto.getDificuldade(), idRestaurante);
                    combo.adicionar(entrada);
                } else if (produto.getTipoItem() == 2) {
                    ItemDeVenda principal = new PratoPrincipal(produto.getProdutocod(), produto.getNome(), produto.getValor(), produto.getDificuldade(), idRestaurante);
                    combo.adicionar(principal);
                } else if (produto.getTipoItem() == 3) {
                    ItemDeVenda bebida = new Bebida(produto.getProdutocod(), produto.getNome(), produto.getValor(), produto.getDificuldade(), idRestaurante);
                    combo.adicionar(bebida);
                } else {
                    ItemDeVenda sobremesa = new Sobremesa(produto.getProdutocod(), produto.getNome(), produto.getValor(), produto.getDificuldade(), idRestaurante);
                    combo.adicionar(sobremesa);
                }
            }
        }
        if (cadastrouItem) {
            ComboDAO.getInstance().saveCombo(combo);
            request.setAttribute("idRest", idRestaurante);
            RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-restaurante.jsp");
            dispatcher.forward(request, response);
        } else {

        }
    }

}
