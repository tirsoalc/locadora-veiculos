import controller.AluguelController;
import controller.ClienteController;
import controller.VeiculoController;
import model.cliente.Cliente;
import repository.aluguel.AluguelRepository;
import repository.aluguel.AluguelRepositoryInterface;
import repository.cliente.ClienteRepository;
import repository.cliente.ClienteRepositoryInterface;
import repository.veiculo.VeiculoRepository;
import repository.veiculo.VeiculoRepositoryInterface;
import view.*;

public class Main {
    public static void main(String[] args) {
        ClienteRepositoryInterface<Cliente> clienteClienteRepositoryInterface = new ClienteRepository<>();
        VeiculoRepositoryInterface veiculoRepositoryInterface = new VeiculoRepository();
//        AluguelRepositoryInterface aluguelRepositoryInterface = new AluguelRepository();

        ClienteController clienteController = new ClienteController(clienteClienteRepositoryInterface);
        VeiculoController veiculoController = new VeiculoController(veiculoRepositoryInterface);
//        AluguelController aluguelController = new AluguelController(aluguelRepositoryInterface);
//        LocadoraVeiculo locadoraVeiculo = new LocadoraVeiculo();

        InteractivityCliente interactivityCliente = new InteractivityCliente(clienteController);
        InteractivityVeiculo interactivityVeiculo = new InteractivityVeiculo(veiculoController);
//        InteractivityAluguel interactivityAluguel = new InteractivityAluguel(aluguelController);
//        InteractivityLocadoraVeiculo interactivityLocadoraVeiculo = new InteractivityLocadoraVeiculo(locadoraVeiculo);
        Interactivity interactivity = new Interactivity(interactivityCliente, interactivityVeiculo);
        interactivity.mainMenu();
    }
}