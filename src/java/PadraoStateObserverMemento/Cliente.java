package PadraoStateObserverMemento;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    
    private Integer pessoaCod, tipoPessoa;
    private String nome, endereco, email, senha, telefone;
    private List<Observable> pedido;
    
    public Cliente(Integer pessoaCod, Integer tipoPessoa, String nome, String endereco, String email, String senha, String telefone) {
        this.pessoaCod = pessoaCod;
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        // mensagem de atualização
    }

    public Integer getPessoaCod() {
        return pessoaCod;
    }

    public void setPessoaCod(Integer pessoaCod) {
        this.pessoaCod = pessoaCod;
    }

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Observable> getPedido() {
        return pedido;
    }

    public void setPedido(List<Observable> pedido) {
        this.pedido = pedido;
    }
   
}
