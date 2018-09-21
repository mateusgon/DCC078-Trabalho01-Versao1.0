package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import padraostatememento.AlunoEstado;
import padraostatememento.AlunoEstadoMatriculado;
import padraostatememento.AlunoMemento;

public class Aluno {

    private Integer codigoAluno;
    private String nome;
    private AlunoEstado estado;
    //private List<AlunoMemento> alunoMemento=new ArrayList<> ();
    private AlunoMemento head = null;
    private AlunoMemento atual = null;

    public AlunoMemento getHead() {
        return head;
    }

    public void setHead(AlunoMemento head) {
        this.head = head;
    }

    public AlunoMemento getAtual() {
        return atual;
    }

    public void setAtual(AlunoMemento atual) {
        this.atual = atual;
    }

    public Aluno() {
        this.estado = new AlunoEstadoMatriculado();
    }

    public Aluno(String nome) {
        this.nome = nome;
        this.estado = new AlunoEstadoMatriculado();
    }

    public void matricular() {
        estado.matricular(this);
    }

    public void formar() {
        estado.formar(this);
    }

    public void trancar() {
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

    public void saveToMemento() {
        AlunoMemento a = new AlunoMemento(estado, codigoAluno);
        if (head == null) {
            head = a;
        } else {
            while (head.getAlunoProx() != null) {
                head = head.getAlunoProx();
            }
            head.setAlunoProx(a);
            a.setAlunoAnt(head);
        }
        atual = a;
    }

    public void restoreFromMemento(AlunoMemento memento) {
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
