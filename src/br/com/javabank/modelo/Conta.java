package br.com.javabank.modelo;

public class Conta {
    //Modificadores de acesso
        //default --> classes do mesmo pacote tem acesso aos membros
        //public --> todas as classes do projeto tem acesso aos membros
        //private --> apenas a propria classe tem acesso aos membros
        //protected --> apenas classes filhas e do mesmo pacote tem acesso aos membros
    public int numero;
    public String titular;
    public double saldo;
    public boolean estaAtiva;

    //Comportamentos
    public boolean depositar(double valor){
        if(valor >= 0){
            saldo += valor;
            return true;
        }else{
            return false;
        }
    }

    public boolean sacar(double valor){
        // && ==> and
        // || ==> or
        //  ! ==> not
        if(valor >= 0 && valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
}
