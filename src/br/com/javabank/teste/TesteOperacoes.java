package br.com.javabank.teste;

import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

public class TesteOperacoes {
    public static void main(String[] args) {
        //Contrutor com 4 parametros
        Conta c1 = new Corrente(1001, "Juca Pereira", 2000, 500);
        //Contrutor com 3 parametros
        Conta c2 = new Poupanca(1002, "Gigi", 100, 1);

        System.out.println("Saldo [c1]: " + c1.getSaldo());
        System.out.println("Saldo [c2]: " + c2.getSaldo());
        System.out.println("Transferência de 500 de c1 para c2.");
        c1.transferencia(500, c2);
        System.out.println("Saldo [c1]: " + c1.getSaldo());
        System.out.println("Saldo [c2]: " + c2.getSaldo());
    }
}
