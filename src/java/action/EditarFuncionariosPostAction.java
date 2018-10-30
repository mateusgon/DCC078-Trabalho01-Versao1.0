package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PessoaDAO;

public class EditarFuncionariosPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Integer tipoPessoa = Integer.parseInt(request.getParameter("cargos"));
        Integer idRestaurante = Integer.parseInt(request.getParameter("idRestaurante"));
        Pessoa pessoa = new Pessoa(idUsuario, 0, nome, endereco, email, telefone, tipoPessoa, senha);
        PessoaDAO.getInstance().updateUsuario(pessoa);
        request.setAttribute("idRest", idRestaurante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("restaurante-acesso-restrito.jsp");
        dispatcher.forward(request, response);
    }

}
