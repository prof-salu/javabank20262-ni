package br.com.javabank.teste;

public class MontarPlanilha implements Runnable{
    public void montar(){
        for(int i = 0; i <= 100; i++){
            System.out.println("Gerando planilha: " + i + "%");
        }
    }

    @Override
    public void run() {
        montar();
    }
}
