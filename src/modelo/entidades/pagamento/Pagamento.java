package modelo.entidades.pagamento;

import modelo.entidades.funcionario.QuantidadeProduto;

import java.util.ArrayList;
import java.util.List;

public class Pagamento {
    private Double[] taxa = new Double[]{0.05, 0.03, 0.10};
    List<QuantidadeProduto> listaProdutosPagamento;

    public Pagamento() {
        listaProdutosPagamento = new ArrayList<>();
    }

    public List<QuantidadeProduto> getListaProdutosPagamento() {
        return listaProdutosPagamento;
    }

    public void adicionarProdutosPagamento(QuantidadeProduto produto) {
        listaProdutosPagamento.add(produto);
    }

    public Double calculaTaxaSetor() {
        Double acumulador = (double) 0;
        for (QuantidadeProduto produto : listaProdutosPagamento) {
            if (produto.getProduto().getSetor().equals("Alimentação")) {
                acumulador += produto.getProduto().getPreco() * produto.getQuantidade();
            }
        }
        //taxa[0] -> taxa do setor alimentação.
        return acumulador * taxa[0];
    }
}
