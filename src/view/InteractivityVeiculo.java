package view;

import controller.VeiculoController;
import controller.input.InputController;
import controller.input.MensagemSaidaVeiculo;
import controller.input.MensagemSaidaErros;
import model.veiculo.TipoVeiculo;
import model.veiculo.Veiculo;
import validador.Validador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractivityVeiculo {
    Scanner scanner = new Scanner(System.in);
    VeiculoController veiculoController;

    public InteractivityVeiculo(VeiculoController veiculoController) {
        this.veiculoController = veiculoController;
    }

    public String cadastrarVeiculo() {

        try {
            String marca = InputController.obterMarcaValida(
                    MensagemSaidaVeiculo.MARCA_CADASTRO.getMensagem(),
                    scanner
            );

            String modelo = InputController.obterModeloValido(
                    MensagemSaidaVeiculo.MODELO_CADASTRO.getMensagem(),
                    scanner
            );

            String placa = InputController.obterPlacaValida(
                    MensagemSaidaVeiculo.PLACA_CADASTRO.getMensagem(),
                    scanner
            );

            TipoVeiculo tipoVeiculo = tipoVeiculoOpcao();

            return veiculoController.cadastrarVeiculo(marca,modelo,placa,tipoVeiculo);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

    }

    public TipoVeiculo tipoVeiculoOpcao() {
        int opcaoTipo = 0;
        do {
            Menus.showVeiculosTipoMenu();
            System.out.print("Selecione uma opção: ");

            try {
                opcaoTipo = scanner.nextInt();
                scanner.nextLine();

                if (!Validador.alcanceOpcaoPermitida(1,3,opcaoTipo)) {
                    System.out.print(MensagemSaidaErros.OPCAO_INVALIDA.getMensagem());
                    scanner.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println(MensagemSaidaErros.OPCAO_INVALIDA.getMensagem());
                scanner.nextLine();
            }

        } while (!Validador.alcanceOpcaoPermitida(1,3,opcaoTipo));

        return switch (opcaoTipo) {
            case 1 -> TipoVeiculo.PEQUENO;
            case 2 -> TipoVeiculo.MEDIO;
            case 3 -> TipoVeiculo.SUV;
            default -> throw new IllegalArgumentException("Tipo Inválido");
        };
    }

    public String alterarVeiculo() {

        try {
            String placaAtual = InputController.obterPlacaValida(
                    MensagemSaidaVeiculo.PLACA_CADASTRO.getMensagem(),
                    scanner
            );

            Veiculo veiculo = veiculoController.buscarVeiculo(placaAtual);
            if (veiculo == null) {
                return "Veículo não encontrado no sistema";
            }

            String marca = InputController.obterMarcaValida(
                    MensagemSaidaVeiculo.MARCA_ALTERAR.getMensagem()
                    ,scanner
            );

            String modelo = InputController.obterModeloValido(
                    MensagemSaidaVeiculo.MODELO_ALTERAR.getMensagem()
                    ,scanner
            );

            String placa = InputController.obterPlacaValida(
                    MensagemSaidaVeiculo.PLACA_ALTERAR.getMensagem()
                    ,scanner
            );

            TipoVeiculo tipoVeiculo = tipoVeiculoOpcao();


            if (!veiculoController.placaDisponivel(placa, veiculo)) {
                return "A placa digitada já está cadastrada para outro veículo";
            }

            return veiculoController.alterarVeiculo(veiculo,marca,modelo,placa,tipoVeiculo);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

    }

    public String buscarVeiculo() {
        try {
            String placa = InputController.obterPlacaValida(
                    MensagemSaidaVeiculo.PLACA_CADASTRO.getMensagem()
                    ,scanner
            );

            Veiculo veiculo = veiculoController.buscarVeiculo(placa);
            if (veiculo == null) {
                return MensagemSaidaVeiculo.VEICULO_NAO_ENCONTRADO.getMensagem();
            }
            return veiculo.mostrarInformacoes();

        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
