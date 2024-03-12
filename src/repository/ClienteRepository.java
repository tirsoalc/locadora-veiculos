package repository;

import model.cliente.Cliente;

import java.util.HashSet;
import java.util.Iterator;

public class ClienteRepository<T extends Cliente> {
    private Database<T> clientesCadastrados = new Database<>();

    public void adicionarCliente(T cliente) {
        clientesCadastrados.adicionarItem(cliente);
    }

    public void removerCliente(T cliente) {
        clientesCadastrados.removerItem(cliente);
    }

    public T buscarCliente(String identificador) {
        return clientesCadastrados.buscarItem(identificador);
    }

    public HashSet<T> getClientesCadastrados() {
        return clientesCadastrados.getLista();
    }
}
