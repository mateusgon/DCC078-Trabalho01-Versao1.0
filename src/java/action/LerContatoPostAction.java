/*package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.AlunoDAO;

public class LerContatoPostAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("textNome");
        if(nome.equals("")) 
        {
            response.sendRedirect("LerContato.jsp");
        } 
        else 
        {
            Contato contato = new Contato(null, nome, null, null);
            try
            {
                AlunoDAO.getInstance().load(contato);
                request.setAttribute("contato", contato);
                RequestDispatcher dispatcher = request.getRequestDispatcher("lerSucesso.jsp");
                dispatcher.forward(request, response);
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