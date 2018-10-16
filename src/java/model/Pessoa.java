
package model;


public class Pessoa {
    
    private int pessoaCod,restauranteSigla;
    private String nome,endereco,email,telefone;
    

    public Pessoa(String nome, String endereco, Integer restauranteSigla, String email, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.restauranteSigla = restauranteSigla;
        this.email = email;
        this.telefone = telefone;
    }

    public int getPessoaCod() {
        return pessoaCod;
    }

    public void setPessoaCod(int pessoaCod) {
        this.pessoaCod = pessoaCod;
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

    public Integer getRestauranteCod() {
        return restauranteSigla;
    }

    public void setRestauranteCod(Integer restauranteSigla) {
        this.restauranteSigla = restauranteSigla;
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
    
    
    
}
