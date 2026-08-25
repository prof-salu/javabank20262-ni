import java.util.Scanner;

public class App {
    public static void main(String args[]){
        System.out.println("Javabank 2026.2 - Terminal");
        int senhaOperador = 8888;

        Scanner entrada = new Scanner(System.in);

        for(int i = 1; i <= 3; i++){
            System.out.print("Informe a senha do operador: ");
            int senhaInformada = Integer.parseInt(entrada.nextLine());

            if(senhaInformada == senhaOperador){
                System.out.println("[Logado] Bem-vindo operador.");
            }else{
                System.out.println("[Falha] Senha inválida.");
            }
        }
    }
}