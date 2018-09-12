package padraomemento;

public class AlunoEstadoTrancado implements AlunoEstado{

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
        return "Trancado";
    }
}