package controller;

import controller.input.MensagemSaidaAluguel;
import controller.input.MensagemSaidaVeiculo;
import model.Aluguel;
import model.cliente.Cliente;
import model.veiculo.Veiculo;
import repository.aluguel.AluguelRepositoryInterface;
import service.Desconto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//Esta classe é responsável por controlar as operações de aluguel de veículos.
public class AluguelController {
    AluguelRepositoryInterface alugueis;


    public AluguelController(AluguelRepositoryInterface alugueis) {
        this.alugueis = alugueis;
    }

    //Este método é responsável por cadastrar um aluguel.
    public String alugarVeiculo(Cliente cliente, Veiculo veiculo, String local, Date dataAluguel, Date dataDevolucao) {

        if (!veiculo.isDisponivel()) {
            return MensagemSaidaVeiculo.VEICULO_INDISPONIVEL_LOCACAO.getMensagem();
        }

        Aluguel aluguel = new Aluguel(cliente, veiculo, local, dataAluguel, dataDevolucao);
        alugueis.adicionarAluguel(aluguel);
        cliente.adicionarVeiculoAlugado(veiculo);
        veiculo.setDisponivel(false);

        return MensagemSaidaAluguel.CADASTRO_SUCESSO.getMensagem();
    }

    //Este método é responsável por devolver um veículo.
    public String devolverVeiculo(Veiculo veiculo) {
        // Aqui você pode adicionar a lógica para devolver um veículo.
        //System.out.println("Veículo devolvido com sucesso!");

        if (veiculo.isDisponivel()) {
            return MensagemSaidaVeiculo.VEICULO_INDISPONIVEL_DEVOLUCAO.getMensagem();
        }

        Aluguel aluguel = buscarAluguelPorVeiculo(veiculo);
        if (aluguel == null) {
            return "Um erro inesperado foi encontrado";
        }
        aluguel.getCliente().removerVeiculoAlugado(veiculo);
        veiculo.setDisponivel(true);
        aluguel.setAluguelAtivo(false);

        Desconto desconto;// Completar o método para informar o custo ao cliente

        return MensagemSaidaAluguel.DEVOLUCAO_SUCESSO.getMensagem() + "valor: " + aluguel.getDoubleValorDiaria(); //PLACEHOLDER;

    }

    public List<Aluguel> alugueisAtivos(AluguelRepositoryInterface alugueis) {
        return alugueis.getAlugueisCadastrados().stream()
                .filter(Aluguel::isAluguelAtivo)
                .collect(Collectors.toList());
    }

    public Aluguel buscarAluguelPorVeiculo(Veiculo veiculo) {
        for (Aluguel aluguelAtual : this.alugueisAtivos(this.alugueis)) {
            if (aluguelAtual.getVeiculo() == veiculo) {
                return aluguelAtual;
            }
        }
        return null;
    }

    public double calcularValorTotal(Desconto desconto) {
        //Completar o método e completar também as classes desconto
        return 0.0;
    }
}
