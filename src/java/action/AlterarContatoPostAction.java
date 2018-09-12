/*package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.AlunoDAO;

public class AlterarContatoPostAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
             String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");       
        if(nome.equals("") || email.equals("")) 
        {
            response.sendRedirect("AlterarContato.jsp");
        } 
        else 
        {
            Contato contato = new Contato(null, nome, email, null);
            try
            {
                AlunoDAO.getInstance().change(contato);
                response.sendRedirect("Sucesso.jsp");
            }
            catch (SQLException ex)
            {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }
        }
   
    }
    
}
*/