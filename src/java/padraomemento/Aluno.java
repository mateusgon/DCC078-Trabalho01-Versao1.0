package padraomemento;

public class Aluno 
{
    private String nome;
    private AlunoEstado estado;

    public Aluno() {
        this.estado = new AlunoEstadoMatriculado();
    }

    public Aluno(String nome) {
        this.nome = nome;
        this.estado = new AlunoEstadoMatriculado();
    }
    
    public void matricular()
    {
        estado.matricular(this);
    }
    
    public void formar()
    {
        estado.formar(this);
    }
    
    public void trancar()
    {
        estado.trancar(this);
    }
    
    public AlunoEstado getEstado() {
        return estado;
    }

    public void setEstado(AlunoEstado estado) {
        this.estado = estado;
    }

    public String getNomeEstado() {
        return estado.getNomeEstado();
    }
    
    public AlunoMemento saveToMemento()
    {
        return new AlunoMemento(estado);
    }
    
    public void restoreFromMemento(AlunoMemento memento)
    {
        estado = memento.getEstadoSalvo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
}
