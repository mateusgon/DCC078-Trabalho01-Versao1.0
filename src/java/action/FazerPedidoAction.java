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

public class FazerPedidoAction implements Action {

    List<ItemDeVenda> pratosDeEntrada = new ArrayList<>();
    List<ItemDeVenda> pratosPrincipais = new ArrayList<>();
    List<ItemDeVenda> bebidas = new ArrayList<>();
    List<ItemDeVenda> sobremesas = new ArrayList<>();
    List<ItemDeVenda> combos = new ArrayList<>();
    Integer idRestaurante;
    Integer idUsuario;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        idRestaurante = Integer.parseInt(request.getParameter("id"));
        idUsuario = Integer.parseInt(request.getParameter("id2"));
        List<Produto> produtos = ProdutoDAO.getInstance().listAllFromRestaurante(idRestaurante);
        for (Produto produto : produtos) { // Trocar por iterator
            instanciaObjeto(produto);
        }
        request.setAttribute("entradas", pratosDeEntrada);
        request.setAttribute("principais", pratosPrincipais);
        request.setAttribute("bebidas", bebidas);
        request.setAttribute("sobremesas", sobremesas);
        List<ItemDeVenda> combos = ComboDAO.getInstance().searchCombo(idRestaurante);
        for (ItemDeVenda combo : combos) {
            List<Integer> idProdutos = ComboDAO.getInstance().searchComboProduto(combo.getCodigo());
            for (Integer idProduto : idProdutos) {
                Produto produto = ProdutoDAO.getInstance().listProduto(idProduto);
                instanciaCombo(produto, combo);
            }
        }
        request.setAttribute("combos", combos);
        request.setAttribute("idRest", idRestaurante);
        request.setAttribute("idUsuario", idUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-cliente-fazer-pedido.jsp");
        dispatcher.forward(request, response);

    }

    public void instanciaObjeto(Produto produto) {
        if (produto.getTipoItem() == 1) {
            ItemDeVenda entrada = new PratoDeEntrada(produto.getProdutocod(), produto.getNome(), produto.getValor(), produto.getDificuldade(), idRestaurante);
            pratosDeEntrada.add(entrada);
        } else if (produto.getTipoItem() == 2) {
            ItemDeVenda principal = new PratoPrincipal(produto.getProdutocod(), produto.getNome(), produto.getValor(), produto.getDificuldade(), idRestaurante);
            pratosPrincipais.add(principal);
        } else if (produto.getTipoItem() == 3) {
            ItemDeVenda bebida = new Bebida(produto.getProdutocod(), produto.getNome(), produto.getValor(), produto.getDificuldade(), idRestaurante);
            bebidas.add(bebida);
        } else {
            ItemDeVenda sobremesa = new Sobremesa(produto.getProdutocod(), produto.getNome(), produto.getValor(), produto.getDificuldade(), idRestaurante);
            sobremesas.add(sobremesa);
        }
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

