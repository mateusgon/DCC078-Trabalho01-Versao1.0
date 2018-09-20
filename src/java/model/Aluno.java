package model;

import padraostatememento.AlunoEstado;
import padraostatememento.AlunoEstadoMatriculado;
import padraostatememento.AlunoMemento;

public class Aluno 
{
    private Integer codigoAluno;
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
        return new AlunoMemento(estado, codigoAluno);
    }
    
    public void restoreFromMemento(AlunoMemento memento)
    {
        estado = memento.getEstado();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }
        
}