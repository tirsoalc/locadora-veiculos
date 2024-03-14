package view;

import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractivityCliente {
    static Scanner scanner = new Scanner(System.in);

    public static void cadastrarCliente() {
        int opcaoTipo = 0;

        do {
            System.out.println("""
                                    
                    Informe o tipo do cliente:
                    1 - Pessoa Física
                    2 - Pessoa jurídica
                    """);

            System.out.print("Selecione uma opção: ");

            try {
                opcaoTipo = scanner.nextInt();
                scanner.nextLine();

                if (opcaoTipo != 1 && opcaoTipo != 2) {
                    System.out.print(Interactivity.opcaoInvalida);
                    scanner.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println(Interactivity.opcaoInvalida);
                scanner.nextLine();
            }

        } while (opcaoTipo != 1 && opcaoTipo != 2);

        if (opcaoTipo == 1) cadastrarClientePF();
        else cadastrarClientePJ();

    }

    public static void cadastrarClientePF() {
        String nome;
        String cpf;

        System.out.print("\nDigite o nome: ");
        nome = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        cpf = scanner.nextLine();

        Interactivity.pessoaFisicaRepository.adicionarCliente(new ClientePessoaFisica(nome, cpf));
    }

    public static void cadastrarClientePJ() {
        String nome;
        String cnpj;

        System.out.print("\nDigite o nome: ");
        nome = scanner.nextLine();

        System.out.print("Digite o CNPJ: ");
        cnpj = scanner.nextLine();

        Interactivity.pessoaJuridicaRepository.adicionarCliente(new ClientePessoaJuridica(nome, cnpj));
    }

    public static void alterarCliente() {
    }

    public static void buscarCliente() {
    }
}




