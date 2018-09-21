package padraostatememento;

import java.util.Date;

public class AlunoMemento {
    private Date data;
    private Integer codigoAluno;
    private AlunoEstado estado;
    private AlunoMemento alunoAnt=null;
    private AlunoMemento alunoProx=null;

    public AlunoMemento getAlunoAnt() {
        return alunoAnt;
    }

    public void setAlunoAnt(AlunoMemento alunoAnt) {
        this.alunoAnt = alunoAnt;
    }

    public AlunoMemento getAlunoProx() {
        return alunoProx;
    }

    public void setAlunoProx(AlunoMemento alunoProx) {
        this.alunoProx = alunoProx;
    }


    public AlunoMemento(AlunoEstado estado, Integer codigoAluno) {
        
        this.estado = estado;
        this.codigoAluno = codigoAluno;
    } 

    public AlunoEstado getEstado() {
        return estado;
    }

    public void setEstado(AlunoEstado estado) {
        this.estado = estado;
    }
    
    public AlunoEstado getEstadoSalvo()
    {
        return estado;
    }
    
    public String toString()
    {
        return estado.getNomeEstado();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }
    
    
}
