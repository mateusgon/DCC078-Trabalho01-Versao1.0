package padraomemento;

public class AlunoEstadoMatriculado implements AlunoEstado{

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
        return "Matriculado";
    }
    
}