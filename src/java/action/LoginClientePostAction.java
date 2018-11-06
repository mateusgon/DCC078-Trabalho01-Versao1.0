package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pessoa;
import persistence.PessoaDAO;

public class LoginClientePostAction implements controller.Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("password");
            boolean flagAutenticado = false;
            if (email.equals("") || senha.equals("")) {
                response.sendRedirect("erro.jsp"); //tratar erro1
            } else {
                Pessoa pessoa = new Pessoa();
                pessoa = pessoa.setEmail(email).setSenha(senha);
                PessoaDAO.getInstance().Autentica(pessoa);
                request.setAttribute("pessoa", pessoa);
//                HttpSession session = request.getSession();
//                session.setAttribute("authUser", pessoa.getNome());
//                session.setAttribute("idUser", pessoa.getPessoaCod());
                RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-cliente.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
            RequestDispatcher dispacher = request.getRequestDispatcher("form-login-cliente.jsp");
            dispacher.forward(request, response);
        }
    }
}
