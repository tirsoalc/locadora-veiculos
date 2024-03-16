import controller.*;
import model.cliente.Cliente;
import repository.aluguel.*;
import repository.cliente.*;
import repository.veiculo.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        ClienteRepositoryInterface<Cliente> clienteClienteRepositoryInterface = new ClienteRepository<>();
        VeiculoRepositoryInterface veiculoRepositoryInterface = new VeiculoRepository();
        AluguelRepositoryInterface aluguelRepositoryInterface = new AluguelRepository();

        ClienteController clienteController = new ClienteController(clienteClienteRepositoryInterface);
        VeiculoController veiculoController = new VeiculoController(veiculoRepositoryInterface);
        AluguelController aluguelController = new AluguelController(aluguelRepositoryInterface);

        InteractivityCliente interactivityCliente = new InteractivityCliente(clienteController);
        InteractivityVeiculo interactivityVeiculo = new InteractivityVeiculo(veiculoController);
        InteractivityAluguel interactivityAluguel = new InteractivityAluguel(aluguelController);

        Interactivity interactivity = new Interactivity(interactivityCliente, interactivityVeiculo, interactivityAluguel);
        interactivity.mainMenu();
    }
}