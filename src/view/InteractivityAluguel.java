package view;

import controller.AluguelController;
import controller.ClienteController;
import controller.input.InputController;
import controller.input.MensagemCadastroAluguel;
import controller.input.MensagemCadastroCliente;
import controller.input.MensagemCadastroVeiculo;
import model.cliente.Cliente;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class InteractivityAluguel {
    Scanner scanner = new Scanner(System.in);
    AluguelController aluguelController;
    ClienteController clienteController;
    InteractivityCliente interactivityCliente;

    String opcaoInvalida = "\nOpção inválida selecionada. Pressione enter para continuar.";

    public InteractivityAluguel(AluguelController aluguelController) {
        this.aluguelController = aluguelController;
    }

    public String alugarVeiculo() {
        try {
            int opcaoTipoCliente = interactivityCliente.tipoClienteMenu();
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
                return opcaoInvalida;

            Cliente cliente = clienteController.buscarCliente(documento);
            if (cliente == null) {
                return MensagemCadastroCliente.CLIENTE_NAO_ENCONTRADO.getMensagem();
            }

            String placa = InputController.obterPlacaValida(
                    MensagemCadastroVeiculo.PLACA_CADASTRO.getMensagem(),
                    scanner);

            String local = InputController.obterLocalValidado(
                    MensagemCadastroAluguel.LOCAL_CADASTRO.getMensagem(),
                    scanner);

            Date dataAluguel = InputController.obterDataValidada(
                    MensagemCadastroAluguel.DATA_ALUGUEL.getMensagem(),
                    scanner);

            Date dataDevolucao = InputController.obterDataValidada(
                    MensagemCadastroAluguel.DATA_DEVOLUCAO.getMensagem(),
                    scanner);

            return aluguelController.alugarVeiculo(documento, placa, local, dataAluguel, dataDevolucao);
        } catch (IllegalArgumentException | ParseException e) {
            return e.getMessage();
        }
    }

    public String devolverVeiculo() {
        return "";
    }
}