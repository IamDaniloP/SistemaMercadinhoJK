package modelo.entidades.cliente;

public class Cliente {
    private String name;
    private int numId;

    public Cliente(String name, int numId) {
        this.name = name;
        this.numId = numId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }
}
