package controller;

/**
 * Esta classe é responsável por controlar as operações de aluguel de veículos.
 */
public class AluguelController {

    /**
     * Este método é responsável por cadastrar um aluguel.
     * @return Uma string indicando o status do cadastro do aluguel.
     */
    public String cadastrarAluguel() {
        // Aqui você pode adicionar a lógica para cadastrar um aluguel.
        return "Aluguel cadastrado com sucesso!";
    }

    /**
     * Este método é responsável por alugar um veículo.
     */
    public static void alugarVeiculo() {
        // Aqui você pode adicionar a lógica para alugar um veículo.
        System.out.println("Veículo alugado com sucesso!");
    }

    /**
     * Este método é responsável por devolver um veículo.
     */
    public static void devolverVeiculo() {
        // Aqui você pode adicionar a lógica para devolver um veículo.
        System.out.println("Veículo devolvido com sucesso!");
    }
}
