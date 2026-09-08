package br.com.javabank.teste;

import br.com.javabank.modelo.Conta;

import javax.swing.*;

public class TestaConta {
    public static void main(String[] args) {
        //Instanciação --> operador new
        Conta c1 = new Conta(1001, "juca", 1000, true); //nova instancia
        Conta c2 = new Conta(1002, "Gisele", 2000, true); //nova instancia
        Conta c3 = c1; // Aponta para o mesmo endereço de c1
        Conta c4 = new Conta(1002, "Gisele", 2000, true); //nova instancia

        //c1.numero = 1001;
        //c1.titular = "Juca";
        //c1.saldo = 1000;
        //c1.estaAtiva = true;

        //c2.numero = 1002;
        //c2.titular = "Gisele";
        //c2.saldo = 2000;
        //c2.estaAtiva = true;

        //c4.numero = 1002;
        //c4.titular = "Gisele";
        //c4.saldo = 2000;
        //c4.estaAtiva = true;

        System.out.println("Titular c1: " + c1.getTitular());
        System.out.println("Titular c2: " + c2.getTitular());
        System.out.println("Titular c3: " + c3.getTitular());

        System.out.println();
        c3.setTitular("X");
        c3.setTitular("  an");
        c3.setTitular("     ");
        c3.setTitular("Juca Pereira");

        System.out.println("Titular c1: " + c1.getTitular());
        System.out.println("Titular c2: " + c2.getTitular());
        System.out.println("Titular c3: " + c3.getTitular());

        System.out.println(c1); //hex referente a posição da memoria
        System.out.println(c2); //hex referente a posição da memoria
        System.out.println(c3); //hex referente a posição da memoria

        System.out.println("Saldo c1: " + c1.getSaldo());
        System.out.println("Saldo c2: " + c2.getSaldo());

        System.out.println(c2.getNumero() == c4.getNumero()); //true ==> compara os valores
        System.out.println(c2.getTitular() == c4.getTitular()); //true ==> compara os valores
        System.out.println(c2.getSaldo() == c4.getSaldo()); //true ==> compara os valores
        System.out.println(c2 == c4); //false ==> compara posição de memória

        System.out.println("Saldo ANTES do deposito [c4]: " + c4.getSaldo());
        c4.depositar(500);
        System.out.println("Saldo DEPOIS do deposito [c4]: " + c4.getSaldo());

        System.out.println("Saldo ANTES do saque [c4]: " + c4.getSaldo());
        c4.sacar(1100);
        c4.sacar(1400);
        c4.sacar(100);
        //c4.saldo = -1000;
        System.out.println("Saldo DEPOIS do saque [c4]: " + c4.getSaldo());

        //JOptionPane.showMessageDialog(null, "Seu saldo final: " + c4.getSaldo());
    }
}
