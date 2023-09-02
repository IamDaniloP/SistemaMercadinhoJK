package modelo.entidades.funcionario;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<QuantidadeProduto> listaProdutos;
    public Estoque() {
        listaProdutos = new ArrayList<>();
    }

    public List<QuantidadeProduto> getListProdutos() {
        return listaProdutos;
    }

    public void adicionaNovoProduto(QuantidadeProduto produto) {
        if (verificaProdutoExistente(produto.getProduto().getNome()) == -1) {
            listaProdutos.add(produto);
        }
        else {
            System.out.println();
            System.out.println("|--PRODUTO JÁ CADASTRADO--|");
            System.out.println();
        }
    }

    public int verificaProdutoExistente(String nomeProduto) {
        int i = 0; //retornará o index
        for (QuantidadeProduto produto : listaProdutos) {
            if (produto.getProduto().getNome().equals(nomeProduto)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void adicionaQuantidadeProduto(String nomeProduto, int quantidade) {
        int verificacaoProduto = this.verificaProdutoExistente(nomeProduto);
        if (verificacaoProduto != -1) {
            QuantidadeProduto produto = listaProdutos.get(verificacaoProduto);
            produto.setQuantidade(produto.getQuantidade() + quantidade);
        } else {
            this.naoCadastrado();
        }
    }

    public void retiraQuantidadeProduto(String nomeProduto, int quantidade) {
        int verificacaoProduto = this.verificaProdutoExistente(nomeProduto);
        if (verificacaoProduto != -1) {
            QuantidadeProduto produto = listaProdutos.get(verificacaoProduto);
            if (produto.getQuantidade() < quantidade) {
                System.out.println();
                System.out.printf("%n|--QUANTIDADE DO PRODUTO REAJUSTADA PARA VALOR DISPONÍVEL EM ESTOQUE--|");
                System.out.println();
                quantidade = produto.getQuantidade();
            }
            produto.setQuantidade(produto.getQuantidade() - quantidade);
        } else {
            this.naoCadastrado();
        }
    }

    public void naoCadastrado() {
        System.out.println();
        System.out.println("|--PRODUTO NÃO CADASTRADO--|");
        System.out.println();
    }

    public void imprime_produtos() {
        for (QuantidadeProduto produto : listaProdutos) {
            System.out.println(produto);
        }
    }
}
