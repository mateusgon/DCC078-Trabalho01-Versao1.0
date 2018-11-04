package action;

import PadraoComposite.Bebida;
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

public class VerComboAction implements Action {

    Integer idCombo;
    Integer idRestaurante;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        idCombo = Integer.parseInt(request.getParameter("id"));
        idRestaurante = Integer.parseInt(request.getParameter("id2"));
        ItemDeVenda combo = ComboDAO.getInstance().searchComboEspecifico(idCombo);
        List<Integer> idProdutos = ComboDAO.getInstance().searchComboProduto(combo.getCodigo());
        for (Integer idProduto : idProdutos) {
            Produto produto = ProdutoDAO.getInstance().listProduto(idProduto);
            instanciaCombo(produto, combo);
        }
        request.setAttribute("combo", combo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-ver-combo.jsp");
        dispatcher.forward(request, response);

    }

    public void instanciaCombo(Produto produto, ItemDeVenda combo) throws Exception {
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
