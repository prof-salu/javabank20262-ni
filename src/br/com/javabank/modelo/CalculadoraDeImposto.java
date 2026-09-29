package br.com.javabank.modelo;

public class CalculadoraDeImposto {
    private double valorArrecadado;

    public CalculadoraDeImposto(){
        valorArrecadado = 0;
    }

    public double getValorArrecadado(){
        return this.valorArrecadado;
    }

    public void arrecadar(Tributavel tributavel){
        valorArrecadado += tributavel.getValorImposto();
    }
}
