package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdministrarFuncionarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("entrei");
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idRest", idRestaurante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-administrar-funcionarios.jsp");
        dispatcher.forward(request, response);
    }

}
