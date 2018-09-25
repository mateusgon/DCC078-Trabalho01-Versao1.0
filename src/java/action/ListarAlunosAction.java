package action;

import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.AlunoDAO;
import persistence.AlunoLocator;

public class ListarAlunosAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List <Aluno> alunos =  AlunoLocator.getInstance();
        request.setAttribute("alunos", alunos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar-alunos.jsp");
        dispatcher.forward(request, response);
    }
    
}
