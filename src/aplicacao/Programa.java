package aplicacao;

import modelo.entidades.Relatorio;
import modelo.entidades.cliente.CarrinhoCliente;
import modelo.entidades.cliente.Cliente;
import modelo.entidades.cliente.ProdutoCliente;
import modelo.entidades.funcionario.Estoque;
import modelo.entidades.funcionario.Produto;
import modelo.entidades.funcionario.QuantidadeProduto;
import modelo.entidades.pagamento.Pagamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Estoque estoque = new Estoque();
        CarrinhoCliente  carrinhoCliente = new CarrinhoCliente();
        Relatorio relatorio = new Relatorio();
        Pagamento pagamento;

        try {
            int opcaoInicial;
            do {
                System.out.println("|--MERCADINHO JK--|");

                System.out.println();
                System.out.println("1 - Estoque");
                System.out.println("2 - Caixa");
                System.out.println("3 - Imprimir relatório");
                System.out.println("0 - Sair");
                System.out.println();
                opcaoInicial = input.nextInt();
                switch (opcaoInicial) {
                    case 1 -> {
                        int opcao;
                        try {
                            do {
                                System.out.println("1 - Inserir novo produto.");
                                System.out.println("2 - Atualizar quantidade de um produto.");
                                System.out.println("0 - Sair");
                                opcao = input.nextInt();
                                switch (opcao) {
                                    case 1 -> {
                                        System.out.printf("%nInsira os dados do novo produto: %n");
                                        System.out.print("Nome: ");
                                        input.nextLine();
                                        String nome = input.nextLine();
                                        System.out.printf("%nSetor: ");
                                        String setor = input.next();
                                        System.out.printf("%nPreço: ");
                                        Double preco = input.nextDouble();
                                        System.out.printf("%nDeseja adicionar uma quantidade [S/N]? ");
                                        char adicionarQuantidade = input.next().charAt(0);
                                        if (adicionarQuantidade == 'S' || adicionarQuantidade == 's') {
                                            System.out.printf("%nQuantidade: ");
                                            int quantidade = input.nextInt();
                                            estoque.adicionaNovoProduto(new QuantidadeProduto(new Produto(nome), setor, preco, quantidade));
                                        } else if (adicionarQuantidade == 'N' || adicionarQuantidade == 'n') {
                                            estoque.adicionaNovoProduto(new QuantidadeProduto(new Produto(nome), setor, preco));
                                        }
                                        System.out.println();
                                        estoque.imprime_produtos();
                                        System.out.println();
                                    }
                                    case 2 -> {
                                        System.out.printf("%n1 - Adicionar quantidade");
                                        System.out.printf("%n0 - Sair%n");
                                        int opcaoAtualizar = input.nextInt();
                                        if (opcaoAtualizar == 1) {
                                            System.out.printf("%nNome do produto: ");
                                            input.nextLine();
                                            String nomeProduto = input.nextLine();
                                            if (estoque.verificaProdutoExistente(nomeProduto) != -1) {
                                                System.out.printf("%nQuantidade: ");
                                                int quantidade = input.nextInt();
                                                estoque.adicionaQuantidadeProduto(nomeProduto, quantidade);
                                            } else {
                                                estoque.naoCadastrado();
                                                continue;
                                            }
                                            System.out.println();
                                            estoque.imprime_produtos();
                                            System.out.println();
                                        }
                                    }
                                    case 3 -> {
                                        Pagamento.testeRetornoString();
                                    }
                                }
                            } while (opcao != 0);
                        } catch (InputMismatchException e) {
                            System.out.println("Erro na inserção de dados: " + e.getMessage()); // realizar o tratamento de erro
                        }
                    }
                    case 2 -> {
                        try {
                            int opcaoCaixa;
                            do {
                                System.out.println();
                                System.out.println("|--PRODUTOS DISPONÍVEIS--|");
                                estoque.imprime_produtos();
                                System.out.println("|------------------------|");
                                System.out.println();

                                System.out.println("|------SEU CARRINHO------|");
                                carrinhoCliente.imprimeCarrinho();
                                System.out.println("|------------------------|");
                                System.out.println();
                                System.out.println("1 - Adicionar produto");
                                System.out.println("2 - Remover produto");
                                System.out.println("3 - Realizar pagamento");
                                System.out.println("0 - Sair");
                                opcaoCaixa = input.nextInt();

                                switch (opcaoCaixa) {
                                    case 1 -> {
                                        System.out.println();
                                        System.out.println("|--DADOS DO PRODUTO--|");
                                        System.out.print("Nome: ");
                                        input.nextLine();
                                        String nome = input.nextLine();
                                        System.out.printf("%nQuantidade: ");
                                        int quantidade = input.nextInt();

                                        boolean inserirCarrinho = carrinhoCliente.inserirCarrinho(estoque.getListProdutos(), new ProdutoCliente(nome, quantidade));
                                        if (inserirCarrinho) {
                                            estoque.retiraQuantidadeProduto(nome, quantidade);
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println();
                                        System.out.println("|--DADOS DO PRODUTO--|");
                                        System.out.print("Nome: ");
                                        input.nextLine();
                                        String nome = input.nextLine();

                                        int removerCarrinho = carrinhoCliente.removerCarrinho(nome);
                                        if (removerCarrinho != -1) {
                                            estoque.adicionaQuantidadeProduto(nome, removerCarrinho);
                                        }
                                    }
                                    case 3 -> {
                                        System.out.println();
                                        System.out.println("|--DADOS CADASTRAIS DO CLIENTE--|");
                                        System.out.println();
                                        System.out.print("Nome: ");
                                        input.nextLine();
                                        String nome = input.nextLine();

                                        pagamento = new Pagamento(new Cliente(nome), carrinhoCliente.getListaProdutosEscolhidos());
                                        System.out.printf("%nTotal: %.2f", pagamento.totalCarrinho(estoque.getListProdutos()));
                                        System.out.println();
                                        System.out.println();

                                        relatorio.adicionaAListaPagamentos(pagamento);
                                        carrinhoCliente = new CarrinhoCliente();
                                        opcaoCaixa = 0;
                                    }
                                }
                            } while (opcaoCaixa != 0);
                        } catch (InputMismatchException e) {
                            System.out.println("Erro na inserção de dados: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.println(relatorio);

                        /*try (BufferedReader br = new BufferedReader(new FileReader("/home/emanuelle/Documentos/relatorio.txt"))) {
                            String linhaSeguinte = br.readLine();
                            while (linhaSeguinte != null) {
                                System.out.println(linhaSeguinte);
                                linhaSeguinte = br.readLine();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/
                    }
                }
            } while (opcaoInicial != 0);
        }
        catch (InputMismatchException e) {
            System.out.println("Erro na inserção de dados: " + e.getMessage());
        }
        input.close();
    }
}
