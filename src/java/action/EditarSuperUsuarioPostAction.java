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
        Pessoa pessoa = new Pessoa();
        pessoa = pessoa.setPessoaCod(idUsuario).setRestauranteCod(0).setNome(nome).setEndereco(endereco).setEmail(email).setTelefone(telefone).setTipoPessoa(7).setSenha(senha);
        PessoaDAO.getInstance().updateUsuario(pessoa);
        response.sendRedirect("acesso-restrito-superusuario.jsp");
    }

}
