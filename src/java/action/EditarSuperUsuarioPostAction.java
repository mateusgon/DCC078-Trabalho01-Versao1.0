package action;

import controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PessoaDAO;

public class EditarSuperUsuarioPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Pessoa pessoa = new Pessoa(idUsuario, 0, nome, endereco, email, telefone, 7, senha);
        PessoaDAO.getInstance().updateUsuario(pessoa);
        response.sendRedirect("acesso-restrito-superusuarios.jsp");
    }

}
