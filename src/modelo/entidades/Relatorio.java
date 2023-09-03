package modelo.entidades;

import modelo.entidades.cliente.ProdutoCliente;
import modelo.entidades.pagamento.Pagamento;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    private List<Pagamento> pagamentos;

    public Relatorio() {
        pagamentos = new ArrayList<>();
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void adicionaAListaPagamentos(Pagamento pedidoCliente) {
        pagamentos.add(pedidoCliente);
        this.insereAoRelatorio();
    }

    public void insereAoRelatorio() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("/home/emanuelle/Documentos/relatorio.txt"))) {
            for (Pagamento pedidoCliente : pagamentos) {
                bw.write(pedidoCliente.getCliente() + " | Status do pagamento: " + pedidoCliente.getStatusPagamento());
                bw.newLine();
                for (ProdutoCliente produtosCliente : pedidoCliente.getListaCliente()) {
                    bw.write(produtosCliente.toString());
                    bw.newLine();
                }
                bw.write("Total: " + pedidoCliente.getTotal());
                bw.newLine();
                bw.write("----------------------------");
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao procurar diretório: " + e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Pagamento pedidoCliente : pagamentos) {
            sb.append(pedidoCliente.getCliente() + " | Status do pagamento: " + pedidoCliente.getStatusPagamento());
            sb.append("\n");
            for (ProdutoCliente produtosCliente : pedidoCliente.getListaCliente()) {
                sb.append(produtosCliente);
                sb.append("\n");
            }
            sb.append("Total: " + pedidoCliente.getTotal());
            sb.append("\n");
            sb.append("----------------------------");
            sb.append("\n");
        }

        return sb.toString();
    }
}
