
package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.Restaurante;
import persistence.PessoaDAO;
import persistence.RestauranteDAO;


public class CadastrarSuperUsuarioPostAction implements Action{

    @Override
     public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");      
        String endereco = request.getParameter("endereco");      
        Integer restauranteCod = Integer.parseInt(request.getParameter("restauranteCod"));      
        String telefone = request.getParameter("telefone");      
        String email = request.getParameter("email");      
        
        if(nome.equals("") || email.equals("") || restauranteCod.equals("") || telefone.equals("") ||email.equals("") ) 
        {
            response.sendRedirect("erro.jsp"); //tratar erro1
        } 
        else
        {
            Pessoa pessoa = new Pessoa(nome,endereco, restauranteCod, email,telefone);
            try
            {
               PessoaDAO.getInstance().save(pessoa);         
               response.sendRedirect("sucesso.jsp");
            }
            catch (SQLException ex)
            {
             response.sendRedirect("erro.jsp");
            }
        }
    }
    
    
}
