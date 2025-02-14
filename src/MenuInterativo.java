import java.util.Scanner;

public class MenuInterativo {

    private Banco banco;
    private Scanner scanner;

    public MenuInterativo(Banco banco) {
        this.banco = banco;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Criar Cliente e Conta");
            System.out.println("2. Acessar Conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    criarClienteEConta();
                    break;
                case 2:
                    acessarConta();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    private void criarClienteEConta() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a senha do cliente: ");
        String senha = scanner.nextLine();

        // Verifica se o cliente já existe
        Cliente clienteExistente = banco.buscarClientePorCpf(cpf);
        if (clienteExistente != null) {
            System.out.println("Cliente já cadastrado com este CPF!");
            return;
        }

        Cliente cliente = new Cliente(nome, cpf, senha);
        banco.adicionarCliente(cliente);

        System.out.println("Cliente criado com sucesso!");

        // Escolher tipo de conta
        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.print("Opção: ");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Definir valor inicial
        System.out.print("Digite o valor inicial da conta (mínimo $500): ");
        double valorInicial = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        if (valorInicial < 500) {
            System.out.println("Valor mínimo não atingido. A conta será criada com $500.");
            valorInicial = 500;
        }

        Conta conta;
        if (tipoConta == 1) {
            conta = new ContaCorrente(cliente, senha);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(cliente, senha);
        } else {
            System.out.println("Opção inválida! Criando conta corrente por padrão.");
            conta = new ContaCorrente(cliente, senha);
        }

        conta.depositar(valorInicial);
        banco.adicionarConta(conta);

        System.out.println("Conta criada com sucesso!");
        System.out.println("Número da conta: " + conta.getNumero());
    }

    private void acessarConta() {
        System.out.print("Digite o CPF ou nome do cliente: ");
        String identificador = scanner.nextLine();

        Cliente cliente = banco.buscarClientePorCpf(identificador);
        if (cliente == null) {
            cliente = banco.buscarClientePorNome(identificador);
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Buscar contas do cliente
        Conta conta = banco.buscarContaPorClienteESenha(cliente, senha);
        if (conta != null) {
            menuConta(conta);
        } else {
            System.out.println("Senha incorreta ou conta não encontrada!");
        }
    }

    private void menuConta(Conta conta) {
        int opcao;
        do {
            System.out.println("\n=== MENU DA CONTA ===");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Transferir");
            System.out.println("4. Imprimir Extrato");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 2:
                    System.out.print("Digite o valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o número da conta destino: ");
                    int numeroDestino = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    Conta contaDestino = banco.buscarContaPorNumero(numeroDestino);
                    if (contaDestino != null) {
                        System.out.print("Digite o valor para transferir: ");
                        double valorTransferencia = scanner.nextDouble();
                        conta.transferir(valorTransferencia, contaDestino);
                    } else {
                        System.out.println("Conta destino não encontrada!");
                    }
                    break;
                case 4:
                    conta.imprimirExtrato();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }
}