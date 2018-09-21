package persistence;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class AlunoLocator {
    
    private static List<Aluno> alunos = new ArrayList<>();
    private static AlunoLocator instance = new AlunoLocator();

    public static List<Aluno> getInstance() {
        return alunos;
    }

    private AlunoLocator() {
    }

}
