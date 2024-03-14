package view;

import controller.AluguelController;
import controller.ClienteController;
import controller.VeiculoController;
import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;
import repository.aluguel.AluguelRepository;
import repository.cliente.ClienteRepository;
import repository.veiculo.VeiculoRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interactivity {
    AluguelRepository aluguelRepository = new AluguelRepository();
    ClienteRepository<ClientePessoaFisica> pessoaFisicaRepository = new ClienteRepository<>();
    ClienteRepository<ClientePessoaJuridica> pessoaJuridicaRepository = new ClienteRepository<>();
    VeiculoRepository veiculoRepository = new VeiculoRepository();
    InteractivityCliente interactivityCliente;
    Scanner scanner = new Scanner(System.in);


    public Interactivity(InteractivityCliente interactivityCliente) {
        this.interactivityCliente = interactivityCliente;
    }

    String opcaoInvalida = "\nOpção inválida selecionada. Pressione enter para continuar.";

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
                        System.out.print(opcaoInvalida);
                        scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print(opcaoInvalida);
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
                System.out.print("\nPressione enter para continuar.");
                scanner.nextLine();
            }

        } while (menuOption != 3);
    }
}