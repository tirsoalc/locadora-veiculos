package repository.cliente;

import model.cliente.Cliente;

import java.util.HashSet;

public interface ClienteRepositoryInterface <T extends Cliente>{
    void adicionarCliente(T cliente);
    void removerCliente(T cliente);
    T buscarCliente(String identificador);
    HashSet<T> getClientesCadastrados();
}
