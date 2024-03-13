package repository.veiculo;

import model.veiculo.Veiculo;
import repository.db.Database;

import java.util.HashSet;

public class VeiculoRepository implements VeiculoRepositoryInterface{
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
