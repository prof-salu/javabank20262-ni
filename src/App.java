import java.util.Scanner;

public class App {
    public static void main(String args[]) {
        System.out.println("Javabank 2026.2 - Terminal");
        int senhaOperador = 8888;
        boolean operadorLogado = false;
        Scanner entrada = new Scanner(System.in);

        //Sistema de login
        for (int i = 1; i <= 3; i++) {
            System.out.print("Informe a senha do operador: ");
            int senhaInformada = Integer.parseInt(entrada.nextLine());

            if (senhaInformada == senhaOperador) {
                System.out.println("[Logado] Bem-vindo operador.");
                operadorLogado = true;
                break;
            } else {
                System.out.println("[Falha] Senha inválida.");
            }
        }

        if (operadorLogado == false) {
            System.out.println("[Bloqueado] Usuário bloqueado.");
        } else {
            int opcao = 0;
            int numeroConta = 0;
            String titular = "";
            double saldo = 0;
            boolean contaAtiva = false;

            do {
                System.out.println("--- OPERAÇÕES DO TERMINAL ---");
                System.out.println("1 - Criar/Abrir br.com.javabank.modelo.Conta de Cliente");
                System.out.println("2 - Consultar Saldo");
                System.out.println("3 - Realizar Depósito");
                System.out.println("4 - Realizar Saque");
                System.out.println("5 - Realizar Transferência");
                System.out.println("6 - Encerrar Caixa");

                System.out.print("Opção desejada: ");
                opcao = Integer.parseInt(entrada.nextLine());

                switch (opcao) {
                    case 1 -> {
                        System.out.println("*** Abertura de contas ***");
                        System.out.print("Informe o numero da nova conta: ");
                        numeroConta = Integer.parseInt(entrada.nextLine());
                        System.out.print("Informe o nome do titular: ");
                        titular = entrada.nextLine();

                        System.out.print("Informe o saldo da conta: ");
                        saldo = Double.parseDouble(entrada.nextLine());

                        while (saldo < 0) {
                            System.out.println("O saldo deve ser maior ou igual a ZERO!");
                            System.out.print("Informe o saldo da conta: ");
                            saldo = Double.parseDouble(entrada.nextLine());
                        }

                        System.out.println("br.com.javabank.modelo.Conta criado com sucesso!");
                        contaAtiva = true;
                    }
                    case 2 -> {
                        System.out.println("*** Consulta de saldo ***");
                        if (contaAtiva == true) {
                            //System.out.println("br.com.javabank.modelo.Conta: " + numeroConta +
                            //                   " | Titular: " + titular +
                            //                   " | Saldo: R$ " + saldo);

                            System.out.printf("br.com.javabank.modelo.Conta: %d | Titular: %s | Saldo: R$ %.2f\n",
                                                numeroConta, titular, saldo);
                        } else {
                            System.out.println("Nenhuma conta ativa.");
                        }
                    }
                    case 3 -> {
                        System.out.println("*** Efetuar Depósito ***");
                        //SOUT + TAB ==> System.out.println();
                        System.out.print("Informe o valor do deposito: ");
                        double valor = Double.parseDouble(entrada.nextLine());
                        while(valor <= 0){
                            System.out.println("Valor inválido. Apenas valores positivos!");
                            System.out.print("Informe o valor do deposito: ");
                            valor = Double.parseDouble(entrada.nextLine());
                        }
                        //saldo = saldo + valor;
                        saldo += valor;
                        System.out.println("Depositio efetuado com sucesso!");
                    }
                    case 4 -> {
                        System.out.println("*** Efetuar Saque ***");
                        System.out.print("Informe o valor do saque: ");

                        double valor = Double.parseDouble(entrada.nextLine());
                        while (valor <= 0) {
                            System.out.println("Valor inválido. Apenas valores positivos!");
                            System.out.print("Informe o valor do saque: ");
                            valor = Double.parseDouble(entrada.nextLine());
                        }
                        saldo -= valor;
                        System.out.println("Saque efetuado com sucesso!");
                    }
                    case 5 -> {
                        System.out.println("*** Efetuar Transferência ***");
                    }
                    case 6 -> {
                        System.out.println("[Deslogado] Fechando o caixa");
                        operadorLogado = false;
                    }
                    default -> {
                        System.out.println("[Erro] Opção inválida. tente novamente");
                    }
                }
            } while (opcao != 6);
            System.out.println("Fim do programa");
            entrada.close();
        }
    }
}