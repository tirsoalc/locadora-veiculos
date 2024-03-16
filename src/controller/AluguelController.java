package controller;

import controller.input.MensagemSaidaAluguel;
import controller.input.MensagemSaidaErros;
import controller.input.MensagemSaidaVeiculo;
import model.Aluguel;
import model.cliente.Cliente;
import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;
import model.veiculo.Veiculo;
import repository.aluguel.AluguelRepositoryInterface;
import service.Desconto;
import service.DescontoPessoaFisica;
import service.DescontoPessoaJuridica;
import service.Diarias;

import java.util.Date;
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

        if (veiculo.isDisponivel()) {
            return MensagemSaidaVeiculo.VEICULO_INDISPONIVEL_DEVOLUCAO.getMensagem();
        }

        Aluguel aluguel = buscarAluguelPorVeiculo(veiculo);
        if (aluguel == null) {
            return MensagemSaidaErros.ERRO_INESPERADO.getMensagem();
        }

        double valorTotal = calcularValorTotal(aluguel);
        if (valorTotal == -1)
            return MensagemSaidaErros.ERRO_INESPERADO.getMensagem();

        aluguel.getCliente().removerVeiculoAlugado(veiculo);
        veiculo.setDisponivel(true);
        aluguel.setAluguelAtivo(false);

        return MensagemSaidaAluguel.DEVOLUCAO_SUCESSO.getMensagem() + " Valor: R$" + valorTotal;
    }

    public AluguelRepositoryInterface getAlugueis() {
        return alugueis;
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

    public double calcularValorTotal(Aluguel aluguel) {

        Diarias diarias = new Diarias();
        int numDiarias = diarias.calculaDiarias(aluguel);

        Desconto desconto;
        if (aluguel.getCliente() instanceof ClientePessoaFisica) desconto = new DescontoPessoaFisica();
        else if (aluguel.getCliente() instanceof ClientePessoaJuridica) desconto = new DescontoPessoaJuridica();
        else return -1;

        double valorTotal = numDiarias * aluguel.getDoubleValorDiaria();
        valorTotal = valorTotal - (valorTotal * desconto.obterDesconto(numDiarias));

        return valorTotal;
    }
}