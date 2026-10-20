package br.com.javabank.teste;

import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;

public class TesteExcecao04 {
    public static void main(String[] args) {
        Conta c = new Corrente(1001, "Joao", 2000, 50);

        System.out.println("Inicio do programa.");
        System.out.println("Saldo: " + c.getSaldo());

        try {
            c.depositar(-300);
        } catch (Exception e) {
            System.out.println(e);;
        }

        System.out.println("Saldo: " + c.getSaldo());

        System.out.println("Fim do programa.");
    }
}
