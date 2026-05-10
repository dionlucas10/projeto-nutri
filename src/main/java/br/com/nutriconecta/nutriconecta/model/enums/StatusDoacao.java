package br.com.nutriconecta.nutriconecta.model.enums;

public enum StatusDoacao {

    ABERTA("ABERTA"),
    EM_ANDAMENTO("EM ANDAMENTO"),
    RESERVADA("RESERVADA"),
    CONCLUIDA("CONCLUIDA"),
    CANCELADA("CANCELADA");

    private final String descricao;

    StatusDoacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}