package model;

import repository.AluguelRepository;
import repository.ClienteRepository;
import repository.VeiculoRepository;

public class LocadoraVeiculo {
    AluguelRepository alugueis;
    ClienteRepository clientes;
    VeiculoRepository veiculos;

    public LocadoraVeiculo(AluguelRepository alugueis, ClienteRepository clientes, VeiculoRepository veiculos) {
        this.alugueis = alugueis;
        this.clientes = clientes;
        this.veiculos = veiculos;
    }
}
