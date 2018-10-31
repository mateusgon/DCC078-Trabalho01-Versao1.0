package action;

import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.PessoaDAO;
import persistence.RestauranteDAO;

public class ListarSuperUsuariosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Restaurante> restaurantes = RestauranteDAO.getInstance().listAll();
        for (Restaurante restaurante : restaurantes) {
            PessoaDAO.getInstance().buscaSuperUsuario(restaurante);
        }
        request.setAttribute("restaurantes", restaurantes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-listar-superusuarios.jsp");
        dispatcher.forward(request, response);
    }

}
