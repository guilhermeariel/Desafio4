package br;

public class Conta {
  private String titular;
  private int numero;
  private double saldo;

  private static final double TAXA_DE_TRANSFERENCIA = 0.5;

  //CONSTRUTOR
  public Conta(String titular, int numero, double saldo) {
    this.titular = titular;
    this.numero = numero;
    this.saldo = saldo;
  }
  //GETTERS SETTERS
  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  //METODOS PUBLICOS
  public boolean depositar(double valor) {
    if (valor <= 0) return false;
    saldo += valor - TAXA_DE_TRANSFERENCIA;
    return true;
  }

  public boolean sacar(double valor) {
    if (valor + TAXA_DE_TRANSFERENCIA > saldo || valor <=0) return false;
    saldo -= (valor + TAXA_DE_TRANSFERENCIA);
    return true;
  }

  public boolean transferir(Conta destino, double valor) {
    if (sacar(valor)) {
      destino.depositar(valor);
      return true;
    }
  return false;
  }

  public boolean pagar(double valor) {
    return sacar(valor);
  }


}
