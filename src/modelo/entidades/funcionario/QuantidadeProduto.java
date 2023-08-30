package modelo.entidades.funcionario;

public class QuantidadeProduto {
    private Produto produto;
    private Integer quantidade;

    public QuantidadeProduto(Produto produto) {
        this.produto = produto;
        this.quantidade = 0;
    }
    public QuantidadeProduto(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return this.getProduto() + "| Quantidade em estoque: |" + this.getQuantidade() + "| ";
    }
}
