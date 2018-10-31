package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.RestauranteDAO;

public class CadastrarSuperUsuarioRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("restaurantes", RestauranteDAO.getInstance().listAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-adicionar.jsp");
        dispatcher.forward(request, response);
    }

}
