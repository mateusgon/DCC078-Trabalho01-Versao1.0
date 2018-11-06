package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProdutoDAO;

public class DesativarItemAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id2"));
        Integer idProduto = Integer.parseInt(request.getParameter("id"));
       // ProdutoDAO.getInstance().deleteProduto(idProduto);
        request.setAttribute("idRest", idRestaurante);
        request.setAttribute("produtos", ProdutoDAO.getInstance().listAllFromRestaurante(idRestaurante));
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-listar-produtos.jsp");
        dispatcher.forward(request, response);
    }

}
