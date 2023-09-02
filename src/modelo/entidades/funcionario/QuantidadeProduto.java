package modelo.entidades.funcionario;

public class QuantidadeProduto {
    private Produto produto;
    private String setor;
    private Double preco;
    private Integer quantidade;

    public QuantidadeProduto(Produto produto, String setor, Double preco) {
        this.produto = produto;
        this.setor = setor;
        this.preco = preco;
        this.quantidade = 0;
    }
    public QuantidadeProduto(Produto produto, String setor, Double preco, Integer quantidade) {
        this.produto = produto;
        this.setor = setor;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getSetor() {
        return setor;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return this.getProduto() + " | Preço: R$"+ String.format("%.2f", this.getPreco()) + " | Quantidade em estoque: |" + this.getQuantidade() + "| ";
    }
}
