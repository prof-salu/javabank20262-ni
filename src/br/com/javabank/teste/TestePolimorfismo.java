package br.com.javabank.teste;

import br.com.javabank.modelo.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestePolimorfismo {
    public static void main(String[] args) {
        Corrente cc1 = new Corrente(1000, "Juca", 2500, 400);
        Poupanca cp1 = new Poupanca(1001, "Gisele", 5000, 1);

        Corrente cc2 = new Corrente(1000, "Juca", 2500, 400);
        Poupanca cp2 = null;

        SeguroDeVida s1 = new SeguroDeVida(50000);

        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();

        //Erro ao instanciar, CONTA é uma classe Abstrata
        //Conta conta = new Conta(1003, "Ana", 1000);

        System.out.println(cc1);
        System.out.println(cp1);


        System.out.println(cc1.equals(cp1)); //false
        System.out.println(cc1.equals(cc1)); //true
        System.out.println(cc1.equals(cc2)); //true
        System.out.println(cp1.equals(cp2)); //false

        System.out.println(cc1.hashCode());
        System.out.println(cc2.hashCode());
        System.out.println(cp1.hashCode());
        //System.out.println(cp2.hashCode()); //valor nulo (sem hash)

        System.out.println("Contas criadas: " + Conta.getTotalContasCriadas());

        List <Conta> lista = new ArrayList();
        Set<Conta> conjunto = new HashSet();

        lista.add(cc1);
        lista.add(cc2);
        lista.add(cp1);

        conjunto.add(cc1);
        conjunto.add(cc2);
        conjunto.add(cp1);

        System.out.println("Lista de contas");
        for(Conta conta : lista){
            System.out.println(conta);
        }
        System.out.println();
        System.out.println("Conjunto de contas");

        for(Conta conta : conjunto){
            System.out.println(conta);
        }

        calculadora.arrecadar(cc1);
        calculadora.arrecadar(s1);
        //calculadora.arrecadar(cp1); //Poupanca nao implementa tributavel

        System.out.println("Valor arrecadado: " + calculadora.getValorArrecadado());
    }
}
