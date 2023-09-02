package modelo.entidades.cliente;

import modelo.entidades.funcionario.Estoque;
import modelo.entidades.funcionario.QuantidadeProduto;
import modelo.entidades.pagamento.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCliente {
    private List<QuantidadeProduto> listaProdutosEscolhidos;

    public CarrinhoCliente() {
        listaProdutosEscolhidos = new ArrayList<>();
    }

    public List<QuantidadeProduto> getListaProdutosEscolhidos() {
        return listaProdutosEscolhidos;
    }

    public void inserirCarrinho(List<QuantidadeProduto> listaEstoque,QuantidadeProduto produtoCliente) {
        for (QuantidadeProduto produtoEstoque : listaEstoque) {
            if (produtoEstoque.getProduto().getNome().equals(produtoCliente.getProduto().getNome())) {
                if (produtoEstoque.getQuantidade() > produtoCliente.getQuantidade()) {
                    listaProdutosEscolhidos.add(produtoCliente);
                } else {
                    System.out.println("|--QUANTIDADE INSUFICIENTE--|");
                    produtoCliente.setQuantidade(produtoEstoque.getQuantidade());
                }
            } else {
                System.out.println("|--PRODUTO NÃO CADASTRADO--|");
            }
        }
    }
}
