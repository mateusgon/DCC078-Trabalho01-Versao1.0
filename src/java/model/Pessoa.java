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

    public Pessoa setPessoaCod(int pessoaCod) {
        this.pessoaCod = pessoaCod;
        return this;
    }

    public int getRestauranteCod() {
        return restauranteCod;
    }

    public Pessoa setRestauranteCod(int restauranteCod) {
        this.restauranteCod = restauranteCod;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Pessoa setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Pessoa setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Pessoa setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public Pessoa setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Pessoa setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
