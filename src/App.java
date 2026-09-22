import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

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
            Poupanca c1 = new Poupanca(1000, "Carlos", 1000, 1);
            Conta c2 = null;

            do {
                System.out.println("--- OPERAÇÕES DO TERMINAL ---");
                System.out.println("1 - Criar/Abrir Conta de Cliente");
                System.out.println("2 - Consultar dados da conta");
                System.out.println("3 - Realizar Depósito");
                System.out.println("4 - Realizar Saque");
                System.out.println("5 - Realizar Transferência");
                System.out.println("6 - Aplicar Rendimento (Poupança)");
                System.out.println("7 - Encerrar Caixa");

                System.out.print("Opção desejada: ");
                opcao = Integer.parseInt(entrada.nextLine());

                switch (opcao) {
                    case 1 -> {
                        System.out.println("*** Abertura de contas ***");
                        System.out.println("Informe o tipo de conta:");
                        System.out.println("1- Conta Corrente");
                        System.out.println("2- Conta Poupança");
                        System.out.print("Tipo de conta: ");
                        int tipoConta = Integer.parseInt(entrada.nextLine());

                        System.out.print("Informe o numero da nova conta: ");
                        int numero = Integer.parseInt(entrada.nextLine());
                        System.out.print("Informe o nome do titular: ");
                        String titular = entrada.nextLine();

                        System.out.print("Informe o saldo da conta: ");
                        double saldo = Double.parseDouble(entrada.nextLine());

                        while (saldo < 0) {
                            System.out.println("O saldo deve ser maior ou igual a ZERO!");
                            System.out.print("Informe o saldo da conta: ");
                            saldo = Double.parseDouble(entrada.nextLine());
                        }

                        if(tipoConta == 1){
                            System.out.print("Informe o valor do limite da conta: ");
                            double limite = Double.parseDouble(entrada.nextLine());
                            c2 = new Corrente(numero, titular, saldo, limite);
                        }else if(tipoConta == 2){
                            System.out.print("Informe o valor da taxa de rendimento: ");
                            double taxa = Double.parseDouble(entrada.nextLine());
                            c2 = new Poupanca(numero, titular, saldo, taxa);
                        }
                        System.out.println("Conta criado com sucesso!");
                    }
                    case 2 -> {
                        System.out.println("*** Consulta de dados ***");
                        System.out.print("Informe o numero da conta: ");
                        int numeroConta = Integer.parseInt(entrada.nextLine());

                        if (c1.getNumero() == numeroConta) {
                            System.out.printf("Conta: %d | Titular: %s | Saldo: R$ %.2f | Taxa de rendimento: %.1f%% \n",
                                    c1.getNumero(), c1.getTitular(), c1.getSaldo(), c1.getTaxaRendimento());


                        } else if(c2 != null){
                            if(c2 instanceof Corrente && c2.getNumero() == numeroConta){
                                System.out.printf("Conta: %d | Titular: %s | Saldo Atual: R$ %.2f | Limite: R$ %.2f |Saldo + Limite: R$ %.2f\n",
                                        c2.getNumero(), c2.getTitular(), c2.getSaldo(), ((Corrente) c2).getLimite(), ((Corrente) c2).getLimite() + c2.getSaldo());
                            }else if (c2 instanceof Poupanca && c2.getNumero() == numeroConta){
                                System.out.printf("Conta: %d | Titular: %s | Saldo: R$ %.2f | Taxa de rendimento: %.1f%% \n",
                                        c2.getNumero(), c2.getTitular(), c2.getSaldo(), ((Poupanca) c2).getTaxaRendimento());
                            }
                        }else{
                            System.out.println("Conta não encontrada.");
                        }
                    }
                    case 3 -> {
                        System.out.println("*** Efetuar Depósito ***");

                        System.out.print("Informe o numero da conta: ");
                        int numeroConta = Integer.parseInt(entrada.nextLine());
                        System.out.print("Informe o valor do deposito: ");
                        double valor = Double.parseDouble(entrada.nextLine());

                        while(valor <= 0){
                            System.out.println("Valor inválido. Apenas valores positivos!");
                            System.out.print("Informe o valor do deposito: ");
                            valor = Double.parseDouble(entrada.nextLine());
                        }

                        if(c1.getNumero() == numeroConta){
                            c1.depositar(valor);
                        }else if(c2 != null && c2.getNumero() == numeroConta){
                            c2.depositar(valor);
                        }else {
                            System.out.println("Conta não encontrada.");
                        }

                        System.out.println("Deposito efetuado com sucesso!");
                    }
                    case 4 -> {
                        System.out.println("*** Efetuar Saque ***");

                        System.out.print("Informe o numero da conta: ");
                        int numeroConta = Integer.parseInt(entrada.nextLine());
                        System.out.print("Informe o valor do saque: ");
                        double valor = Double.parseDouble(entrada.nextLine());

                        while(valor <= 0){
                            System.out.println("Valor inválido. Apenas valores positivos!");
                            System.out.print("Informe o valor do saque: ");
                            valor = Double.parseDouble(entrada.nextLine());
                        }

                        if(c1.getNumero() == numeroConta){
                            if(c1.sacar(valor) == true){
                                System.out.println("Saque efetuado com sucesso!");
                            }else{
                                System.out.println("Saldo insuficiente");
                            }

                        }else if(c2 != null && c2.getNumero() == numeroConta){
                            if(c2.sacar(valor) == true){
                                System.out.println("Saque efetuado com sucesso!");
                            }else{
                                System.out.println("Saldo insuficiente");
                            }
                        }else {
                            System.out.println("Conta não encontrada.");
                        }
                    }
                    case 5 -> {
                        System.out.println("*** Efetuar Transferência ***");
                        double valor = 0;
                        System.out.print("Informe o numero da conta: ");
                        int numConta = Integer.parseInt(entrada.nextLine());

                        System.out.print("Informe o numero da conta do favorecido: ");
                        int favorecido = Integer.parseInt(entrada.nextLine());

                        do{
                            System.out.print("Informe o valor da transferência: ");
                            valor = Double.parseDouble(entrada.nextLine());
                        }while(valor <= 0);

                        if(c1 != null && c1.getNumero() == numConta){
                            if(c2 != null && c2.getNumero() == favorecido){
                                if(c1.transferencia(valor, c2) == true){
                                    System.out.println("Transferencia efetuado com sucesso!");
                                }else{
                                    System.out.println("Saldo insuficiente.");
                                }
                            }else{
                                System.out.println("Conta favorecido não encontrada.");
                            }

                        }else if(c2 != null && c2.getNumero() == numConta){
                            if(c1 != null && c1.getNumero() == favorecido){
                                if(c2.transferencia(valor, c1) == true){
                                    System.out.println("Transferencia efetuado com sucesso!");
                                }else{
                                    System.out.println("Saldo insuficiente.");
                                }
                            }else{
                                System.out.println("Conta favorecido não encontrada.");
                            }
                        }else {
                            System.out.println("Conta não encontrada.");
                        }
                    }

                    case 6 -> {
                        System.out.println("*** 6 - Aplicar Rendimento (Poupança) ***");
                        System.out.print("Informe o numero da conta: ");
                        int numeroConta = Integer.parseInt(entrada.nextLine());

                        if(numeroConta == c1.getNumero() && c1 instanceof Poupanca){
                            c1.depositar(((Poupanca) c1).renderJuros());
                            System.out.println("Valor do rendimento: " + ((Poupanca) c1).renderJuros());
                        }else{
                            System.out.println("A Conta informada não é poupança.");
                        }
                    }

                    case 7 -> {
                        System.out.println("[Deslogado] Fechando o caixa");
                        operadorLogado = false;
                    }
                    default -> {
                        System.out.println("[Erro] Opção inválida. tente novamente");
                    }
                }
            } while (opcao != 7);
            System.out.println("Fim do programa");
            entrada.close();
        }
    }
}