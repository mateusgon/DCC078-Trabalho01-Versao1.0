package model;

import java.util.Observable;
import java.util.Observer;

public class Pessoa implements Observer {

    private Integer pessoaCod, restauranteCod;
    private String nome, endereco, email, telefone, tipoPessoa, senha;
    private Observable pedido;

    public Pessoa(Observable pedido) {
        this.pedido = pedido;
        pedido.addObserver(this);
    }

    public Observable getPedido() {
        return pedido;
    }

    public void setPedido(Observable pedido) {
        this.pedido = pedido;
    }

    public Pessoa(int pessoaCod, int restauranteCod, String nome, String endereco, String email, String telefone, String tipoPessoa, String senha) {
        this.pessoaCod = pessoaCod;
        this.restauranteCod = restauranteCod;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
        this.senha = senha;
    }

    public Pessoa(String nome, String endereco, Integer restauranteCod, String email, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.restauranteCod = restauranteCod;
        this.email = email;
        this.telefone = telefone;
    }

    public Pessoa(String email, String senha) {
        this.email = email;
        this.senha = senha;

    }

    public int getPessoaCod() {
        return pessoaCod;
    }

    public void setPessoaCod(int pessoaCod) {
        this.pessoaCod = pessoaCod;
    }

    public int getRestauranteCod() {
        return restauranteCod;
    }

    public void setRestauranteCod(int restauranteCod) {
        this.restauranteCod = restauranteCod;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /*
    public void update(Observable pedidoSubject, Object arg) {
        if (pedidoSubject instanceof Pedido)
        {
          //  Pedido pedido = (Pedido) pedidoSubject;
            //edicacaoNovaPedido = pedido.getEdicao();
            System.out.println("Atenção " + getNome() + ", já chegou mais uma edição da Pedido. Este é a sua edição números: " + edicacaoNovaPedido);
        }
}
     */
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
