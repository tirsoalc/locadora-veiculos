package repository.db;

import java.util.Set;

public interface DatabaseInterface<T>{
    void adicionarItem(T item);
    void removerItem(T item);
    T buscarItem(String id);
    Set<T> getLista();
}
