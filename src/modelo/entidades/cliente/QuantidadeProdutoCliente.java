package modelo.entidades.cliente;

import modelo.entidades.funcionario.Estoque;
import modelo.entidades.funcionario.Produto;
import modelo.entidades.funcionario.QuantidadeProduto;

public class QuantidadeProdutoCliente extends QuantidadeProduto {
    public QuantidadeProdutoCliente(Produto produto, Integer quantidade) {
        super(produto, quantidade);
    }

    @Override
    public Produto getProduto() {
        return super.getProduto();
    }

    @Override
    public Integer getQuantidade() {
        return super.getQuantidade();
    }

    @Override
    public void setQuantidade(Integer quantidade) {
        super.setQuantidade(quantidade);
    }

    @Override
    public String toString() {
        return "Nome:" + this.getProduto().getNome() + " | Quantidade: " + this.getQuantidade();
    }
}
