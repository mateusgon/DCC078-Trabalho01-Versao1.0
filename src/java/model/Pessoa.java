package model;

public class Pessoa {

    private Integer pessoaCod, restauranteCod, tipoPessoa;
    private String nome, endereco, email, telefone, senha;

    public Pessoa() {
    }

    public Pessoa(String nome, String endereco, String email, String telefone, Integer tipoPessoa, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
        this.senha = senha;
    }

    public Pessoa(int pessoaCod, int restauranteCod, String nome, String endereco, String email, String telefone, Integer tipoPessoa, String senha) {
        this.pessoaCod = pessoaCod;
        this.restauranteCod = restauranteCod;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
        this.senha = senha;
    }

    public Pessoa(int restauranteCod, String nome, String endereco, String email, String telefone, Integer tipoPessoa, String senha) {
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

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
