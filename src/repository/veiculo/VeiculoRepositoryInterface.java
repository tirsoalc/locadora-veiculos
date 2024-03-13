package repository.veiculo;

import model.veiculo.Veiculo;

import java.util.HashSet;

public interface VeiculoRepositoryInterface {
    void adicionarVeiculo(Veiculo veiculo);
    void removerVeiculo(Veiculo veiculo);
    Veiculo buscarVeiculo(String placa);
    HashSet<Veiculo> getVeiculosCadastrados();
}
