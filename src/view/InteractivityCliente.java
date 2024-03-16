package view;

import controller.ClienteController;
import controller.input.InputController;
import controller.input.MensagemCadastroCliente;
import controller.input.MensagemErros;
import model.cliente.Cliente;
import validador.Validador;
import view.utils.ClienteUtil;
import view.utils.Inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractivityCliente {
    Scanner scanner = new Scanner(System.in);
    ClienteController clienteController;

    public InteractivityCliente(ClienteController clienteController) {
        this.clienteController = clienteController;
    }


    public String cadastrarCliente() {
        int opcaoTipo = ClienteUtil.getTipoCliente(scanner);

        if (opcaoTipo == 1) return cadastrarClientePF();
        if (opcaoTipo == 2) return cadastrarClientePJ();
        return MensagemErros.OPCAO_INVALIDA.getMensagem();
    }

    public String cadastrarClientePF() {
        try {
            String nome = InputController.obterNomeValidado(
                    MensagemCadastroCliente.NOME_CADASTRO.getMensagem(),
                    scanner);

            String cpf = InputController.obterCpfValidado(
                    MensagemCadastroCliente.CPF_CADASTRO.getMensagem(),
                    scanner);

            return clienteController.cadastrarClientePF(nome, cpf);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String cadastrarClientePJ() {
        try {
            String razaoSocial = InputController.obterRazaoSocialValidada(
                    MensagemCadastroCliente.RAZAOSOCIAL_CADASTRO.getMensagem(),
                    scanner);

            String cnpj = InputController.obterCnpjValidado(
                    MensagemCadastroCliente.CNPJ_CADASTRO.getMensagem(),
                    scanner);

            return clienteController.cadastrarClientePJ(razaoSocial, cnpj);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String alterarCliente() {
        int opcaoTipoCliente = ClienteUtil.getTipoCliente(scanner);
        if (opcaoTipoCliente == 1) return alterarClientePF();
        if (opcaoTipoCliente == 2) return alterarClientePJ();
        return MensagemErros.OPCAO_INVALIDA.getMensagem();
    }

    public String alterarClientePF() {
        try {
            String cpfAtual = InputController.obterCpfValidado(
                    MensagemCadastroCliente.CPF_CADASTRO.getMensagem(),
                    scanner);

            Cliente cliente = clienteController.buscarCliente(cpfAtual);
            if (cliente == null) {
                return MensagemCadastroCliente.CLIENTE_NAO_ENCONTRADO.getMensagem();
            }

            String nome = Inputs.inputHelper(
                    MensagemCadastroCliente.NOME_ALTERAR.getMensagem(),
                    scanner);

            String cpf = Inputs.inputHelper(
                    MensagemCadastroCliente.CPF_ALTERAR.getMensagem(),
                    scanner);

            if (!clienteController.cpfCnpjDisponivel(cpf, cliente)) {
                return MensagemCadastroCliente.CPF_JA_EXISTENTE.getMensagem();
            }

            return clienteController.alterarCliente(cliente, nome, cpf);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String alterarClientePJ() {
        try {
            String cnpjAtual = InputController.obterCnpjValidado(
                    MensagemCadastroCliente.CNPJ_CADASTRO.getMensagem(),
                    scanner);

            Cliente cliente = clienteController.buscarCliente(cnpjAtual);
            if (cliente == null) {
                return MensagemCadastroCliente.CLIENTE_NAO_ENCONTRADO.getMensagem();
            }

            String razaoSocial = Inputs.inputHelper(
                    MensagemCadastroCliente.RAZAOSOCIAL_ALTERAR.getMensagem(),
                    scanner);

            String cnpj = Inputs.inputHelper(
                    MensagemCadastroCliente.CNPJ_ALTERAR.getMensagem(),
                    scanner);

            if (!clienteController.cpfCnpjDisponivel(cnpj, cliente)) {
                return MensagemCadastroCliente.CNPJ_JA_EXISTENTE.getMensagem();
            }
            return clienteController.alterarCliente(cliente, razaoSocial, cnpj);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String buscarCliente() {
        try {
            String documento = Inputs.inputHelper(
                    MensagemCadastroCliente.DOCUMENTO_CADASTRO.getMensagem(),
                    scanner);

            if (!Validador.cpfValido(documento) && !Validador.cnpjValido(documento)) {
                return MensagemCadastroCliente.DOCUMENTO_ERRO.getMensagem();
            }

            Cliente cliente = clienteController.buscarCliente(documento);

            if (cliente == null) {
                return MensagemCadastroCliente.CLIENTE_NAO_ENCONTRADO.getMensagem();
            }
            return cliente.mostrarInformacoes();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}