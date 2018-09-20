package padraostatememento;

import model.Aluno;

public class AlunoEstadoMatriculado implements AlunoEstado{

    String nome = "Matriculado";
    
    public AlunoEstadoMatriculado() {
    }

    @Override
    public void matricular(Aluno a) {
        
    }

    @Override
    public void formar(Aluno a) {
        a.setEstado(new AlunoEstadoFormado());
    }

    @Override
    public void trancar(Aluno a) {
        a.setEstado(new AlunoEstadoTrancado());
    }
    
    @Override
    public String getNomeEstado() {
        return nome;
    }

    public String getNome() {
        return nome;
    }
    
}