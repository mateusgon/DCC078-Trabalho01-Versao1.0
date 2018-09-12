package padraomemento;

import java.util.ArrayList;
import java.util.Iterator;

public class PadraoMemento {

    public static void main(String[] args) {
        ArrayList<AlunoMemento> estadosSalvos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setNome("Mateus");
        aluno.setEstado(new AlunoEstadoTrancado());
        estadosSalvos.add(aluno.saveToMemento());
        aluno.setEstado(new AlunoEstadoMatriculado());
        estadosSalvos.add(aluno.saveToMemento());
        aluno.setEstado(new AlunoEstadoFormado());
        estadosSalvos.add(aluno.saveToMemento());
        
        for (Iterator i = estadosSalvos.iterator(); i.hasNext();)
        {
            System.out.println(i.next());
        }
        
        aluno.restoreFromMemento(estadosSalvos.get(0));
        System.out.println(aluno.getNomeEstado());
    }
    
}
