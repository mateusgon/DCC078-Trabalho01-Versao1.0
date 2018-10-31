package action;

import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;

public class EditarRestaurantePostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String nomeFantasia = request.getParameter("nomeFantasia");
        String sigla = request.getParameter("sigla");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        Integer idRestaurante = Integer.parseInt(request.getParameter("idRestaurante"));
        Restaurante restaurante = new Restaurante(nome, nomeFantasia, telefone, endereco, sigla);
        restaurante.setRestaurantecod(idRestaurante);
        RestauranteDAO.getInstance().update(restaurante);
        List<Restaurante> restaurantes = RestauranteDAO.getInstance().listAll();
        request.setAttribute("restaurantes", restaurantes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-listar-restaurantes.jsp");
        dispatcher.forward(request, response);
    }

}
