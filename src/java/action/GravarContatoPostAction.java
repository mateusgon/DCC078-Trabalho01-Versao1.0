/*package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.AlunoDAO;

public class GravarContatoPostAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        Integer idEmpresa = Integer.parseInt(request.getParameter("valor"));
        if(nome.equals("") || email.equals("")) 
        {
            response.sendRedirect("GravarContato.jsp");
        } 
        else 
        {
            Contato contato = new Contato(null, nome, email, idEmpresa);
            try
            {
                AlunoDAO.getInstance().save(contato);
                response.sendRedirect("Sucesso.jsp");
            }
            catch (SQLException ex)
            {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }
        }
    }
    
}*/
