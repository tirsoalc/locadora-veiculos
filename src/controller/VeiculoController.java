package controller;

import model.veiculo.TipoVeiculo;
import model.veiculo.Veiculo;
import repository.veiculo.VeiculoRepositoryInterface;

//Esta classe é responsável por controlar as operações de veículos.
public class VeiculoController {
    VeiculoRepositoryInterface veiculos;

    public VeiculoController(VeiculoRepositoryInterface veiculos) {
        this.veiculos = veiculos;
    }

    //Este método é responsável por cadastrar um aluguel
    public String cadastrarVeiculo(String marca, String modelo, String placa, TipoVeiculo tipoVeiculo){
        Veiculo veiculo = new Veiculo(marca, modelo, placa, tipoVeiculo);
        if (buscarVeiculo(placa) != null) {
            return "O veículo já está cadastrado no sistema";
        }

        veiculos.adicionarVeiculo(veiculo);
        return "Veículo cadastrado com sucesso";
    }

    //Este método é responsável por alterar um veículo
    public String alterarVeiculo(Veiculo veiculo, String marca, String modelo, String placa, TipoVeiculo tipoVeiculo){
        veiculo.alterarInformacoes(marca,modelo,placa,tipoVeiculo);
        return "Alteração realizada com sucesso";
    }

    //Este método é responsável por buscar um veículo
    public Veiculo buscarVeiculo(String placa){
        return veiculos.buscarVeiculo(placa);
    }

    public boolean placaDisponivel(String placa, Veiculo veiculoAtual) {
        Veiculo veiculoExistente = buscarVeiculo(placa);

        return veiculoExistente == null || veiculoExistente.equals(veiculoAtual);
    }
}
