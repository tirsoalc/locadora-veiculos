package repository.aluguel;

import model.Aluguel;
import repository.db.Database;

import java.util.HashSet;

public class AluguelRepository implements AluguelRepositoryInterface {
    private Database<Aluguel> alugueisCadastrados = new Database<>();

    public void adicionarAluguel(Aluguel aluguel) {
        alugueisCadastrados.adicionarItem(aluguel);
    }

    public void removerAluguel(Aluguel aluguel) {
        alugueisCadastrados.removerItem(aluguel);
    }

    public Aluguel buscarAluguel(Integer id) {
        return alugueisCadastrados.buscarItem(id);
    }

    public HashSet<Aluguel> getAlugueisCadastrados() {
        return alugueisCadastrados.getLista();
    }
}
