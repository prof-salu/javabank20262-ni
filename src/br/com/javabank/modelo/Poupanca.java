package br.com.javabank.modelo;

//O modificador FINAL aplicado em classe faz com que a classe não posso ser extendida
public final class Poupanca extends Conta{
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

    @Override
    public String toString() {
        return super.toString() + String.format("| Taxa de rendimento: %.1f%%", taxaRendimento);
    }

    @Override
    public boolean sacar(double valor) {
        if(valor >= 0 && valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
}
