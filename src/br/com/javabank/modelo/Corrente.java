package br.com.javabank.modelo;

public class Corrente extends Conta implements Tributavel{
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

    @Override
    public String toString() {
        return super.toString() + String.format("| Limite: R$ %.2f | Saldo total: R$ %.2f",
                                                limite, getSaldo() + limite);
    }

    //ERRO (final), método não pode ser reescrito
    //public boolean transferencia(double valor, Conta favorecido){
      //  return true;
    //}


    @Override
    public double getValorImposto() {
        //2% do saldo atual da conta
        return getSaldo() * 0.02;
    }
}
