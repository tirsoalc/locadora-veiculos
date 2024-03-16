package view;

import controller.input.MensagemSaidaErros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interactivity {
    InteractivityCliente interactivityCliente;
    InteractivityVeiculo interactivityVeiculo;
    InteractivityAluguel interactivityAluguel;
    Scanner scanner = new Scanner(System.in);

    public Interactivity(InteractivityCliente interactivityCliente, InteractivityVeiculo interactivityVeiculo, InteractivityAluguel interactivityAluguel) {
        this.interactivityCliente = interactivityCliente;
        this.interactivityVeiculo = interactivityVeiculo;
        this.interactivityAluguel = interactivityAluguel;
    }

    public void mainMenu() {
        int menuOption = 0;

        do {
            Menus.showMainMenu();
            System.out.print("Selecione uma opção: ");

            try {
                menuOption = scanner.nextInt();
                scanner.nextLine();

                switch (menuOption) {
                    case 1: //Veículos
                        veiculosMenu();
                        break;

                    case 2: //Clientes
                        clientesMenu();
                        break;

                    case 3: //Aluguéis
                        alugueisMenu();
                        break;

                    case 4: //Exit
                        System.out.println("\nAté mais!");
                        break;

                    default:
                        System.out.print(MensagemSaidaErros.OPCAO_INVALIDA.getMensagem());
                        scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print(MensagemSaidaErros.OPCAO_INVALIDA.getMensagem());
                scanner.nextLine();
            }

        } while (menuOption != 4);
    }

    public void veiculosMenu() {
        int menuOption;

        do {
            Menus.showVeiculosMenu();
            System.out.print("Selecione uma opção: ");

            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1: //Buscar veículo
                    System.out.println(interactivityVeiculo.buscarVeiculo());
                    break;

                case 2: //Cadastrar veículo
                    System.out.println(interactivityVeiculo.cadastrarVeiculo());
                    break;

                case 3: //Alterar veículo
                    System.out.println(interactivityVeiculo.alterarVeiculo());
                    break;

                case 4: //Voltar
                    break;

                default:
                    System.out.print("\nOpção inválida selecionada!");
            }

            if (menuOption != 4) {
                System.out.print("\nPressione enter para continuar.");
                scanner.nextLine();
            }

        } while (menuOption != 4);
    }

    public void clientesMenu() {
        int menuOption;

        do {
            Menus.showClientesMenu();
            System.out.print("Selecione uma opção: ");

            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1: //Buscar cliente
                    System.out.println(interactivityCliente.buscarCliente());
                    break;

                case 2: //Cadastrar cliente
                    System.out.println(interactivityCliente.cadastrarCliente());
                    break;

                case 3: //Alterar cliente
                    System.out.println(interactivityCliente.alterarCliente());
                    break;

                case 4: //Voltar
                    break;

                default:
                    System.out.print("\nOpção inválida selecionada!");
            }

            if (menuOption != 4) {
                System.out.print("\nPressione enter para continuar.");
                scanner.nextLine();
            }

        } while (menuOption != 4);
    }

    public void alugueisMenu() {
        int menuOption;

        do {
            Menus.showAlugueisMenu();
            System.out.print("Selecione uma opção: ");

            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1: //Alugar veículo
                    System.out.println(interactivityAluguel.alugarVeiculo());
                    break;

                case 2: //Devolver veículo
                    System.out.println(interactivityAluguel.devolverVeiculo());
                    break;

                case 3: //Voltar
                    break;

                default:
                    System.out.print("\nOpção inválida selecionada!");
            }

            if (menuOption != 3) {
                System.out.print("\nPressione enter para continuar.");
                scanner.nextLine();
            }

        } while (menuOption != 3);
    }
}