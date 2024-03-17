package repository.db;

import model.Identificavel;

import java.util.HashSet;

public class Database<T> implements DatabaseInterface<T> {
    private HashSet<T> lista = new HashSet<>();

    public void adicionarItem(T item) {
        lista.add(item);
    }

    public void removerItem(T item) {
        lista.remove(item);
    }

    public T buscarItem(String id) {
        try {
            for (T item : lista) {
                if (item instanceof Identificavel itemIdentificavel) {
                    if (itemIdentificavel.getId().equals(id)) {
                        return item;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Não foi possível realizar a procura com este identificador");
        }
        return null;
    }

    public HashSet<T> getLista() {
        return lista;
    }
}
