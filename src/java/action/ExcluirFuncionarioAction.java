package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PessoaDAO;

public class ExcluirFuncionarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idUsuario = Integer.parseInt(request.getParameter("id"));
        Integer idRestaurante = Integer.parseInt(request.getParameter("id2"));
        PessoaDAO.getInstance().deleteUsuario(idUsuario);
        request.setAttribute("idRest", idRestaurante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("restaurante-acesso-restrito.jsp");
        dispatcher.forward(request, response);
    }

}
