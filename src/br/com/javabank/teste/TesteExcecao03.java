package br.com.javabank.teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesteExcecao03 {
    public static void main(String[] args) throws FileNotFoundException{
        File arquivo = new File("arquivo.txt");

        Scanner entrada = new Scanner(arquivo);

        System.out.println("Fim do programa");
    }
}
