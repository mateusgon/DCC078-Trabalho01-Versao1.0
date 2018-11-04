package model;

public class Mensagem {
    
    private Integer idMensagem;
    private Integer idReceptor;
    private String mensagem;

    public Mensagem(Integer idMensagem, Integer idReceptor, String mensagem) {
        this.idMensagem = idMensagem;
        this.idReceptor = idReceptor;
        this.mensagem = mensagem;
    }
    
    public Mensagem() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
    }

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }
    
}
