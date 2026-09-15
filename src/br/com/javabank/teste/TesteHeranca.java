package br.com.javabank.teste;

import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

public class TesteHeranca {
    public static void main(String[] args) {
        Corrente cc1 = new Corrente(1001, "Juca Pereira",
                                    2000, 500);
        Poupanca cp1 = new Poupanca(1002, "Ana Maria",
                                    1000, 1);

        System.out.println("Titular: " + cc1.getTitular());
        System.out.println("Número: " + cc1.getNumero());
        System.out.println("Saldo: R$" + cc1.getSaldo());
        System.out.println("Limite: R$" + cc1.getLimite());
        System.out.println();
        System.out.println("Titular: " + cp1.getTitular());
        System.out.println("Número: " + cp1.getNumero());
        System.out.println("Saldo: R$" + cp1.getSaldo());
        System.out.println("Rendimento: " + cp1.getTaxaRendimento() + "%");

        //Sacando valores da Conta Corrente
        System.out.println();
        System.out.println("Saldo [cc1]: R$" + cc1.getSaldo());
        System.out.println("Sacando R$ 2000,00");
        cc1.sacar(2000);
        System.out.println("Saldo [cc1]: R$" + cc1.getSaldo());
        System.out.println("Sacando R$ 300,00");
        cc1.transferencia(300, cp1);
        System.out.println("Saldo [cc1]: R$" + cc1.getSaldo());
        System.out.println("Sacando R$ 400,00");
        cc1.sacar(400);
        System.out.println("Saldo [cc1]: R$" + cc1.getSaldo());

        System.out.println("Sacando R$ 1200,00");
        cp1.sacar(1200);
        System.out.println("Saldo [cp1]: R$" + cp1.getSaldo());

        System.out.println("Rendendo juros");
        System.out.println("Saldo [cp1]: R$" + cp1.renderJuros());
    }
}
