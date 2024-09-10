import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    private static ArrayList<Despesa> despesas = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<TipoDespesa> tiposDespesa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Controle de Despesas ---");
            System.out.println("1. Entrar Despesa");
            System.out.println("2. Anotar Pagamento");
            System.out.println("3. Listar Despesas em Aberto no Período");
            System.out.println("4. Listar Despesas Pagas no Período");
            System.out.println("5. Gerenciar Tipos de Despesa");
            System.out.println("6. Gerenciar Usuários");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // Limpar a entrada inválida
            }
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    entrarDespesa(scanner);
                 break;
                case 2:
                    anotarPagamento(scanner);
                    break;
                case 3:
                    listarDespesas(false); // Listar despesas em aberto
                    break;
                case 4:
                    listarDespesas(true); // Listar despesas pagas
                    break;
                case 5:
                    gerenciarTiposDespesa(scanner);
                    break;
                case 6:
                    gerenciarUsuarios(scanner);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    // Método para entrar uma nova despesa
    private static void entrarDespesa(Scanner scanner) {
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Descrição da despesa: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor da despesa: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Data de vencimento (dd/MM/yyyy): ");
        String dataVencimentoStr = scanner.nextLine();

        Date dataVencimento = parseDate(dataVencimentoStr);
        if (dataVencimento == null) {
            System.out.println("Data inválida. Tente novamente.");
            return;
        }

        System.out.print("Categoria da despesa: ");
        String categoria = scanner.nextLine();

        Despesa despesa = new TransporteDespesa(descricao, valor, dataVencimento, categoria); // Exemplo com TransporteDespesa
        despesas.add(despesa);
        System.out.println("Despesa adicionada com sucesso!");
    }

    // Método para anotar pagamento de uma despesa
    private static void anotarPagamento(Scanner scanner) {
    listarDespesas(false); // Listar despesas em aberto
    System.out.print("Escolha o índice da despesa para registrar o pagamento: ");
    while (!scanner.hasNextInt()) {
        System.out.println("Por favor, insira um índice válido.");
        scanner.next(); // Limpar a entrada inválida
    }
    
    int index = scanner.nextInt();
    if (index >= 0 && index < despesas.size()) {
        Despesa despesa = despesas.get(index);
        if (!despesa.isPaga()) {
            System.out.print("Data do pagamento (dd/MM/yyyy): ");
            scanner.nextLine(); // Limpar o buffer
            String dataPagamentoStr = scanner.nextLine();
            
            Date dataPagamento = parseDate(dataPagamentoStr);
            if (dataPagamento == null) {
                System.out.println("Data inválida. Tente novamente.");
                return;
            }

            System.out.print("Valor do pagamento: ");
            double valorPagamento = scanner.nextDouble();
            
            // Registrar o pagamento na despesa
            Pagamento pagamento = new Pagamento(dataPagamento, valorPagamento, despesa);
            despesa.addPagamento(pagamento); // Método que adiciona o pagamento à despesa
            despesa.setPaga(true);
            System.out.println("Pagamento registrado com sucesso!");
        } else {
            System.out.println("Despesa já está paga.");
        }
    } else {
        System.out.println("Índice inválido.");
    }
}


    // Método auxiliar para converter String para Date
    private static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    // Método para listar despesas pagas ou em aberto
    private static void listarDespesas(boolean pagas) {
        System.out.println(pagas ? "\nDespesas Pagas:" : "\nDespesas em Aberto:");
        for (int i = 0; i < despesas.size(); i++) {
            Despesa despesa = despesas.get(i);
            if (despesa.isPaga() == pagas) {
                System.out.println(i + ". " + despesa);
            }
        }
    }

    // Método para gerenciar tipos de despesa
    private static void gerenciarTiposDespesa(Scanner scanner) {
        System.out.println("\n--- Gerenciar Tipos de Despesa ---");
        System.out.println("1. Adicionar Tipo");
        System.out.println("2. Editar Tipo");
        System.out.println("3. Listar Tipos");
        System.out.println("4. Excluir Tipo");
        System.out.print("Escolha uma opção: ");
        
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next(); // Limpar a entrada inválida
        }
        
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                adicionarTipoDespesa(scanner);
                break;
            case 2:
                // Implementar edição de tipo de despesa
                break;
            case 3:
                listarTiposDespesa();
                break;
            case 4:
                // Implementar exclusão de tipo de despesa
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void adicionarTipoDespesa(Scanner scanner) {
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nome do tipo de despesa: ");
        String nome = scanner.nextLine();
        int id = tiposDespesa.size() + 1;
        TipoDespesa tipoDespesa = new TipoDespesa(id, nome);
        tiposDespesa.add(tipoDespesa);
        System.out.println("Tipo de despesa adicionado com sucesso!");
    }

    private static void listarTiposDespesa() {
        System.out.println("\nTipos de Despesa:");
        for (TipoDespesa tipoDespesa : tiposDespesa) {
            System.out.println(tipoDespesa);
        }
    }

    // Método para gerenciar usuários
    private static void gerenciarUsuarios(Scanner scanner) {
        System.out.println("\n--- Gerenciar Usuários ---");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Listar Usuários");
        System.out.print("Escolha uma opção: ");
        
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next(); // Limpar a entrada inválida
        }
        
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cadastrarUsuario(scanner);
                break;
            case 2:
                listarUsuarios();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Login do usuário: ");
        String login = scanner.nextLine();
        System.out.print("Senha do usuário: ");
        String senha = scanner.nextLine();
        Usuario usuario = new Usuario(login, senha);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        System.out.println("\nUsuários:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
