package modelo.entidades.cliente;

public class Cliente {
    private String nome;
    private int numId;

    public Cliente(String nome) {
        this.nome = nome;
        this.numId = (int) Math.round(Math.random() * (10000 - 8000) + 8000);
    }

    public String getNome() {
        return nome;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }
    @Override
    public String toString() {
        return this.getNome() + " | Id: " + this.getNumId();
    }
}
