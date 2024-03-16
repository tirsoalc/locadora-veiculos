package controller;

import model.Aluguel;
import model.cliente.Cliente;
import model.veiculo.Veiculo;
import repository.aluguel.AluguelRepositoryInterface;

import java.util.Date;

//Esta classe é responsável por controlar as operações de aluguel de veículos.
public class AluguelController {
    AluguelRepositoryInterface alugueis;

    public AluguelController(AluguelRepositoryInterface alugueis) {
        this.alugueis = alugueis;
    }

    //Este método é responsável por cadastrar um aluguel.
    public String alugarVeiculo(Cliente cliente, Veiculo veiculo, String local, Date dataAluguel, Date dataDevolucao) {


        Aluguel aluguel = new Aluguel(veiculo, cliente, local, dataAluguel, dataDevolucao);
        alugueis.adicionarAluguel(aluguel);

        return "Aluguel cadastrado com sucesso.";
    }

    //Este método é responsável por devolver um veículo.
    public static void devolverVeiculo() {
        // Aqui você pode adicionar a lógica para devolver um veículo.
        //System.out.println("Veículo devolvido com sucesso!");
    }
}
