package action;

import controller.Action;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import padraostatememento.AlunoMemento;
import persistence.AlunoLocator;

public class RestaurarPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer codAluno = Integer.parseInt(request.getParameter("id"));
        Integer codMemento = Integer.parseInt(request.getParameter("id2"));
        Aluno aluno = null;
        List<Aluno> alunos = AlunoLocator.getInstance();

        for (Aluno aluno1 : alunos) {
            if (aluno1.getCodigoAluno() == codAluno) {
                aluno = aluno1;
                break;
            }
        }

        AlunoMemento aux = aluno.getHead();

        while (aux != null) {
            if (aux.getCodMemento() == codMemento) {
                
                break;
            }
            aux = aux.getAlunoProx();
        }
        aluno.restoreFromMemento(aux);
  
    }
}


    
    

