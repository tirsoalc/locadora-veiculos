package model.veiculo;

public enum TipoVeiculo {
    PEQUENO(100),
    MEDIO(150),
    SUV(200);

    private final int valor;

    TipoVeiculo(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
