package service;

public class DescontoPessoaFisica implements Desconto{
    @Override
    public double obterDesconto(int numDiarias) {
        if (numDiarias > 5)
            return 0.05;
        return 0.0;
    }
}