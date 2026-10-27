package br.com.javabank.teste;

public class TesteThreads01 {
    public static void main(String[] args) {
        MontarPlanilha planilha = new MontarPlanilha();
        GerarPDF pdf = new GerarPDF();

        Thread t1 = new Thread(planilha);
        Thread t2 = new Thread(pdf);

        t1.start();
        t1.start();
        t1.start();
        t1.start();
        t1.start();
        t1.start();
        t1.start();
        t1.start();
        t1.start();

        t2.start();
        t2.start();
        t2.start();
        t2.start();
        t2.start();
        t2.start();
        t2.start();
        t2.start();

    }
}
