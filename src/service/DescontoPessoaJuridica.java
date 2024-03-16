package service;

public class DescontoPessoaJuridica implements Desconto{
    @Override
    public double obterDesconto(int numDiarias) {
        if (numDiarias > 3)
            return 0.1;
        return 0.0;
    }
}