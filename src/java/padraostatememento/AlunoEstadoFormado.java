package padraostatememento;

import model.Aluno;

public class AlunoEstadoFormado implements AlunoEstado{

    String nome = "Formado";
    
    public AlunoEstadoFormado() {
    }

    @Override
    public void matricular(Aluno a) {
        
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
