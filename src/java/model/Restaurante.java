
package model;

import java.util.ArrayList;
import java.util.List;


public class Restaurante {
    
    String nome,nomeFantasia,telefone, endereco, sigla;
    Integer restaurantecod;
    private List<Pessoa> superUsuarios;
    private List<Pessoa> funcionarios;

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
        superUsuarios = new ArrayList<>();
        funcionarios = new ArrayList<>();
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

    public List<Pessoa> getSuperUsuarios() {
        return superUsuarios;
    }

    public void setSuperUsuarios(List<Pessoa> superUsuarios) {
        this.superUsuarios = superUsuarios;
    }

    public List<Pessoa> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Pessoa> funcionarios) {
        this.funcionarios = funcionarios;
    }
   
    
}
