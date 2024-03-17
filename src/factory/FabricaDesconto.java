package factory;

import controller.input.MensagemSaidaAluguel;
import controller.input.MensagemSaidaErros;
import model.cliente.Cliente;
import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;
import service.Desconto;
import service.DescontoPessoaFisica;
import service.DescontoPessoaJuridica;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FabricaDesconto {
    final private static Map<Class<? extends Cliente>, Class<? extends Desconto>> clientesDescontosMap = new HashMap<>();

    static {
        registrarClienteEDesconto(ClientePessoaFisica.class, DescontoPessoaFisica.class);
        registrarClienteEDesconto(ClientePessoaJuridica.class, DescontoPessoaJuridica.class);
    }

    public static void registrarClienteEDesconto(Class<? extends Cliente> classeSubtipoCliente, Class<? extends Desconto> classeSubtipoDesconto) {
        clientesDescontosMap.put(classeSubtipoCliente, classeSubtipoDesconto);
    }

    public static Desconto getDesconto(Cliente cliente) {
        Class<? extends Desconto> descontoClasse = clientesDescontosMap.get(cliente.getClass());
        if (descontoClasse != null) {
            try {
                return descontoClasse.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                System.out.println(MensagemSaidaErros.ERRO_INESPERADO + e.getMessage());
            }
        }
        throw new IllegalArgumentException(MensagemSaidaAluguel.DESCONTO_ERRO.getMensagem());
    }
}