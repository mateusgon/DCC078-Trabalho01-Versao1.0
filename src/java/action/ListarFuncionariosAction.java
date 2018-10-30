package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PessoaDAO;
import persistence.RestauranteDAO;

public class ListarFuncionariosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("listFuncionarios", PessoaDAO.getInstance().buscaFuncionarioRestaurante(idRestaurante));
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar-funcionarios.jsp");
        dispatcher.forward(request, response);
    }

}
