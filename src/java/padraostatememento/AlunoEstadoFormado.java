package padraostatememento;

import model.Aluno;

public class AlunoEstadoFormado implements AlunoEstado{

    String nome = "Formado";
    
    public AlunoEstadoFormado() {
    }

    @Override
    public Boolean matricular(Aluno a) {
        return false;
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
