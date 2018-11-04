package model;

public class Produto {
    private Integer produtocod;
    private String nome;
    private Double valor;
    private Integer dificuldade;
    private Integer tipoItem;
    private Integer restaurantecod;

    public Produto(String nome, Double valor, Integer dificuldade, Integer tipoItem, Integer restaurantecod) {
        this.nome = nome;
        this.valor = valor;
        this.dificuldade = dificuldade;
        this.tipoItem = tipoItem;
        this.restaurantecod = restaurantecod;
    }

    public Produto(Integer produtocod, String nome, Double valor, Integer dificuldade, Integer tipoItem, Integer restaurantecod) {
        this.produtocod = produtocod;
        this.nome = nome;
        this.valor = valor;
        this.dificuldade = dificuldade;
        this.tipoItem = tipoItem;
        this.restaurantecod = restaurantecod;
    }

    public Produto() {
    }

    public Integer getProdutocod() {
        return produtocod;
    }

    public void setProdutocod(Integer produtocod) {
        this.produtocod = produtocod;
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

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Integer getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(Integer tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Integer getRestaurantecod() {
        return restaurantecod;
    }

    public void setRestaurantecod(Integer restaurantecod) {
        this.restaurantecod = restaurantecod;
    }
    
}
