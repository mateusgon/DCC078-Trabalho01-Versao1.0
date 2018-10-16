
package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;

public class CadastrarRestaurantePostAction  implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");      
        String nomeFantasia = request.getParameter("nomeFantasia");      
        String sigla = request.getParameter("sigla");      
        String telefone = request.getParameter("telefone");      
        String endereco = request.getParameter("endereco");      
        
        if(nome.equals("") || nomeFantasia.equals("") || sigla.equals("") || telefone.equals("") ||endereco.equals("") ) 
        {
            response.sendRedirect("erro.jsp"); //tratar erro1
        } 
        else
        {
            Restaurante restaurante = new Restaurante(nome,nomeFantasia, telefone, endereco,sigla);
            try
            {
               RestauranteDAO.getInstance().save(restaurante);         
               response.sendRedirect("sucesso.jsp");
            }
            catch (SQLException ex)
            {
             response.sendRedirect("erro.jsp");
            }
        }
    }
    
}
