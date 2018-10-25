
package model;

import java.util.Observable;


public class Pessoa {
    
    private int pessoaCod,restauranteCod;
    private String nome,endereco,email,telefone,tipoPessoa,senha;
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

    
    public Pessoa(int pessoaCod, int restauranteCod, String nome, String endereco, String email, String telefone, String tipoPessoa) {
        this.pessoaCod = pessoaCod;
        this.restauranteCod = restauranteCod;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
    }
    
    
    

    public Pessoa(String nome, String endereco, Integer restauranteCod, String email, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.restauranteCod = restauranteCod;
        this.email = email;
        this.telefone = telefone;
    }

    public Pessoa(String nome) {
        this.nome=nome;
        
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
}
