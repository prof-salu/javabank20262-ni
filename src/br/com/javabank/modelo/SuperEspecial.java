package br.com.javabank.modelo;

//Filho concreto de Conta, deve reescrever o método sacar
public class SuperEspecial extends Especial{
    @Override
    public boolean sacar(double valor) {
        return false;
    }
}
