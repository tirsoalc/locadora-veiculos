package controller;

import model.cliente.Cliente;
import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;
import repository.cliente.ClienteRepositoryInterface;

//Esta classe é responsável por controlar as operações de clientes.
public class ClienteController {

    private ClienteRepositoryInterface<Cliente> clientes;

    //Construtor da classe ClienteController.
    public ClienteController(ClienteRepositoryInterface<Cliente> clientes) {
        this.clientes = clientes;
    }

    //Este método é responsável por cadastrar um cliente Pessoa Física.
    public String cadastrarClientePF(String nome, String cpf) {
        ClientePessoaFisica cliente = new ClientePessoaFisica(nome, cpf);
        return cadastrarClienteHelper(cliente, cpf);
    }

    //Este método é responsável por cadastrar um cliente Pessoa Jurídica.
    public String cadastrarClientePJ(String razaoSocial, String cnpj) {
        ClientePessoaJuridica cliente = new ClientePessoaJuridica(razaoSocial, cnpj);
        return cadastrarClienteHelper(cliente, cnpj);
    }

    //Este método auxiliar é responsável por validar os dados do cliente.
    public String cadastrarClienteHelper(Cliente cliente, String documento) {
        if (buscarCliente(documento) != null) {
            return "Cliente já está cadastrado no sistema.";
        }
        clientes.adicionarCliente(cliente);
        return "Cliente cadastrado com sucesso.";
    }

    //Este método é responsável por alterar as informações de um cliente.
    public String alterarCliente(Cliente cliente, String novoNome, String novoDocumento) {
        cliente.alterarInformacoes(novoNome, novoDocumento);
        return "Alteração realizada com sucesso.";
    }

    //Este método é responsável por buscar um cliente pelo documento.
    public Cliente buscarCliente(String documento) {
        return clientes.buscarCliente(documento);
    }

    //Este método verifica se um CPF/CNPJ está disponível.
    public boolean cpfCnpjDisponivel(String documento, Cliente clienteAtual) {
        Cliente clienteExistente = buscarCliente(documento);
        return clienteExistente == null || clienteExistente.equals(clienteAtual);
    }
}