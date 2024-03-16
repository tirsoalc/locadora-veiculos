package service;

import model.Aluguel;

public class Diarias {
    public int calculaDiarias(Aluguel aluguel){

        long difHoras = Math.abs(aluguel.getDataDevolucao().getTime() - aluguel.getDataAluguel().getTime()) / (60 * 60 * 1000);
        int numDias = Math.round((float) difHoras / 24);

        //Horas adicionais devem somar como uma diária
        if ((difHoras % 24) > 0)
            numDias++;

        return numDias;
    }
}