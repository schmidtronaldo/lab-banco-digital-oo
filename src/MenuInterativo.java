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
            System.out.println("1. Criar Cliente");
            System.out.println("2. Acessar Conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    criarCliente();
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

    private void criarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a senha do cliente: ");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, senha);
        banco.adicionarCliente(cliente);

        System.out.println("Cliente criado com sucesso!");

        // Criar contas corrente e poupança
        Conta cc = new ContaCorrente(cliente, senha);
        Conta poupanca = new ContaPoupanca(cliente, senha);

        // Depositar valor mínimo
        cc.depositar(500);
        poupanca.depositar(500);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        System.out.println("Contas criadas com sucesso!");
    }

    private void acessarConta() {
        System.out.print("Digite o número da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        Conta conta = banco.buscarContaPorNumero(numero);
        if (conta != null && conta.verificarSenha(senha)) {
            menuConta(conta);
        } else {
            System.out.println("Conta ou senha inválida!");
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