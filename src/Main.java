import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                Cliente userClient = new Cliente();
                
                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                userClient.setNome(nome);
                
                
                Conta cc = new ContaCorrente(userClient);
                Conta poupanca = new ContaPoupanca(userClient);
                
                cc.depositar(100);
                cc.transferir(100, poupanca);
                
                cc.imprimirExtrato();
                poupanca.imprimirExtrato();
            }
	}

}
