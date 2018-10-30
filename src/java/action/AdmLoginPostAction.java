package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PessoaDAO;

public class AdmLoginPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String senha = request.getParameter("password");
        boolean flagAutenticado = false;
        if (nome.equals("") || senha.equals("")) {
            response.sendRedirect("erro.jsp");
        } else {
            Pessoa pessoa = new Pessoa(nome, senha);
            PessoaDAO.getInstance().Autentica(pessoa);
            if (7 == pessoa.getTipoPessoa()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("restaurante-acesso-restrito.jsp");
                dispatcher.forward(request, response);
            }
            else if (8 == pessoa.getTipoPessoa())
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                response.sendRedirect("erro.jsp");
            }
        }
    }
}
