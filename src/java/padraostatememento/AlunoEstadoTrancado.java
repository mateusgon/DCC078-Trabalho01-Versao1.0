package padraostatememento;

import model.Aluno;

public class AlunoEstadoTrancado implements AlunoEstado{

    String nome = "Trancado";
    
    public AlunoEstadoTrancado() {
    }
    
    @Override
    public Boolean matricular(Aluno a) {
        a.setEstado(new AlunoEstadoMatriculado());
        return true;
    }

    @Override
    public Boolean formar(Aluno a) {
        return false;
    }

    @Override
    public Boolean trancar(Aluno a) {
        return false;
    }
    
    @Override
    public String getNomeEstado() {
        return nome;
    }

    public String getNome() {
        return nome;
    }
    
}