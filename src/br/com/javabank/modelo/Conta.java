package br.com.javabank.modelo;

import java.util.Objects;
//Classes abstratas não podem ser instanciadas
public abstract class Conta {
    //Modificadores de acesso
        //(~) default --> classes do mesmo pacote tem acesso aos membros
        //(+) public --> todas as classes do projeto tem acesso aos membros
        //(-) private --> apenas a propria classe tem acesso aos membros
        //(#) protected --> apenas classes filhas e do mesmo pacote tem acesso aos membros

    //O modificador FINAL indica que não pode ser alterado
    //Modificador FINAL aplicado em uma variavel, transforma em CONSTANTE
    //Constantes (final) por convenção são escritos em CAIXA_ALTA
    public static final String CODIGO_BANCO = "777";

    //Atributos (propriedades)
    private int numero;
    private String titular;
    protected double saldo;
    private boolean estaAtiva;
    private static int totalContasCriadas = 0;

    //Construtor --> Possui o mesmo nome da classe, deve ser publico (quase sempre) e pode possuir parâmetros
    //Sobrecarga de contrutores --> Classes com mais de 1 contrutor.

    public Conta(){
        //Construtor default (vazio) ==> nao possui parametros
        Conta.totalContasCriadas++;
    }

    public Conta(int numero, String titular, double saldo, boolean estaAtiva){
        //this --> aponta a propria classe
        this.numero = numero;
        setTitular(titular);
        this.saldo = saldo;
        this.estaAtiva = estaAtiva;
        Conta.totalContasCriadas++;
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
            //return false;
            throw new ValorInvalidoException();
        }
    }

    //Uma função abstrata deve ser reescrita por classe filha que não é abstrata
    public abstract boolean sacar(double valor);

    //O modificador FINAL aplicado a funções, indicam que a função não pode ser reescrita
    public final boolean transferencia(double valor, Conta favorecido){
        if(sacar(valor) == true){
            favorecido.depositar(valor);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        //Retorna a representação textual do objeto.
        return String.format("Número: %d | Titular: %s | Saldo: R$ %.2f", numero, titular, saldo);
    }

    //Define o critério de igualdade lógica entre dois objetos.
    @Override
    public boolean equals(Object obj) {
        //Verifica se a propria instancia esta se chamando
        if (this == obj){
            return true;
        }
        //Verifica se a instancia é nula ou não é um objeto do tipo Conta
        if(obj == null || obj instanceof Conta == false){
            return false;
        }
        //Converte o objeto para uma conta
        Conta outro = (Conta) obj;

        //Compara o número e o titular das contas
        if(outro.getNumero() == numero && outro.getTitular().equals(titular)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numero, this.titular);
    }

    // Método estático para consulta do totalizador global
    public static int getTotalContasCriadas() {
        return Conta.totalContasCriadas;
    }
}
