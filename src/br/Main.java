package br;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Criar contas e armazenar no Map
    Map<Integer, Conta> contas = new HashMap<>();
    contas.put(123, new Conta("Shiriu", 123, 1000));
    contas.put(456, new Conta("LinceNegra", 456, 500));

    while (true) {
      System.out.print("\nDigite o número da sua conta (ou 0 para sair): ");
      int numeroConta = scanner.nextInt();

      if (numeroConta == 0) break;

      Conta contaAtual = contas.get(numeroConta);
      if (contaAtual == null) {
        System.out.println("Conta não encontrada.");
        continue;
      }

      int opcao;
      do {
        System.out.println("\nBem-vindo, " + contaAtual.getTitular());
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Transferir");
        System.out.println("4 - Pagar");
        System.out.println("5 - Trocar de conta");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();

        switch (opcao) {
          case 1:
            System.out.print("Valor para depósito: R$ ");
            double valorDep = scanner.nextDouble();
            contaAtual.depositar(valorDep);
            break;

          case 2:
            System.out.print("Valor para saque: R$ ");
            double valorSaq = scanner.nextDouble();
            contaAtual.sacar(valorSaq);
            break;

          case 3:
            System.out.print("Número da conta destino: ");
            int numDestino = scanner.nextInt();
            Conta destino = contas.get(numDestino);
            if (destino == null) {
              System.out.println("Conta de destino não encontrada.");
              break;
            }
            System.out.print("Valor para transferir: R$ ");
            double valorTransf = scanner.nextDouble();
            contaAtual.transferir(destino, valorTransf);
            break;

          case 4:
            System.out.print("Valor do pagamento: R$ ");
            double valorPag = scanner.nextDouble();
            contaAtual.pagar(valorPag);
            break;

          case 5:
            System.out.println("Trocando de conta...");
            break;

          default:
            System.out.println("Opção inválida!");
        }

        System.out.printf("Saldo atual: R$ %.2f%n", contaAtual.getSaldo());

      } while (opcao != 5);
    }

    scanner.close();
  }
}
