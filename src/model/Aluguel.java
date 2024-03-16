package model;

import model.cliente.Cliente;
import model.veiculo.TipoVeiculo;
import model.veiculo.Veiculo;

import java.util.Date;
import java.util.Objects;

public class Aluguel implements Identificavel{
    private static Integer idCounter = 1;
    private Integer idAluguel;
    private Veiculo veiculo;
    private Cliente cliente;
    private String local;
    private Date dataAluguel;
    private Date dataDevolucao;
    private double doubleValorDiaria;
    private boolean aluguelAtivo = true;

    public Aluguel(Cliente cliente, Veiculo veiculo, String local, Date dataAluguel, Date dataDevolucao) {
        this.idAluguel = idCounter++;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.local = local;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.doubleValorDiaria = veiculo.getTipo().getValor();
    }

    @Override
    public String getId() {
        return String.valueOf(idAluguel);
    }

    public void setAluguelAtivo(boolean aluguelAtivo) {
        this.aluguelAtivo = aluguelAtivo;
    }

    public boolean isAluguelAtivo() {
        return aluguelAtivo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getDoubleValorDiaria() {
        return doubleValorDiaria;
    }
}