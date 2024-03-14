package view;

import controller.VeiculoController;
import model.veiculo.TipoVeiculo;
import model.veiculo.Veiculo;
import validador.Validador;
import view.utils.Inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractivityVeiculo {
    Scanner scanner = new Scanner(System.in);
    VeiculoController veiculoController;
    String opcaoInvalida = "\nOpção inválida selecionada. Pressione enter para continuar.";

    public InteractivityVeiculo(VeiculoController veiculoController) {
        this.veiculoController = veiculoController;
    }

    public String cadastrarVeiculo() {
        String marca = Inputs.inputHelper("Digite a marca do veículo: ", scanner);
        if (!Validador.nomeValido(marca)) {
            return "Por favor, não deixe a marca do veículo em branco.";
        }

        String modelo = Inputs.inputHelper("Digite o modelo do veículo: ", scanner);
        if (!Validador.nomeValido(modelo)) {
            return "Por favor, não deixe o modelo do veículo em branco.";
        }

        String placa = Inputs.inputHelper("Digite a placa do veículo: ", scanner);
        if (!Validador.placaValida(placa)) {
            return "Por favor, digite uma placa válida (Exemplo: ABC0123 ou ABC0D12)";
        }

        TipoVeiculo tipoVeiculo = tipoVeiculoOpcao();

        return veiculoController.cadastrarVeiculo(marca,modelo,placa,tipoVeiculo);
    }

    public TipoVeiculo tipoVeiculoOpcao() {
        int opcaoTipo = 0;
        do {
            Menus.showVeiculosTipoMenu();
            System.out.print("Selecione uma opção: ");

            try {
                opcaoTipo = scanner.nextInt();
                scanner.nextLine();

                if (!Validador.alcancePermitido(1,3,opcaoTipo)) {
                    System.out.print(opcaoInvalida);
                    scanner.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println(opcaoInvalida);
                scanner.nextLine();
            }

        } while (!Validador.alcancePermitido(1,3,opcaoTipo));

        return switch (opcaoTipo) {
            case 1 -> TipoVeiculo.PEQUENO;
            case 2 -> TipoVeiculo.MEDIO;
            case 3 -> TipoVeiculo.SUV;
            default -> throw new IllegalArgumentException("Tipo Inválido");
        };
    }

    public String alterarVeiculo() {
        String placaAtual = Inputs.inputHelper("Informe a placa do carro: ",scanner);
        if (!Validador.placaValida(placaAtual)) {
            return "Por favor, digite uma placa válida (Exemplo: ABC0123 ou ABC0D12)";
        }

        Veiculo veiculo = veiculoController.buscarVeiculo(placaAtual);
        if (veiculo == null) {
            return "Veículo não encontrado no sistema";
        }

        String marca = Inputs.inputHelper("Digite a marca do carro: ", scanner);
        String modelo = Inputs.inputHelper("Digite o modelo do carro: ", scanner);
        String placa = Inputs.inputHelper("Digite a placa do carro: ", scanner);
        TipoVeiculo tipoVeiculo = tipoVeiculoOpcao();
        if (!Validador.placaValida(placa)) {
            return "Por favor, digite uma placa válida (Exemplo: ABC0123 ou ABC0D12)";
        }

        if (!veiculoController.placaDisponivel(placa, veiculo)) {
            return "A placa digitada já está cadastrada para outro veículo";
        }

        return veiculoController.alterarVeiculo(veiculo,marca,modelo,placa,tipoVeiculo);
    }

    public String buscarVeiculo() {
        String placa = Inputs.inputHelper("Digite a placa do carro: ", scanner);
        if (!Validador.placaValida(placa)) {
            return "A placa informada não é válida";
        }
        Veiculo veiculo = veiculoController.buscarVeiculo(placa);
        if (veiculo == null) {
            return "Veículo não encontrado no sistema.";
        }
        return veiculo.mostrarInformacoes();
    }

}
