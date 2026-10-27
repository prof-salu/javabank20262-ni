package br.com.javabank.teste;

import br.com.javabank.modelo.Corrente;

public class TesteThread02 {
    public static void main(String[] args) {
        Corrente c = new Corrente(1000, "Juca", 0, 0);

        System.out.println("Saldo inicial: " + c.getSaldo());

        // Criamos um array para guardar as threads e poder chamá-las no join()
        Thread[] threads = new Thread[50];

        for (int i = 0; i < 50; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    c.depositar(100);
                }
            });
            threads[i].start();
        }

        // Faz o main esperar todas as 50 threads terminarem a execução
        for (int i = 0; i < 50; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Agora sim, o saldo final estará correto (1000 + 50 * 100 = 6000)
        System.out.println("Saldo Final: " + c.getSaldo());
    }
}
