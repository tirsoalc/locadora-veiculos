package repository;

import model.veiculo.Veiculo;

import java.util.HashSet;

public class VeiculoRepository {
    private Database<Veiculo> veiculosCadastrados = new Database<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculosCadastrados.adicionarItem(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculosCadastrados.removerItem(veiculo);
    }

    public Veiculo buscarVeiculo(String placa) {
        return veiculosCadastrados.buscarItem(placa);
    }

    public HashSet<Veiculo> getVeiculosCadastrados() {
        return veiculosCadastrados.getLista();
    }
}
