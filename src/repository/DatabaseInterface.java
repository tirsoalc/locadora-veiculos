package repository;

import java.util.Set;

public interface DatabaseInterface<T>{
    void adicionarItem(T item);
    void removerItem(T item);
    T buscarItem(Object id);
    Set<T> getLista();
}
