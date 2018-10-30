package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;

public class EditarRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        Restaurante restaurante = RestauranteDAO.getInstance().listarRestaurante(idRestaurante);
        request.setAttribute("restaurante", restaurante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-edit-restaurante.jsp");
        dispatcher.forward(request, response);
    }

}
