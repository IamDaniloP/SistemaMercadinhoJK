package modelo.entidades.funcionario;

public class Produto {
    private String nome;
    private String setor;
    private Double preco;

    public Produto(String nome, String setor,Double preco) {
        this.nome = nome;
        this.setor = setor;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public String getSetor() {
        return setor;
    }
    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return this.getNome() + " | Setor: " + this.getSetor() + " | Preço: R$" + String.format("%.2f", this.getPreco()) + "/Kg ";
    }
}
