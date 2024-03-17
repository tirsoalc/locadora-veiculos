package service;

import model.Aluguel;

public class Diarias {
    public int calculaDiarias(Aluguel aluguel){

        long diaEmMilli = (24 * 60 * 60 * 1000);
        long diferencaTotalMilli = Math.abs(aluguel.getDataDevolucao().getTime() - aluguel.getDataAluguel().getTime());

        int numDias = (int) (diferencaTotalMilli / diaEmMilli);
        //Millisegundo (ou minuto devido a estrutura) adicional deve somar como uma diária
        if (diferencaTotalMilli%diaEmMilli > 0)
            numDias++;

        return numDias;

    }
}