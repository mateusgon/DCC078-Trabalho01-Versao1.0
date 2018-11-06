package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PessoaDAO;

public class CadastrarClientePostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try
        {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");
            Pessoa pessoa = new Pessoa();
            pessoa = pessoa.setNome(nome).setEndereco(endereco).setEmail(email).setTelefone(telefone).setTipoPessoa(1).setSenha(senha);
            PessoaDAO.getInstance().saveCliente(pessoa);
            request.setAttribute("pessoa", pessoa);
            RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-cliente.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception ex)
        {
        
        }
    }

}
