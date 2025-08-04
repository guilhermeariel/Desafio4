package br;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Criando as duas contas
    Conta c1 = new Conta("LinceNegra", 123, 100);
    Conta c2 = new Conta("Shiriu", 669, 10);

    int opcao;
    do {
      System.out.println("\n--- Menu ---");
      System.out.println("1 - Depositar");
      System.out.println("2 - Sacar");
      System.out.println("3 - Transferir");
      System.out.println("4 - Pagar");
      System.out.println("5 - Sair");
      System.out.print("Escolha uma opção: ");
      opcao = sc.nextInt();

      switch (opcao) {
        case 1:
          System.out.print("Valor para depósito: R$ ");
          double valorDep = sc.nextDouble();
          if (c1.depositar(valorDep)) {
            System.out.println("Depósito realizado com sucesso.");
          } else {
            System.out.println("Valor inválido para depósito.");
          }
          break;

        case 2:
          System.out.print("Valor para saque: R$ ");
          double valorSaq = sc.nextDouble();
          if (c1.sacar(valorSaq)) {
            System.out.println("Saque realizado com sucesso.");
          } else {
            System.out.println("Saque não realizado. Verifique saldo ou valor.");
          }
          break;

        case 3:
          System.out.print("Valor para transferência: R$ ");
          double valorTransf = sc.nextDouble();
          if (c1.transferir(c2, valorTransf)) {
            System.out.println("Transferência realizada para " + c2.getTitular());
          } else {
            System.out.println("Transferência falhou. Verifique saldo.");
          }
          break;

        case 4:
          System.out.print("Valor do pagamento: R$ ");
          double valorPag = sc.nextDouble();
          if (c1.pagar(valorPag)) {
            System.out.println("Pagamento realizado com sucesso.");
          } else {
            System.out.println("Pagamento falhou. Verifique saldo.");
          }
          break;

        case 5:
          System.out.println("Encerrando...");
          break;

        default:
          System.out.println("Opção inválida!");
      }

      System.out.printf("Saldo atual: R$ %.2f%n", c1.getSaldo());

    } while (opcao != 5);

    sc.close();
  }
}
