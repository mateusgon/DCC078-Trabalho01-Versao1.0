package padraostatememento;

import model.Aluno;

public interface AlunoEstado {
    public void matricular(Aluno a);
    public void formar(Aluno a);
    public void trancar(Aluno a);
    public String getNomeEstado();
}
