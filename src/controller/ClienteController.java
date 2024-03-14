package controller;

import model.Identificavel;
import model.cliente.Cliente;
import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;
import repository.cliente.ClienteRepository;
import repository.cliente.ClienteRepositoryInterface;


public class ClienteController{

    private ClienteRepositoryInterface<Cliente> clientes;

    public ClienteController(ClienteRepositoryInterface<Cliente> clientes){
        this.clientes = clientes;
    }

    public String cadastrarClientePF(String nome, String cpf){
        ClientePessoaFisica cliente = new ClientePessoaFisica(nome, cpf);
        return cadastrarClienteHelper(cliente, cpf);
    }

    public String cadastrarClientePJ(String razaoSocial, String cnpj){
        ClientePessoaJuridica cliente = new ClientePessoaJuridica(razaoSocial, cnpj);
        return cadastrarClienteHelper(cliente, cnpj);
    }

    public String cadastrarClienteHelper(Cliente cliente, String documento) {
        if (buscarCliente(documento) != null) {
            return "Cliente já está cadastrado no sistema.";
        }
        clientes.adicionarCliente(cliente);
        return "Cliente cadastrado com sucesso.";
    }

    public String alterarCliente(Cliente cliente, String novoNome, String novoDocumento) {
        cliente.alterarInformacoes(novoNome,novoDocumento);
        return "Alteração realizada com sucesso.";
    }

    public Cliente buscarCliente(String documento){
        return clientes.buscarCliente(documento);
    }

    public boolean cpfCnpjDisponivel(String documento, Cliente clienteAtual) {
        Cliente clienteExistente = buscarCliente(documento);

        return clienteExistente == null || clienteExistente.equals(clienteAtual);
    }
}
