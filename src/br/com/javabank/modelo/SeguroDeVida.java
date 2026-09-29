package br.com.javabank.modelo;

public class SeguroDeVida implements Tributavel{
    private double valorApolice;

    public SeguroDeVida(double valorApolice){
        this.valorApolice = valorApolice;
    }

    public double getValorApolice(){
        return this.valorApolice;
    }


    @Override
    public double getValorImposto() {
        //5% do valor da apolice
        return valorApolice * 0.05;
    }
}
