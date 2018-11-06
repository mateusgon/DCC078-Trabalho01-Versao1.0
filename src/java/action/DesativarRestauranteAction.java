package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PessoaDAO;
import persistence.RestauranteDAO;

public class DesativarRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer restauranteCod = Integer.parseInt(request.getParameter("id"));
        try {
            PessoaDAO.getInstance().deleteSuperUsuario(restauranteCod);
            RestauranteDAO.getInstance().delete(restauranteCod);
            response.sendRedirect("acesso-restrito-superusuario.jsp");
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
        }
    }
}
