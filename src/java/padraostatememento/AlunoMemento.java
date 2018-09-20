package padraostatememento;

import java.util.Date;

public class AlunoMemento {
    private Date data;
    private Integer codigoAluno;
    private AlunoEstado estado;

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
