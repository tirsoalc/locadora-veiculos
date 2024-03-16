package view;

import controller.AluguelController;
import controller.ClienteController;
import controller.VeiculoController;
import controller.input.*;
import model.cliente.Cliente;
import model.veiculo.Veiculo;
import view.utils.ClienteUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class InteractivityAluguel {
    Scanner scanner = new Scanner(System.in);
    AluguelController aluguelController;
    ClienteController clienteController;
    VeiculoController veiculoController;

    public InteractivityAluguel(AluguelController aluguelController,
                                VeiculoController veiculoController,
                                ClienteController clienteController) {

        this.aluguelController = aluguelController;
        this.veiculoController = veiculoController;
        this.clienteController = clienteController;
    }

    public String alugarVeiculo() {
        try {
            int opcaoTipoCliente = ClienteUtil.getTipoCliente(scanner);
            String documento;

            if (opcaoTipoCliente == 1)
                documento = InputController.obterCpfValidado(
                        MensagemCadastroCliente.CPF_CADASTRO.getMensagem(),
                        scanner);
            else if (opcaoTipoCliente == 2)
                documento = InputController.obterCnpjValidado(
                        MensagemCadastroCliente.CNPJ_CADASTRO.getMensagem(),
                        scanner);
            else
                return MensagemErros.OPCAO_INVALIDA.getMensagem();

            Cliente cliente = clienteController.buscarCliente(documento);
            if (cliente == null) {
                return MensagemCadastroCliente.CLIENTE_NAO_ENCONTRADO.getMensagem();
            }

            String placa = InputController.obterPlacaValida(
                    MensagemCadastroVeiculo.PLACA_CADASTRO.getMensagem(),
                    scanner);
            Veiculo veiculo = veiculoController.buscarVeiculo(placa);
            if (veiculo == null) {
                return MensagemCadastroVeiculo.VEICULO_NAO_ENCONTRADO.getMensagem();
            }

            String local = InputController.obterLocalValidado(
                    MensagemCadastroAluguel.LOCAL_CADASTRO.getMensagem(),
                    scanner);

            Date dataAluguel = InputController.obterDataValidada(
                    MensagemCadastroAluguel.DATA_ALUGUEL.getMensagem(),
                    scanner);

            Date dataDevolucao = InputController.obterDataValidada(
                    MensagemCadastroAluguel.DATA_DEVOLUCAO.getMensagem(),
                    scanner);

            return aluguelController.alugarVeiculo(cliente, veiculo, local, dataAluguel, dataDevolucao);
        } catch (IllegalArgumentException | ParseException e) {
            return e.getMessage();
        }
    }

    public String devolverVeiculo() {
        return "";
    }
}