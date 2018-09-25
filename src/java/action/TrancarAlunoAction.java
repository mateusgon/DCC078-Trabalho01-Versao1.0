package action;

import controller.Action;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.AlunoDAO;
import persistence.AlunoLocator;

public class TrancarAlunoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      Integer id = Integer.parseInt(request.getParameter("id"));
       List<Aluno> a = AlunoLocator.getInstance();

        Aluno al = null;
        for (Aluno aluno : a) {
            if (Objects.equals(aluno.getCodigoAluno(), id)) {
                al = aluno;
                break;
            }
        }
     //   System.out.println(al.getEstado().getNomeEstado());
     //   System.out.println(al.getNomeEstado());
        Boolean possivel = al.getEstado().trancar(al);
        if (possivel) {
            al.saveToMemento();
            response.sendRedirect("sucesso.jsp");
        }
        else{
              response.sendRedirect("erro.jsp");
        }

    }
    
}
