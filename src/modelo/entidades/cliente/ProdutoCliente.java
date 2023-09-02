package modelo.entidades.cliente;

import modelo.entidades.funcionario.Produto;

public class ProdutoCliente extends Produto {
    private int quantidade;
    public ProdutoCliente(String nome, int quantidade) {
        super(nome);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        return this.getNome() + " | Quantidade: |" + this.getQuantidade() + "|";
    }
}
