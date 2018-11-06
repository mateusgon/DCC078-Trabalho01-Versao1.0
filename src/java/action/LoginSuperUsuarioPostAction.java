package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PessoaDAO;

public class LoginSuperUsuarioPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String senha = request.getParameter("password");
        boolean flagAutenticado = false;
        if (nome.equals("") || senha.equals("")) {
            response.sendRedirect("erro.jsp");
        } else {
            Pessoa pessoa = new Pessoa();
            pessoa.setEmail(nome).setSenha(senha);
            PessoaDAO.getInstance().Autentica(pessoa);
            if (7 == pessoa.getTipoPessoa()) {
                request.setAttribute("idRest", pessoa.getRestauranteCod());
                RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-restaurante.jsp");
                dispatcher.forward(request, response);
            }
            else if (8 == pessoa.getTipoPessoa())
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                response.sendRedirect("erro.jsp");
            }
        }
    }
}
