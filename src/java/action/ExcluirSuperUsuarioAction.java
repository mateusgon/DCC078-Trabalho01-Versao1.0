package action;

import controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PessoaDAO;

public class ExcluirSuperUsuarioAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idUsuario = Integer.parseInt(request.getParameter("id"));
        PessoaDAO.getInstance().deleteUsuario(idUsuario);
        response.sendRedirect("acesso-restrito-superusuarios.jsp");
    }
    
}
