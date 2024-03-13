package repository.cliente;

import model.cliente.Cliente;
import repository.db.Database;

import java.util.HashSet;

public class ClienteRepository<T extends Cliente> implements ClienteRepositoryInterface<T> {
    private Database<T> clientesCadastrados = new Database<>();

    @Override
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
