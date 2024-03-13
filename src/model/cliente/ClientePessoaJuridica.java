package model.cliente;

import model.Identificavel;

import java.util.Objects;

public class ClientePessoaJuridica extends Cliente implements Identificavel {
    final private String cnpj;

    public ClientePessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    @Override
    public String getId() {
        return cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientePessoaJuridica that = (ClientePessoaJuridica) o;
        return Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public String toString() {
        return "[nome:'" + super.nome + '\'' + ", CNPJ:'"+ cnpj +'\''+']';
    }

}
