package modelo.entidades.pagamento;

import modelo.entidades.cliente.Cliente;
import modelo.entidades.cliente.ProdutoCliente;
import modelo.entidades.funcionario.QuantidadeProduto;
import modelo.enums.StatusPagamento;

import java.util.List;

public class Pagamento {
    private Cliente cliente;
    private List<ProdutoCliente> listaCliente;
    private StatusPagamento statusPagamento;
    private double total;

    public Pagamento(Cliente cliente, List<ProdutoCliente> listaCliente) {
        this.cliente = cliente;
        this.listaCliente = listaCliente;
        this.statusPagamento = StatusPagamento.PROCESSANDO_PAGAMENTO;
        this.total = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ProdutoCliente> getListaCliente() {
        return listaCliente;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public double getTotal() {
        return total;
    }

    public double totalCarrinho(List<QuantidadeProduto> listaEstoque) {
        System.out.printf("%n" + this.listaCarrinho(listaEstoque));
        for (ProdutoCliente produto : listaCliente) {
            for (QuantidadeProduto precoProduto : listaEstoque) {
                if (precoProduto.getProduto().getNome().equals(produto.getNome())) {
                    this.setStatusPagamento(StatusPagamento.valueOf("PAGO"));
                    total += precoProduto.getPreco() * produto.getQuantidade();
                    break;
                }
            }
        }
        return total;
    }

    public String listaCarrinho (List<QuantidadeProduto> listaEstoque) {
        StringBuilder sb = new StringBuilder();
        for (ProdutoCliente produto : listaCliente) {
            for (QuantidadeProduto precoProduto : listaEstoque) {
                if (precoProduto.getProduto().getNome().equals(produto.getNome())) {
                    sb.append(produto).append("x ").append(String.format("%.2f",precoProduto.getPreco())).append("\n");
                    break;
                }
            }
        }
        return sb.toString();
    }

}
