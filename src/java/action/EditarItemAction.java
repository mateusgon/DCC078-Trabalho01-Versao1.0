package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;

public class EditarItemAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idProduto = Integer.parseInt(request.getParameter("id"));
        Integer idRestaurante = Integer.parseInt(request.getParameter("id2"));
        Produto produto = ProdutoDAO.getInstance().listProduto(idProduto);
        request.setAttribute("idRest", idRestaurante);
        request.setAttribute("produto", produto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-edit-produto.jsp");
        dispatcher.forward(request, response);
    }

}
