package action;

import com.sun.xml.wss.saml.assertion.saml11.jaxb10.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PessoaDAO;


public class ClienteLoginPostAction implements controller.Action {
   
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String senha = request.getParameter("nome");
        boolean flagAutenticado = false;
        if (nome.equals("") || senha.equals("")) {
            response.sendRedirect("erro.jsp"); //tratar erro1
        } else {
            //#ajustar para capturar error
            Pessoa pessoa = new Pessoa(nome);
            pessoa = PessoaDAO.getInstance().Autentica(pessoa);
          
            request.setAttribute("pessoa", pessoa);
            RequestDispatcher dispatcher = request.getRequestDispatcher("pedido-acesso-restrito.jsp");
            dispatcher.forward(request, response);
            
            }
        }
}
