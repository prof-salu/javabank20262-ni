package br.com.javabank.modelo;

public class Poupanca extends Conta{
    private double taxaRendimento;

    public Poupanca(int numero, String titular,
                    double saldo, double taxaRendimento){
        super(numero, titular, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento(){
        return taxaRendimento;
    }

    public double renderJuros(){
        return (saldo * taxaRendimento) / 100;
    }
}
