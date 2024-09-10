import java.util.ArrayList;
import java.util.Date;

public abstract class Despesa {
    private String descricao;
    private double valor;
    private Date dataVencimento;
    private boolean paga;
    private String categoria;
    private ArrayList<Pagamento> pagamentos; // Lista para armazenar os pagamentos

    public Despesa(String descricao, double valor, Date dataVencimento, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.paga = false; // Inicialmente, a despesa não está paga
        this.categoria = categoria;
        this.pagamentos = new ArrayList<>(); // Inicializa a lista de pagamentos
    }

    // Getter e Setter para os atributos
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public String getCategoria() {
        return categoria;
    }

    // Método para adicionar um pagamento
    public void addPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento); // Adiciona o pagamento à lista
        this.paga = true; // Marca a despesa como paga
    }

    // Método para listar pagamentos
    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + ", Valor: " + valor + ", Data de Vencimento: " + dataVencimento + ", Categoria: " + categoria + ", Paga: " + paga;
    }
}
