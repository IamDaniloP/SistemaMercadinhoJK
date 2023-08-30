package modelo.entidades.cliente;

import modelo.entidades.funcionario.Estoque;
import modelo.entidades.funcionario.QuantidadeProduto;
import modelo.entidades.pagamento.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCliente {
    private List<QuantidadeProdutoCliente> listaProdutosEscolhidos;
    private Estoque estoque;
    private Pagamento pagamento;

    public CarrinhoCliente() {
        listaProdutosEscolhidos = new ArrayList<>();
        estoque = new Estoque();
        pagamento = new Pagamento();
    }

    public List<QuantidadeProdutoCliente> getListaProdutosEscolhidos() {
        return listaProdutosEscolhidos;
    }

    public void inserirCarrinho(QuantidadeProduto produtoCliente) {
        listaProdutosEscolhidos.add((QuantidadeProdutoCliente) produtoCliente);
    }

    public boolean verificaEstoque(List<QuantidadeProduto> listaEstoque) {
        listaEstoque.forEach(produtoEstoque -> {
            listaProdutosEscolhidos.forEach(produtoCliente -> {
                if (produtoEstoque.getProduto().getNome().equals(produtoCliente.getProduto().getNome())) {
                    if (produtoEstoque.getQuantidade() > produtoCliente.getQuantidade()) {
                        pagamento.adicionarProdutosPagamento(produtoCliente);
                    } else {
                        //Criar função reajusta quantidade.
                        System.out.println("Não possui estoque disponível.");
                    }
                }
            });
        });
        return false;
    }
}
