import java.util.Date;

public class TransporteDespesa extends Despesa {
    public TransporteDespesa(String descricao, double valor, Date dataVencimento, String categoria) {
        super(descricao, valor, dataVencimento, categoria);
    }

    // Métodos específicos para despesas de transporte podem ser adicionados aqui
}