package action;

import controller.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.AlunoDAO;
import persistence.AlunoLocator;

public class FormarAlunoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Aluno> a = AlunoLocator.getInstance();

        Aluno al = null;
        for (Aluno aluno : a) {
            if (aluno.getCodigoAluno() == id) {
                al = aluno;
                break;
            }
        }

        //    Aluno aluno = AlunoDAO.getInstance().list(id);
        Boolean possivel = al.getEstado().formar(al);
        if (possivel) {
            al.saveToMemento();
            response.sendRedirect("sucesso.jsp");
        }
        else{
            response.sendRedirect("erro.jsp");
        }

     
    }

}
