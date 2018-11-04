package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;

public class VerInformacoesRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRest = Integer.parseInt(request.getParameter("id"));
        Restaurante restaurante = RestauranteDAO.getInstance().listarRestaurante(idRest);
        request.setAttribute("restaurante", restaurante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-cliente-ver-informacoes-restaurante.jsp");
        dispatcher.forward(request, response);
    }

}
