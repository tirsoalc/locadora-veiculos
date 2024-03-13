package model;

import model.cliente.Cliente;
import model.veiculo.Veiculo;

import java.util.Date;

public class Aluguel implements Identificavel{
    private static Integer idCounter = 1;
    private Integer idAluguel;
    private Veiculo veiculo;
    private Cliente cliente;
    private Date dataAluguel;
    private Date dataDevolucao;
    private double doubleValorDiaria;

    public Aluguel(Veiculo veiculo, Cliente cliente, Date dataAluguel, Date dataDevolucao, double doubleValorDiaria) {
        this.idAluguel = idCounter++;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.doubleValorDiaria = doubleValorDiaria;
    }

    @Override
    public String getId() {
        return String.valueOf(idAluguel);
    }
}
