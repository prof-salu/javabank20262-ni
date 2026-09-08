package br.com.javabank.modelo;

public class Conta {
    //Modificadores de acesso
        //default --> classes do mesmo pacote tem acesso aos membros
        //public --> todas as classes do projeto tem acesso aos membros
        //private --> apenas a propria classe tem acesso aos membros
        //protected --> apenas classes filhas e do mesmo pacote tem acesso aos membros

    //Atributos (propriedades)
    private int numero;
    private String titular;
    private double saldo;
    private boolean estaAtiva;

    //Construtor --> Possui o mesmo nome da classe, deve ser publico (quase sempre) e pode possuir parâmetros
    //Sobrecarga de contrutores --> Classes com mais de 1 contrutor.

    public Conta(){
        //Construtor default (vazio) ==> nao possui parametros
    }

    public Conta(int numero, String titular, double saldo, boolean estaAtiva){
        //this --> aponta a propria classe
        this.numero = numero;
        setTitular(titular);
        this.saldo = saldo;
        this.estaAtiva = estaAtiva;
    }

    public Conta(int numero, String titular, double saldo){
        this.numero = numero;
        this.saldo = saldo;
        setTitular(titular);
        this.estaAtiva = true;
    }

    //Encapsulamento (GET e SET)

    //Funções GET ==> retorna o valor de uma propriedade
    public int getNumero(){
        return numero;
    }

    public String getTitular(){
        return titular;
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean estaAtiva(){
        return estaAtiva;
    }

    //Funções SET ==> altera o valor de uma variavel

    public void setTitular(String titular){
        //trim() ==> remove espaços em branco do começo e do final da string
        if(titular.trim().length() >= 3){
            this.titular = titular.toUpperCase();
        }else{
            System.out.println("O nome deve possuir ao menos 3 caracteres");
        }
    }

    public void bloquearConta(){
        estaAtiva = false;
    }

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

    public boolean transferencia(double valor, Conta favorecido){
        if(sacar(valor) == true){
            favorecido.depositar(valor);
            return true;
        }else{
            return false;
        }
    }
}
