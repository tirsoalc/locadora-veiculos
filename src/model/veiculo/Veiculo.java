package model.veiculo;

import model.Identificavel;

import java.util.Objects;

public class Veiculo implements Identificavel {
    private String marca;
    private String modelo;
    private String placa;
    private TipoVeiculo tipoVeiculo;

    public Veiculo(String marca, String modelo, String placa, TipoVeiculo tipoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public Object getId() {
        return placa;
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
}
