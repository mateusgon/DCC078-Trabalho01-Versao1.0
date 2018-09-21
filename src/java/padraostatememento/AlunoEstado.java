package padraostatememento;

import model.Aluno;

public interface AlunoEstado {
    public Boolean matricular(Aluno a);
    public Boolean formar(Aluno a);
    public Boolean trancar(Aluno a);
    public String getNomeEstado();
}
