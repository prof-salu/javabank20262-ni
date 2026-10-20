package br.com.javabank.modelo;

//Not checked
public class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException(){
        super("Erro 1001: O valor deve ser um número inteiro positivo.");
    }
}
