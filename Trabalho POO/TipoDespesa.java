public class TipoDespesa {
    private int id;
    private String nome;

    public TipoDespesa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome;
    }
}