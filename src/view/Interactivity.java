package view;

import controller.AluguelController;
import controller.ClienteController;
import controller.VeiculoController;
import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;
import repository.AluguelRepository;
import repository.ClienteRepository;
import repository.VeiculoRepository;

import java.util.Scanner;

public class Interactivity {
    AluguelRepository aluguelRepository = new AluguelRepository();
    ClienteRepository<ClientePessoaFisica> pessoaFisicaRepository = new ClienteRepository<>();
    ClienteRepository<ClientePessoaJuridica> pessoaJuridicaRepository = new ClienteRepository<>();
    VeiculoRepository veiculoRepository = new VeiculoRepository();
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        int menuOption;

        do {
            Menus.showMainMenu();
            System.out.print("Selecione uma opção: ");

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
                    System.out.print("\nOpção inválida selecionada!");
            }
        } while (menuOption != 4);
    }

    public static void veiculosMenu() {
        int menuOption;

        do {
            Menus.showVeiculosMenu();
            System.out.print("Selecione uma opção: ");

            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1: //Buscar veículo
                    VeiculoController.buscarVeiculo();
                    break;

                case 2: //Cadastrar veículo
                    VeiculoController.cadastrarVeiculo();
                    break;

                case 3: //Alterar veículo
                    VeiculoController.alterarVeiculo();
                    break;

                case 4: //Voltar
                    break;

                default:
                    System.out.print("\nOpção inválida selecionada!");
            }

            if (menuOption != 4) {
                System.out.print("\nPressione enter para continuar");
                scanner.nextLine();
            }

        } while (menuOption != 4);
    }

    public static void clientesMenu() {
        int menuOption;

        do {
            Menus.showClientesMenu();
            System.out.print("Selecione uma opção: ");

            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1: //Buscar cliente
                    ClienteController.buscarCliente();
                    break;

                case 2: //Cadastrar cliente
                    ClienteController.cadastrarCliente();
                    break;

                case 3: //Alterar cliente
                    ClienteController.alterarCliente();
                    break;

                case 4: //Voltar
                    break;

                default:
                    System.out.print("\nOpção inválida selecionada!");
            }

            if (menuOption != 4) {
                System.out.print("\nPressione enter para continuar");
                scanner.nextLine();
            }

        } while (menuOption != 4);
    }

    public static void alugueisMenu() {
        int menuOption;

        do {
            Menus.showAlugueisMenu();
            System.out.print("Selecione uma opção: ");

            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1: //Alugar veículo
                    AluguelController.alugarVeiculo();
                    break;

                case 2: //Devolver veículo
                    AluguelController.devolverVeiculo();
                    break;

                case 3: //Voltar
                    break;

                default:
                    System.out.print("\nOpção inválida selecionada!");
            }

            if (menuOption != 3) {
                System.out.print("\nPressione enter para continuar");
                scanner.nextLine();
            }

        } while (menuOption != 3);
    }
}