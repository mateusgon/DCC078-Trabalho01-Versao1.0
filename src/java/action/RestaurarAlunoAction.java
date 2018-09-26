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
        
       /*AlunoMemento head   = head.getAtual();
        while (atual.getAlunoAnt() != null) {
             alunos.add(atual);
             atual = atual.getAlunoProximo();
        }*/
            
         
        AlunoMemento aux   = al.getHead();
        
        
        while (aux != null) {
             alunos.add(aux);
             aux= aux.getAlunoProx();
        }
            
            
        
        request.setAttribute("alunos",  alunos);
        request.setAttribute("id",  id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar-historico.jsp");
        dispatcher.forward(request, response);
        
    }
    
    }
    

