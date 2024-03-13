package model.cliente;

import model.Identificavel;

import java.util.Objects;

public class ClientePessoaJuridica implements Cliente, Identificavel {

    private String razaoSocial;
    private String cnpj;

    public ClientePessoaJuridica(String nome, String cnpj) {
        this.razaoSocial = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return razaoSocial;
    }

    public void setNome(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
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
        return "[Razão social:'" + razaoSocial + '\'' + ", CNPJ:'"+ cnpj +'\''+']';
    }

    @Override
    public String mostrarInformacoes() {
        return "Cliente Pessoa Jurídica: Razão Social = " + razaoSocial + ", CNPJ = " + cnpj;
    }
}
