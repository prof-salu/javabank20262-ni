package br.com.javabank.teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesteExcecao02 {
    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt");
        //Exceção checked - obrigatoriedade no tratamento
        try{
            Scanner entrada = new Scanner(arquivo);
            String nome = null;
            //Lendo os dados do arquivo
            while(entrada.hasNext()){
                System.out.println(entrada.nextLine());
            }
            System.out.println(nome.toUpperCase());
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(NullPointerException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println("Fim do programa");
    }
}