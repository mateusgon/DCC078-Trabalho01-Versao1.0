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
            if (produto.getAtivado() == 1) {
                switch (produto.getTipoItem()) {
                    case 1:
                        ItemDeVenda entrada = new PratoDeEntrada();
                        entrada = entrada.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                        pratosDeEntrada.add(entrada);
                        break;
                    case 2:
                        ItemDeVenda principal = new PratoPrincipal();
                        principal = principal.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                        pratosPrincipais.add(principal);
                        break;
                    case 3:
                        ItemDeVenda bebida = new Bebida();
                        bebida = bebida.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                        bebidas.add(bebida);
                        break;
                    case 4:
                        ItemDeVenda sobremesa = new Sobremesa();
                        sobremesa = sobremesa.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                        sobremesas.add(sobremesa);
                        break;
                    default:
                        break;
                }
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
