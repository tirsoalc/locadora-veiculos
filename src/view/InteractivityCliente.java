package view;

import controller.ClienteController;
import model.cliente.Cliente;
import validador.Validador;

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

    private String inputHelper(String textoOutput) {
        String dado;
        System.out.print("\n" + textoOutput);
        dado = scanner.nextLine();
        return dado;
    }

    public String cadastrarClientePF() {
        String nome = inputHelper("Digite o nome: ");
        if (!Validador.nomeValido(nome)) {
            return "Por favor, não deixe o nome do cliente em branco";
        }

        String cpf = inputHelper("Digite o CPF: ");
        if (!Validador.cpfValido(cpf)) {
            return "Por favor, digite um CPF válido (apenas 4 dígitos)";
        }

        return clienteController.cadastrarClientePF(nome, cpf);
    }

    public String cadastrarClientePJ() {

        String razaoSocial = inputHelper("Digite a razão social: ");
        if (!Validador.nomeValido(razaoSocial)) {
            return "Por favor, não deixe o nome do cliente em branco";
        }

        String cnpj = inputHelper("Digite o CNPJ: ");
        if (!Validador.cnpjValido(cnpj)) {
            return "Por favor, digite um CNPJ válido (Exemplo de formato válido: 0123/4)";
        }

        return clienteController.cadastrarClientePJ(razaoSocial, cnpj);
    }


    public String alterarCliente() {
        int opcaoTipoCliente = tipoClienteMenu();

        if (opcaoTipoCliente == 1) return alterarClientePF();
        if (opcaoTipoCliente == 2) return alterarClientePJ();
        return opcaoInvalida;
    }

    public String alterarClientePF() {
        String cpfAtual = inputHelper("Digite o CPF do cliente: ");
        if (!Validador.cpfValido(cpfAtual)) {
            return "Por favor, digite um CPF válido (apenas 4 dígitos numéricos)";
        }

        Cliente cliente = clienteController.buscarCliente(cpfAtual);
        if (cliente == null) {
            return "Cliente não encontrado no sistema.";
        }

        String nome = inputHelper("Digite o novo nome: ");
        String cpf = inputHelper("Digite o novo CPF: ");
        if (!Validador.cpfValido(cpf)) {
            return "Por favor, digite um CPF válido (apenas 4 dígitos numéricos)";
        }

        if (!clienteController.cpfCnpjDisponivel(cpf, cliente)) {
            return "O CPF digitado já está cadastrado para outro cliente.";
        }

        return clienteController.alterarCliente(cliente, nome, cpf);
    }

    public String alterarClientePJ() {
        String cnpjAtual = inputHelper("Digite o CNPJ do cliente: ");
        if (!Validador.cnpjValido(cnpjAtual)) {
            return "Por favor, digite um CNPJ válido (Exemplo de formato válido: 0123/4)";
        }

        Cliente cliente = clienteController.buscarCliente(cnpjAtual);
        if (cliente == null) {
            return "Cliente não encontrado no sistema.";
        }

        String razaoSocial = inputHelper("Digite a nova razão social: ");
        String cnpj = inputHelper("Digite o novo CNPJ: ");
        if (!Validador.cnpjValido(cnpj)) {
            return "Por favor, digite um CNPJ válido (Exemplo de formato válido: 0123/4)";
        }

        if (!clienteController.cpfCnpjDisponivel(cnpj, cliente)) {
            return "O CNPJ digitado já está cadastrado para outro cliente.";
        }


        return clienteController.alterarCliente(cliente, razaoSocial, cnpj);
    }


    public String buscarCliente() {
        String documento = inputHelper("Digite o documento do cliente: ");
        if (!Validador.cpfValido(documento) && !Validador.cnpjValido(documento)) {
            return "O documento informado não é válido";
        }
        Cliente cliente = clienteController.buscarCliente(documento);
        if (cliente == null) {
            return "Cliente não encontrado no sistema.";
        }
        return cliente.mostrarInformacoes();
    }
}




