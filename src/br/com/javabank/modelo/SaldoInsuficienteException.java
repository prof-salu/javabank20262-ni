package br.com.javabank.modelo;

public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(){
        super("Erro 1002: Saldo insuficiente para realizar a operação.");
    }
}