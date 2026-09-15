package br.com.javabank.modelo;

public class Corrente extends Conta{
    private double limite;

    public Corrente(int numero, String titular,
                    double saldo, double limite){
        //Acessando o construtor da classe Conta
        super(numero, titular, saldo);
        this.limite = limite;

        if(limite > 0){
            this.limite = limite;
        }else{
            this.limite = 0;
        }
    }

    //Get
    public double getLimite(){
        return limite;
    }

    //Reescrita [Override] (POLIMORFISMO)
    @Override
    public boolean sacar(double valor){
        if(valor >= 0 && valor <= saldo + limite){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
}
