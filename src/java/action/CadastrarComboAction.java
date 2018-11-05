package action;

import PadraoComposite.Bebida;
import PadraoComposite.ItemDeVenda;
import PadraoComposite.PratoDeEntrada;
import PadraoComposite.PratoPrincipal;
import PadraoComposite.Sobremesa;
import controller.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;

public class CadastrarComboAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        List<Produto> produtos = ProdutoDAO.getInstance().listAllFromRestaurante(idRestaurante);
        List<ItemDeVenda> pratosDeEntrada = new ArrayList<>();
        List<ItemDeVenda> pratosPrincipais = new ArrayList<>();
        List<ItemDeVenda> bebidas = new ArrayList<>();
        List<ItemDeVenda> sobremesas = new ArrayList<>();
        for (Iterator i = produtos.iterator(); i.hasNext();) {
            Produto produto = (Produto) i.next();
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
        request.setAttribute("entradas", pratosDeEntrada);
        request.setAttribute("principais", pratosPrincipais);
        request.setAttribute("bebidas", bebidas);
        request.setAttribute("sobremesas", sobremesas);
        request.setAttribute("idRest", idRestaurante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-cadastro-combo.jsp");
        dispatcher.forward(request, response);
    }

}
