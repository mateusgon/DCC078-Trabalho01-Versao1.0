
package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import padraostatememento.AlunoMemento;
import persistence.AlunoDAO;
import persistence.AlunoLocator;
import persistence.AlunoMementoDAO;


public class AdicionarAlunoPostAction implements Action{
    
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("textNome");      
        Integer cod = Integer.parseInt(request.getParameter("codAluno")); 
        if(nome.equals("") ) 
        {
            response.sendRedirect("adicionar-aluno.jsp");
        } 
        else
        {
            Aluno aluno = new Aluno(nome,cod);
      //      try
            {
         //      AlunoDAO.getInstance().save(aluno);         
                aluno.saveToMemento();
                AlunoLocator.getInstance().add(aluno);
              //  aluno.saveToMemento();
                
                
                //AlunoMementoDAO.getInstance().save(alunoMemento);
              response.sendRedirect("sucesso.jsp");
            }
        //    catch (SQLException ex)
            {
          //      response.sendRedirect("erro.jsp");
            }
        }
    }
    
}
