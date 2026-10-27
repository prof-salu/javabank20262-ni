package br.com.javabank.teste;

public class GerarPDF extends Thread{

    public void montar(){
        for(int i = 0; i <= 100; i++){
            System.out.println("Montando o PDF: " + i + "%");
        }
    }

    @Override
    public void run() {
        montar();
    }
}
