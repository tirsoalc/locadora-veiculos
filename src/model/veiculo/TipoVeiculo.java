package model.veiculo;

/**
 * Esta enumeração representa os diferentes tipos de veículos.
 */
public enum TipoVeiculo {
    PEQUENO(100),  // Representa um veículo de tamanho pequeno.
    MEDIO(150),    // Representa um veículo de tamanho médio.
    SUV(200);      // Representa um veículo do tipo SUV.

    private final int valor;  // Valor associado ao tipo de veículo.

    /**
     * Construtor da enumeração TipoVeiculo.
     * @param valor Valor a ser associado ao tipo de veículo.
     */
    TipoVeiculo(int valor) {
        this.valor = valor;
    }

    /**
     * Este método retorna o valor associado ao tipo de veículo.
     * @return O valor do tipo de veículo.
     */
    public int getValor() {
        return valor;
    }
}
