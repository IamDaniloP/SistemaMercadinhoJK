package aplicacao;

import modelo.entidades.cliente.CarrinhoCliente;
import modelo.entidades.cliente.QuantidadeProdutoCliente;
import modelo.entidades.funcionario.Estoque;
import modelo.entidades.funcionario.Produto;
import modelo.entidades.funcionario.QuantidadeProduto;
import modelo.entidades.pagamento.Pagamento;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaFuncionario {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("Escolha o que deseja fazer: ");
        Estoque estoque = new Estoque();
        Pagamento pagamento = new Pagamento();

        int opcao;
        try {
            do {
                System.out.println("1 - Inserir novo produto.");
                System.out.println("2 - Atualizar quantidade de um produto.");
                System.out.println("3 - Sair");
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
                            estoque.adicionaNovoProduto(new QuantidadeProduto(new Produto(nome, setor, preco), quantidade));
                        } else if (adicionarQuantidade == 'N' || adicionarQuantidade == 'n') {
                            estoque.adicionaNovoProduto(new QuantidadeProduto(new Produto(nome, setor, preco)));
                        }
                        System.out.println();
                        estoque.imprime_produtos();
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.printf("%n1 - Adicionar quantidade");
                        System.out.printf("%n2 - Subtrair quantidade%n");
                        int opcaoAtualizar = input.nextInt();
                        if (opcaoAtualizar == 1) {
                            System.out.printf("%nNome do produto: ");
                            input.nextLine();
                            String nomeProduto = input.nextLine();
                            System.out.printf("%nQuantidade: ");
                            int quantidade = input.nextInt();
                            estoque.adicionaQuantidadeProduto(nomeProduto, quantidade);
                            System.out.println();
                            estoque.imprime_produtos();
                            System.out.println();
                        } else if (opcaoAtualizar == 2) {
                            System.out.printf("%nNome do produto: ");
                            input.nextLine();
                            String nomeProduto = input.nextLine();
                            System.out.printf("%nQuantidade: ");
                            int quantidade = input.nextInt();
                            estoque.retiraQuantidadeProduto(nomeProduto, quantidade);
                            System.out.println();
                            estoque.imprime_produtos();
                            System.out.println();
                        }
                    }
                }
            } while (opcao != 3);
        } catch (InputMismatchException e) {
            System.out.println("Erro na inserção de dados: " + e.getMessage()); // realizar o tratamento de erro
        }

        input.close();
    }
}
