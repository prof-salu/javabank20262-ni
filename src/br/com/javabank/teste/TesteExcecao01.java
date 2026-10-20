package br.com.javabank.teste;

import java.util.Scanner;

public class TesteExcecao01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Inicio do programa.");

        System.out.print("Informe um numero inteiro: ");
        //Tratamento de exceções
        //Exceção not checked (não checada) sem obrigação de tratar
        try{
        //Tenta executar o código "problemático".
        // Caso ocorra uma exceção, envia para o bloco catch.
            int numero = Integer.parseInt(entrada.nextLine());
        }catch(Exception e){
            //Bloco onde devemos tratar a exceção
            System.out.println("O valor digitado deve ser um numero inteiro");
            System.out.print("Informe um numero inteiro: ");
            int numero = Integer.parseInt(entrada.nextLine());
        }finally{
            //Bloco opcional
            //O bloco finally sempre sera executado.
            System.out.println("Fim do programa.");
        }
    }
}
