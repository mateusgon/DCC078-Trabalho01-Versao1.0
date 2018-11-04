package PadraoStateObserverMemento;

import PadraoTemplateMethod.MensagemAberto;
import PadraoTemplateMethod.MensagemEnviado;
import PadraoTemplateMethod.MensagemPreparado;
import PadraoTemplateMethod.MensagemPronto;
import PadraoTemplateMethod.MensagemRecebido;
import PadraoTemplateMethod.MensagemTemplate;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mensagem;
import persistence.MensagemDAO;

public class Cliente implements Observer {

    private Integer pessoaCod, tipoPessoa;
    private String nome, endereco, email, senha, telefone;
    private Observable pedido;
    private MensagemTemplate mensagem;

    public Cliente(Integer pessoaCod, Integer tipoPessoa, String nome, String endereco, String email, String senha, String telefone, Observable pedido) {
        this.pessoaCod = pessoaCod;
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.pedido = pedido;
        pedido.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Pedido p = (Pedido) getPedido();
        if (p.getEstado().getNomeEstado().equals("Aberto")) {
            mensagem = new MensagemAberto();
        } else if (p.getEstado().getNomeEstado().equals("Preparar")) {
            mensagem = new MensagemPreparado();
        } else if (p.getEstado().getNomeEstado().equals("Pronto")) {
            mensagem = new MensagemPronto();
        } else if (p.getEstado().getNomeEstado().equals("Enviar")) {
            mensagem = new MensagemEnviado();
        } else {
            mensagem = new MensagemRecebido();
        }
        Mensagem mensagemEnviada = new Mensagem();
        mensagemEnviada.setMensagem(mensagem.getEstadoPedido(p));
        mensagemEnviada.setIdReceptor(pessoaCod);
        try {
            MensagemDAO.getInstance().saveMensagem(mensagemEnviada);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Observable getPedido() {
        return this.pedido;
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

    public void setPedido(Observable pedido) {
        this.pedido = pedido;
    }

    public void notificarAbertura() throws ClassNotFoundException, SQLException {
        Pedido pedido2 = (Pedido) pedido;
        MensagemTemplate mensagem = new MensagemAberto();
        Mensagem mensagemEnviada = new Mensagem();
        mensagemEnviada.setMensagem(mensagem.getEstadoPedido(pedido2));
        mensagemEnviada.setIdReceptor(pessoaCod);
        MensagemDAO.getInstance().saveMensagem(mensagemEnviada);
    }

}
