import factory.ClienteFactory_EM_TESTE;
import model.Aluguel;
import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;
import model.veiculo.TipoVeiculo;
import model.veiculo.Veiculo;
import repository.aluguel.AluguelRepository;
import repository.cliente.ClienteRepository;
import repository.veiculo.VeiculoRepository;

import java.util.Date;

public class Testes {
    public static void main(String[] args) {
        AluguelRepository aluguelRepository = new AluguelRepository();
        ClienteRepository<ClientePessoaFisica> pessoaFisicaRepository = new ClienteRepository<>();
        ClienteRepository<ClientePessoaJuridica> pessoaJuridicaRepository = new ClienteRepository<>();
        VeiculoRepository veiculoRepository = new VeiculoRepository();

        Veiculo v1 = new Veiculo("Ford", "KA", "ASC9834", TipoVeiculo.MEDIO);
        Veiculo v2 = new Veiculo("Ford", "KA Copia", "ASC9834", TipoVeiculo.MEDIO);
        Veiculo v3 = new Veiculo("Ford", "Mustang", "ASC9844", TipoVeiculo.MEDIO);

        veiculoRepository.adicionarVeiculo(v1);
        veiculoRepository.adicionarVeiculo(v2);
        veiculoRepository.adicionarVeiculo(v3);
        System.out.println(veiculoRepository.buscarVeiculo("ASC9834"));
        System.out.println(veiculoRepository.getVeiculosCadastrados());

        pessoaFisicaRepository.adicionarCliente(new ClientePessoaFisica("Teste", "1923"));
        pessoaFisicaRepository.adicionarCliente(new ClientePessoaFisica("Teste Copia", "1923"));
        pessoaFisicaRepository.adicionarCliente(new ClientePessoaFisica("Teste3", "1234"));
        System.out.println(pessoaFisicaRepository.buscarCliente("1234"));
        System.out.println(pessoaFisicaRepository.getClientesCadastrados());

        pessoaJuridicaRepository.adicionarCliente(new ClientePessoaJuridica("Jur1", "1234"));
        pessoaJuridicaRepository.adicionarCliente(new ClientePessoaJuridica("Jur1 Copia", "1234"));
        pessoaJuridicaRepository.adicionarCliente(new ClientePessoaJuridica("Jur2", "1235"));
        System.out.println(pessoaJuridicaRepository.buscarCliente("1235"));
        System.out.println(pessoaJuridicaRepository.getClientesCadastrados());

        Aluguel aluguel1 = new Aluguel(v1,pessoaFisicaRepository.buscarCliente("1923"),new Date(20201993),new Date(20101995),200.0);
        Aluguel aluguel2 = new Aluguel(v1,pessoaFisicaRepository.buscarCliente("1923"),new Date(20201993),new Date(20101995),200.0);
        Aluguel aluguel3 = new Aluguel(v1,pessoaFisicaRepository.buscarCliente("1923"),new Date(20201993),new Date(20101995),200.0);
        aluguelRepository.adicionarAluguel(aluguel1);
        aluguelRepository.adicionarAluguel(aluguel2);
        aluguelRepository.adicionarAluguel(aluguel3);

        System.out.println(aluguel3.getId());
        System.out.println(aluguel1.getId());
        System.out.println(aluguel2.getId());

        ClienteFactory_EM_TESTE fabricaCliente = new ClienteFactory_EM_TESTE();
        System.out.println(fabricaCliente.criarCliente("PF", "Nome Teste", "1234").mostrarInformacoes());

        System.out.println(aluguelRepository.getAlugueisCadastrados());
    }
}
