package model.veiculo;

import model.Identificavel;

import java.util.Objects;

public class Veiculo implements Identificavel {
    private String marca;
    private String modelo;
    private String placa;
    private TipoVeiculo tipoVeiculo;
    private boolean disponivel;

    public Veiculo(String marca, String modelo, String placa, TipoVeiculo tipoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public TipoVeiculo getTipo() {
        return tipoVeiculo;
    }

    @Override
    public String getId() {
        return placa;
    }

    public void alterarInformacoes(String marca, String modelo, String placa, TipoVeiculo tipoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return "[marca:'" + marca + '\''+", modelo:'"+modelo+'\''+", placa:'"+placa+'\''+']';
    }

    public String mostrarInformacoes() {
        return "Veículo: Marca = " + marca + ", Modelo = " + modelo + ", Placa: " + placa;
    }
}