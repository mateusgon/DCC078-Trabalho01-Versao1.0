
package model;


public class Restaurante {
    
    String nome,nomeFantasia,telefone, endereco, sigla;
    Integer restaurantecod;

    public Integer getRestaurantecod() {
        return restaurantecod;
    }

    public void setRestaurantecod(Integer restaurantecod) {
        this.restaurantecod = restaurantecod;
    }
    

    public Restaurante(String nome, String nomeFantasia, String telefone, String endereco, String sigla) {
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
   
    
}
