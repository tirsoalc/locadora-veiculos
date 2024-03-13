package model.cliente;

import model.Identificavel;

import java.util.Objects;

public class ClientePessoaFisica extends Cliente implements Identificavel {
    final private String cpf;

    public ClientePessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientePessoaFisica that = (ClientePessoaFisica) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String getId() {
        return cpf;
    }

    @Override
    public String toString() {
        return "[nome:'" + super.nome + '\'' + ", CPF:'"+ cpf +'\''+']';
    }
}
