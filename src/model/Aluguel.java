package model;

import model.cliente.Cliente;
import model.veiculo.Veiculo;

public class Aluguel implements Identificavel{
    private static Integer idCounter = 1;
    private Integer idAluguel;
    private Veiculo veiculo;
    private Cliente cliente;
    private String dataAluguel;
    private String dataDevolucao;
    private double doubleValorDiaria;

    public Aluguel(Veiculo veiculo, Cliente cliente, String dataAluguel, String dataDevolucao, double doubleValorDiaria) {
        this.idAluguel = idCounter++;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.doubleValorDiaria = doubleValorDiaria;
    }

    @Override
    public Object getId() {
        return idAluguel;
    }
}
