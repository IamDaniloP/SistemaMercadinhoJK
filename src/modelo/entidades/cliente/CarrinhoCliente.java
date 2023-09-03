package modelo.entidades.cliente;

import modelo.entidades.funcionario.QuantidadeProduto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCliente {
    private List<ProdutoCliente> listaProdutosEscolhidos;

    public CarrinhoCliente() {
        listaProdutosEscolhidos = new ArrayList<>();
    }

    public List<ProdutoCliente> getListaProdutosEscolhidos() {
        return listaProdutosEscolhidos;
    }

    public boolean inserirCarrinho(List<QuantidadeProduto> listaEstoque,ProdutoCliente produtoCliente) {
        for (QuantidadeProduto produtoEstoque : listaEstoque) {
            if (produtoEstoque.getProduto().getNome().equals(produtoCliente.getNome())) {
                if (produtoEstoque.getQuantidade() > produtoCliente.getQuantidade()) {
                    listaProdutosEscolhidos.add(produtoCliente);
                    System.out.println();
                    System.out.println("|--PRODUTO INSERIDO NO CARRINHO--|");
                    return true;
                } else {
                    produtoCliente.setQuantidade(produtoEstoque.getQuantidade());
                    listaProdutosEscolhidos.add(produtoCliente);
                    return true;
                }
            }
        }
        System.out.println();
        System.out.println("|--PRODUTO NÃO CADASTRADO--|");
        return false;
    }

    public int removerCarrinho(String nome) {
        int i = 0;
        for (ProdutoCliente produtoCliente : listaProdutosEscolhidos) {
            if (produtoCliente.getNome().equals(nome)) {
                listaProdutosEscolhidos.remove(i);
                return produtoCliente.getQuantidade();
            }
            i++;
        }
        System.out.println("|--PRODUTO NÃO ENCONTRADO--|");
        return i = -1;
    }

    public double totalCarrinho(List<QuantidadeProduto> listaEstoque) {
        double total = 0;
        for (ProdutoCliente produto : listaProdutosEscolhidos) {
            for (QuantidadeProduto precoProduto : listaEstoque) {
                if (precoProduto.getProduto().getNome().equals(produto.getNome())) {
                    System.out.println(produto + " x" + String.format("%.2f",precoProduto.getPreco()) + "Kg");
                    total += precoProduto.getPreco() * produto.getQuantidade();
                    break;
                }
            }
        }
        return total;
    }

    public void imprimeCarrinho() {
        for (ProdutoCliente produtoCliente : listaProdutosEscolhidos) {
            System.out.println(produtoCliente);
        }
    }
}
