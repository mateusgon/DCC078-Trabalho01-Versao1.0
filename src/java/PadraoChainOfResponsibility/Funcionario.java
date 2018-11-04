package PadraoChainOfResponsibility;

import PadraoStateObserverMemento.Pedido;
import java.util.ArrayList;
import java.util.List;

public abstract class Funcionario {

    private Integer pessoaCod, restauranteCod;
    private String nome, endereco, email, telefone;
    protected List listaPedidos = new ArrayList();
    private List<Funcionario> funcionarioSuperior = new ArrayList();

    public Funcionario(Integer pessoaCod, Integer restauranteCod, String nome, String endereco, String email, String telefone) {
        this.pessoaCod = pessoaCod;
        this.restauranteCod = restauranteCod;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public List getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<Funcionario> getFuncionarioSuperior() {
        return funcionarioSuperior;
    }

    public void setFuncionarioSuperior(List<Funcionario> funcionarioSuperior) {
        this.funcionarioSuperior = funcionarioSuperior;
    }

    public Integer getPessoaCod() {
        return pessoaCod;
    }

    public void setPessoaCod(Integer pessoaCod) {
        this.pessoaCod = pessoaCod;
    }

    public Integer getRestauranteCod() {
        return restauranteCod;
    }

    public void setRestauranteCod(Integer restauranteCod) {
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

    public Boolean pegarPedido(Pedido pedido) {
        Boolean contem = false;
        for (Object listaPedido : listaPedidos) {
            TipoPedido tp = (TipoPedido) listaPedido;
            if (pedido.getTipoPedido().getTipoPedido().equals(tp.getTipoPedido()))
            {
                contem = true;
            }
        }
        if (contem) {
            return true;
        } else {
            if (funcionarioSuperior.size() > 0) {
                List<Funcionario> funcionarios = getFuncionarioSuperior();
                for (Funcionario funcionario : funcionarios) {
                    funcionario.pegarPedido(pedido);
                }
                return false;
            } else {
                return false;
            }
        }
    }
}
