package model.cliente;

import model.veiculo.Veiculo;

import java.util.HashSet;

public interface Cliente {
    void adicionarVeiculoAlugado(Veiculo veiculo);
    void removerVeiculoAlugado(Veiculo veiculo);
    HashSet<Veiculo> verificarVeiculosAlugados();
    String mostrarInformacoes();
    void alterarInformacoes(String nome, String documento);
}
