import java.util.Date;

public class Pagamento {
    private Date dataPagamento;
    private double valorPagamento;
    private Despesa despesa;

    public Pagamento(Date dataPagamento, double valorPagamento, Despesa despesa) {
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
        this.despesa = despesa;
    }

    @Override
    public String toString() {
        return "Data do Pagamento: " + dataPagamento + ", Valor: " + valorPagamento + ", Despesa: " + despesa.getDescricao();
    }
}