package repository.aluguel;

import model.Aluguel;

import java.util.HashSet;

public interface AluguelRepositoryInterface {
    void adicionarAluguel(Aluguel aluguel);
    void removerAluguel(Aluguel aluguel);
    Aluguel buscarAluguel(Integer id);
    HashSet<Aluguel> getAlugueisCadastrados();
}
