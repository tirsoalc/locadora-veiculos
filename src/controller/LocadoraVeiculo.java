package controller;

import model.cliente.Cliente;
import repository.aluguel.AluguelRepositoryInterface;
import repository.cliente.ClienteRepositoryInterface;
import repository.veiculo.VeiculoRepositoryInterface;

public class LocadoraVeiculo {
    private AluguelController aluguelController;
    private ClienteController clienteController;
    private VeiculoController veiculoController;

    public LocadoraVeiculo(AluguelController aluguelController, ClienteController clienteController, VeiculoController veiculoController) {
        this.aluguelController = aluguelController;
        this.clienteController = clienteController;
        this.veiculoController = veiculoController;
    }

}
