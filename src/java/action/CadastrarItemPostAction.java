package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;

public class CadastrarItemPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        Double valor = Double.parseDouble(request.getParameter("valor"));
        Integer tipoItem = Integer.parseInt(request.getParameter("tipoItem"));
        Integer dificuldade = Integer.parseInt(request.getParameter("dificuldade"));
        Integer idRest = Integer.parseInt(request.getParameter("idRest"));
        Produto produto = new Produto();
        produto = produto.setNome(nome).setValor(valor).setDificuldade(dificuldade).setTipoItem(tipoItem).setRestaurantecod(idRest).setAtivado(1);
        ProdutoDAO.getInstance().saveProduto(produto);
        request.setAttribute("idRest", idRest);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-restaurante.jsp");
        dispatcher.forward(request, response);
    }

}
