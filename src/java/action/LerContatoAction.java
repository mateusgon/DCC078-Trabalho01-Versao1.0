package action;

import controller.Action;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import padraomemento.Aluno;
import persistence.AlunoDAO;

public class LerContatoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        List<Aluno> alunos = AlunoDAO.getInstance().listAll();
        request.setAttribute("alunos", alunos);
        RequestDispatcher despachante = request.getRequestDispatcher("LerContato.jsp");
        despachante.forward(request, response);
        
    }
    
}
