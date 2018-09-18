
package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padraomemento.Aluno;
import persistence.AlunoDAO;


public class AdicionarAlunoPostAction implements Action{
    
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("textNome");       
        if(nome.equals("") ) 
        {
            response.sendRedirect("gravar-aluno.jsp");
        } 
        else 
        {
            Aluno aluno = new Aluno(nome);
            try
            {
                AlunoDAO.getInstance().save(aluno);
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
