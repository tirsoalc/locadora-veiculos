package view;

import controller.ClienteController;
import controller.input.InputController;
import controller.input.MensagemCadastroCliente;
import model.cliente.Cliente;
import validador.Validador;
import view.utils.Inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractivityCliente {
    Scanner scanner = new Scanner(System.in);
    ClienteController clienteController;


    public InteractivityCliente(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    String opcaoInvalida = "\nOpção inválida selecionada. Pressione enter para continuar.";

    public int tipoClienteMenu() {
        int opcaoTipo = 0;
        do {
            Menus.showClienteTipoMenu();
            System.out.print("Selecione uma opção: ");

            try {
                opcaoTipo = scanner.nextInt();
                scanner.nextLine();

                if (opcaoTipo != 1 && opcaoTipo != 2) {
                    System.out.print(opcaoInvalida);
                    scanner.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println(opcaoInvalida);
                scanner.nextLine();
            }

        } while (opcaoTipo != 1 && opcaoTipo != 2);
        return opcaoTipo;
    }

    public String cadastrarCliente() {
        int opcaoTipo = tipoClienteMenu();

        if (opcaoTipo == 1) return cadastrarClientePF();
        if (opcaoTipo == 2) return cadastrarClientePJ();
        return opcaoInvalida;
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
        int opcaoTipoCliente = tipoClienteMenu();
        if (opcaoTipoCliente == 1) return alterarClientePF();
        if (opcaoTipoCliente == 2) return alterarClientePJ();
        return opcaoInvalida;
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