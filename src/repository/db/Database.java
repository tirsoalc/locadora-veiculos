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

//    public void buscarItem(String id) { }
//    public void buscarItem(Integer id) { }
//    // ou implementar uma lógica para transformar um param Object x -> String String.valueOf(x) com catch Exception{printStackTrace()}

    public T buscarItem(Object id) {
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
