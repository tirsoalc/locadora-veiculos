package model.cliente;

import model.Identificavel;

import java.util.Objects;

public class ClientePessoaFisica implements Cliente, Identificavel {

    private String nome;
    private String cpf;

    public ClientePessoaFisica(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String getId() {
        return cpf;
    }

    @Override
    public void alterarInformacoes(String nome, String documento) {
        this.nome = nome;
        this.cpf = documento;
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
    public String toString() {
        return "[nome:'" + nome + '\'' + ", CPF:'"+ cpf +'\''+']';
    }

    @Override
    public String mostrarInformacoes() {
        return "Cliente Pessoa Física: Nome = " + nome + ", CPF = " + cpf;
    }
}
