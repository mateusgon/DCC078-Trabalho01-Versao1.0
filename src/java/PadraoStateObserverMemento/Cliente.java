package PadraoStateObserverMemento;

import PadraoTemplateMethod.MensagemAberto;
import PadraoTemplateMethod.MensagemEnviado;
import PadraoTemplateMethod.MensagemPreparado;
import PadraoTemplateMethod.MensagemPronto;
import PadraoTemplateMethod.MensagemRecebido;
import PadraoTemplateMethod.MensagemTemplate;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    
    private Integer pessoaCod, tipoPessoa;
    private String nome, endereco, email, senha, telefone;
    private Pedido pedido2;
    private Observable pedido;
    private MensagemTemplate mensagem;
    
    public Cliente(Integer pessoaCod, Integer tipoPessoa, String nome, String endereco, String email, String senha, String telefone, Observable pedido, Pedido pedido2) {
        this.pessoaCod = pessoaCod;
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.pedido = pedido;
        pedido.addObserver(this);
        this.pedido2 = pedido2;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (pedido2.getEstado().getNomeEstado() == "Aberto")
        {
            mensagem = new MensagemAberto();
        }
        else if (pedido2.getEstado().getNomeEstado() == "Preparar")
        {
            mensagem = new MensagemPreparado();
        }
        else if (pedido2.getEstado().getNomeEstado() == "Pronto")
        {
            mensagem = new MensagemPronto();
        }
        else if (pedido2.getEstado().getNomeEstado() == "Enviar")
        {
            mensagem = new MensagemEnviado();
        }
        else 
        {
            mensagem = new MensagemRecebido();
        }
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

    public Observable getPedido() {
        return pedido;
    }

    public void setPedido(Observable pedido) {
        this.pedido = pedido;
    }

    
}
