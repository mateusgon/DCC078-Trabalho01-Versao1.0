package PadraoComposite;

import java.util.List;

public abstract class ItemDeVenda {

    protected Integer codigo;
    protected String nome;
    protected Double valor;
    protected Integer dificuldade;
    private Integer restaurantecod;

    public ItemDeVenda(Integer codigo, String nome, Double valor, Integer dificuldade, Integer restaurantecod) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.dificuldade = dificuldade;
        this.restaurantecod = restaurantecod;
    }

    public void adicionar(ItemDeVenda item) throws Exception {
        throw new Exception("Não é um combo para adicionar");
    }
    
    public List<ItemDeVenda> getItens () throws Exception
    {
        throw new Exception("Não é um combo para listar");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Integer getRestaurantecod() {
        return restaurantecod;
    }

    public void setRestaurantecod(Integer restaurantecod) {
        this.restaurantecod = restaurantecod;
    }

    
}
