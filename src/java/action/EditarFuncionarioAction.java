package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PessoaDAO;

public class EditarFuncionarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idUsuario = Integer.parseInt(request.getParameter("id"));
        Pessoa pessoa = PessoaDAO.getInstance().buscaUsuario(idUsuario);
        request.setAttribute("pessoa", pessoa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-edit-funcionario.jsp");
        dispatcher.forward(request, response);
    }

}
