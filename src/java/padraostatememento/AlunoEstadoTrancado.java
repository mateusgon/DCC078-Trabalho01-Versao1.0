package padraostatememento;

import model.Aluno;

public class AlunoEstadoTrancado implements AlunoEstado{

    String nome = "Trancado";
    
    public AlunoEstadoTrancado() {
    }
    
    @Override
    public void matricular(Aluno a) {
        a.setEstado(new AlunoEstadoMatriculado());
    }

    @Override
    public void formar(Aluno a) {
        
    }

    @Override
    public void trancar(Aluno a) {
        
    }
    
    @Override
    public String getNomeEstado() {
        return nome;
    }

    public String getNome() {
        return nome;
    }
    
}