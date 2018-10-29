package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.Restaurante;
import persistence.PessoaDAO;
import persistence.RestauranteDAO;

public class AdmLoginPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String senha = request.getParameter("nome");
        boolean flagAutenticado = false;
        if (nome.equals("") || senha.equals("")) {
            response.sendRedirect("erro.jsp"); //tratar erro1
        } else {
            //#ajustar para capturar error
            Pessoa pessoa = new Pessoa(nome, senha);
            pessoa = PessoaDAO.getInstance().Autentica(pessoa);
          
            request.setAttribute("pessoa", pessoa);
            RequestDispatcher dispatcher = request.getRequestDispatcher("restaurante-acesso-restrito.jsp");
            dispatcher.forward(request, response);
            
            }
        }
    }


