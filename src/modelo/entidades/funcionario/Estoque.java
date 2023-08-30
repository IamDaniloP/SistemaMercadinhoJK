package modelo.entidades.funcionario;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<QuantidadeProduto> listProdutos;
    public Estoque() {
        listProdutos = new ArrayList<>();
    }

    public List<QuantidadeProduto> getListProdutos() {
        return listProdutos;
    }

    public void adicionaNovoProduto(QuantidadeProduto produto) {
        listProdutos.add(produto);
    }
    public void adicionaQuantidadeProduto(String nomeProduto, int quantidade) {
        boolean produtoEncontrado = true;

        for (QuantidadeProduto produto : listProdutos) {
            if (nomeProduto.equals(produto.getProduto().getNome())) {
                int quantidadeNova = produto.getQuantidade() + quantidade;
                produto.setQuantidade(quantidadeNova);
                produtoEncontrado = true;
                break;
            } else {
                produtoEncontrado = false;
            }
        }
        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado!");
        }
    }
    public void retiraQuantidadeProduto(String nomeProduto, int quantidade) {
        boolean produtoEncontrado = true;

        for (QuantidadeProduto produto : listProdutos) {
            if (nomeProduto.equals(produto.getProduto().getNome())) {
                if (produto.getQuantidade() < quantidade) {
                    System.out.printf("%nNão possui estoque suficiente, quantidade inserida reajustada.");
                    System.out.println();
                    quantidade = produto.getQuantidade();
                }
                int quantidadeNova = produto.getQuantidade() - quantidade;
                produto.setQuantidade(quantidadeNova);
                produtoEncontrado = true;
                break;
            } else {
                produtoEncontrado = false;
            }
        }
    }
    public void imprime_produtos() {
        for (QuantidadeProduto produto : listProdutos) {
            System.out.println(produto);
        }
    }
}
