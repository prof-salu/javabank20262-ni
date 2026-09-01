package br.com.javabank.teste;

import br.com.javabank.modelo.Conta;

import javax.swing.*;

public class TestaConta {
    public static void main(String[] args) {
        //Instanciação --> operador new
        Conta c1 = new Conta();
        Conta c2 = new Conta();
        Conta c3 = c1;
        Conta c4 = new Conta();

        c1.numero = 1001;
        c1.titular = "Juca";
        c1.saldo = 1000;
        c1.estaAtiva = true;

        c2.numero = 1002;
        c2.titular = "Gisele";
        c2.saldo = 2000;
        c2.estaAtiva = true;

        c4.numero = 1002;
        c4.titular = "Gisele";
        c4.saldo = 2000;
        c4.estaAtiva = true;

        System.out.println("Titular c1: " + c1.titular);
        System.out.println("Titular c2: " + c2.titular);
        System.out.println("Titular c3: " + c3.titular);

        System.out.println();
        c3.titular = "Ana";

        System.out.println("Titular c1: " + c1.titular);
        System.out.println("Titular c2: " + c2.titular);
        System.out.println("Titular c3: " + c3.titular);

        System.out.println(c1); //hex referente a posição da memoria
        System.out.println(c2); //hex referente a posição da memoria
        System.out.println(c3); //hex referente a posição da memoria

        System.out.println("Saldo c1: " + c1.saldo);
        System.out.println("Saldo c2: " + c2.saldo);

        System.out.println(c2.numero == c4.numero); //true ==> compara os valores
        System.out.println(c2.titular == c4.titular); //true ==> compara os valores
        System.out.println(c2.saldo == c4.saldo); //true ==> compara os valores
        System.out.println(c2 == c4); //false ==> compara posição de memória

        System.out.println("Saldo ANTES do deposito [c4]: " + c4.saldo);
        c4.depositar(500);
        System.out.println("Saldo DEPOIS do deposito [c4]: " + c4.saldo);

        System.out.println("Saldo ANTES do saque [c4]: " + c4.saldo);
        c4.sacar(1100);
        c4.sacar(1400);
        c4.sacar(100);
        System.out.println("Saldo DEPOIS do saque [c4]: " + c4.saldo);

        JOptionPane.showMessageDialog(null, "Seu saldo final: " + c4.saldo);
    }
}
