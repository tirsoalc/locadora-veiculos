package model;

import model.cliente.Cliente;
import repository.aluguel.AluguelRepositoryInterface;
import repository.cliente.ClienteRepositoryInterface;
import repository.veiculo.VeiculoRepositoryInterface;

public class LocadoraVeiculo {
    AluguelRepositoryInterface alugueis;
    ClienteRepositoryInterface<Cliente> clientes;
    VeiculoRepositoryInterface veiculos;

    public LocadoraVeiculo(AluguelRepositoryInterface alugueis, ClienteRepositoryInterface<Cliente> clientes, VeiculoRepositoryInterface veiculos) {
        this.alugueis = alugueis;
        this.clientes = clientes;
        this.veiculos = veiculos;
    }
}
