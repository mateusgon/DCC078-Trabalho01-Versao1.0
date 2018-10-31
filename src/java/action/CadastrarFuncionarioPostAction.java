package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PessoaDAO;

public class CadastrarFuncionarioPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        Integer restauranteCod = Integer.parseInt(request.getParameter("idRestaurante"));
        Integer tipoPessoa = Integer.parseInt(request.getParameter("cargos"));
        Pessoa pessoa = new Pessoa(restauranteCod, nome, endereco, email, telefone, tipoPessoa, senha);
        PessoaDAO.getInstance().saveSuperUsuarioeFuncionario(pessoa);
        request.setAttribute("idRest", pessoa.getRestauranteCod());
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-administrar-funcionarios.jsp");
        dispatcher.forward(request, response);
    }

}
