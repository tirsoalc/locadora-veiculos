package factory;

import model.cliente.Cliente;
import model.cliente.ClientePessoaFisica;
import model.cliente.ClientePessoaJuridica;


import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ClienteFactory_EM_TESTE {
    private Map<String, Class <? extends Cliente>> listaTiposClientes = new HashMap<>();

    public ClienteFactory_EM_TESTE() {
        listaTiposClientes.put("PF", ClientePessoaFisica.class);
        listaTiposClientes.put("PJ", ClientePessoaJuridica.class);
    }

    public <T extends Cliente> T criarCliente(String tipo, String nome, String documento) {
        try {
            Class<? extends Cliente> classeAtual = listaTiposClientes.get(tipo.toUpperCase());
            Constructor<? extends Cliente> construtor = classeAtual.getDeclaredConstructor(String.class, String.class);
            Cliente cliente = construtor.newInstance(nome, documento);
            return (T) cliente;
        } catch (Exception e) {
            return null;
        }
    }
}
