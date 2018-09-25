package action;

import controller.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import padraostatememento.AlunoMemento;
import persistence.AlunoLocator;

public class RestaurarAlunoAction implements Action{

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
        List<AlunoMemento> alunos = new ArrayList<>();
        
        /*PRECISA REVER ISSO*/
        AlunoMemento atual = al.getAtual();
        while ( atual.getAlunoAnt()!= null) {
             alunos.add(atual);
             atual = atual.getAlunoAnt();
        }
            
        
        request.setAttribute("alunos",  alunos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar-historico.jsp");
        dispatcher.forward(request, response);
        
    }
    
    }
    

