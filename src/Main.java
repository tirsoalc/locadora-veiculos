import controller.ClienteController;
import model.cliente.Cliente;
import repository.cliente.ClienteRepository;
import repository.cliente.ClienteRepositoryInterface;
import view.Interactivity;
import view.InteractivityCliente;

public class Main {
    public static void main(String[] args) {
        ClienteRepositoryInterface<Cliente> clienteClienteRepositoryInterface = new ClienteRepository<>();
        ClienteController clienteController = new ClienteController(clienteClienteRepositoryInterface);
        InteractivityCliente interactivityCliente = new InteractivityCliente(clienteController);
        Interactivity interactivity = new Interactivity(interactivityCliente);
        interactivity.mainMenu();
    }
}