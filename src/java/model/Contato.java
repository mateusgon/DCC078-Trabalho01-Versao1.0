package model;

public class Contato {
    private Integer codigoContato;
    private String nome;
    private String email;
    private Integer codigoEmpresa;

    public Contato() {
    }

    public Contato(Integer codigoContato, String nome, String email, Integer codigoEmpresa) {
        this.codigoContato = codigoContato;
        this.nome = nome;
        this.email = email;
        this.codigoEmpresa = codigoEmpresa;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Integer getCodigoContato() {
        return codigoContato;
    }

    public void setCodigoContato(Integer codigoContato) {
        this.codigoContato = codigoContato;
    }
    
}
