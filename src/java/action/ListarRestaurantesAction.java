package action;

import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;

public class ListarRestaurantesAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.parseInt(request.getParameter("id2"));
        if (id == 1) {
            List<Restaurante> restaurantes = RestauranteDAO.getInstance().listAll();
            request.setAttribute("restaurantes", restaurantes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-listar-restaurantes.jsp");
            dispatcher.forward(request, response);
        } else if (id == 2) {
            List<Restaurante> restaurantes = RestauranteDAO.getInstance().listAll();
            request.setAttribute("restaurantes", restaurantes);
            request.setAttribute("idUsuario", Integer.parseInt(request.getParameter("id")));
            RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-cliente-listar-restaurantes.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("erro.jsp");
        }
    }

}
