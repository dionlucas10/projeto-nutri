package br.com.nutriconecta.nutriconecta.model.enums;

public enum StatusSolicitacao {

    PENDENTE("PENDENTE"),
    APROVADA("APROVADA"),
    REJEITADA("REJEITADA"),
    CANCELADA("CANCELADA");

    private final String descricao;

    StatusSolicitacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}