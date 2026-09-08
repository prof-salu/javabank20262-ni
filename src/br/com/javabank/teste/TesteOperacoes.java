package br.com.javabank.teste;

import br.com.javabank.modelo.Conta;

public class TesteOperacoes {
    public static void main(String[] args) {
        //Contrutor com 4 parametros
        Conta c1 = new Conta(1001, "Juca Pereira", 2000, true);
        //Contrutor com 3 parametros
        Conta c2 = new Conta(1002, "Gigi", 100);

        System.out.println("Saldo [c1]: " + c1.getSaldo());
        System.out.println("Saldo [c2]: " + c2.getSaldo());
        System.out.println("Transferência de 500 de c1 para c2.");
        c1.transferencia(500, c2);
        System.out.println("Saldo [c1]: " + c1.getSaldo());
        System.out.println("Saldo [c2]: " + c2.getSaldo());
    }
}
