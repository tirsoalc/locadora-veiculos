package controller.input;

public enum MensagemSaidaCliente {
    NOME_CADASTRO("Digite o nome do cliente: "),
    NOME_ALTERAR("Digite o novo nome do cliente: "),
    NOME_ERRO("Por favor, não deixe o nome do cliente em branco"),

    RAZAOSOCIAL_CADASTRO("Digite a razão social do cliente: "),
    RAZAOSOCIAL_ALTERAR("Digite a nova razão social do cliente: "),
    RAZAOSOCIAL_ERRO("Por favor, não deixe o campo razão social do cliente em branco"),

    CPF_CADASTRO("Digite o CPF do cliente: "),
    CPF_ALTERAR("Digite o novo CPF do cliente: "),
    CPF_ERRO("Por favor, digite um CPF válido (Exemplo de formato válido: 0123)"),
    CPF_JA_EXISTENTE("O CPF digitado já está cadastrado para outro cliente."),


    CNPJ_CADASTRO("Digite o CNPJ do cliente: "),
    CNPJ_ALTERAR("Digite o novo CNPJ do cliente: "),
    CNPJ_ERRO("Por favor, digite um CNPJ válido (Exemplo de formato válido: 0123/4)"),
    CNPJ_JA_EXISTENTE("O CNPJ digitado já está cadastrado para outro cliente."),

    DOCUMENTO_CADASTRO("Digite o documento do cliente: "),
    DOCUMENTO_ERRO("O documento informado não é válido"),

    CLIENTE_NAO_ENCONTRADO("Cliente não encontrado no sistema");

    private final String mensagem;

    MensagemSaidaCliente(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
