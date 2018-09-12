/*package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.AlunoDAO;

public class ApagarContatoPostAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
          String nome = request.getParameter("textNome");
        if(nome.equals("")) 
        {
            response.sendRedirect("ApagarContato.jsp");
        } 
        else 
        {
            Contato contato = new Contato(null, nome, null, null);
            try
            {
                AlunoDAO.getInstance().delete(contato);
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