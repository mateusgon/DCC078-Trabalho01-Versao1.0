package padraostatememento;

import model.Aluno;

public class PedidoEstadoIniciado implements AlunoEstado{

    String nome = "Matriculado";
    
    public AlunoEstadoMatriculado() {
    }

    @Override
    public Boolean matricular(Aluno a) {
        return false;
    }

    @Override
    public Boolean formar(Aluno a) {
        a.setEstado(new AlunoEstadoFormado());
        return true;
    }

    @Override
    public Boolean trancar(Aluno a) {
        a.setEstado(new AlunoEstadoTrancado());
        return true;
    }
    
    @Override
    public String getNomeEstado() {
        return nome;
    }

    public String getNome() {
        return nome;
    }
    
}