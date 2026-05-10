package br.com.nutriconecta.nutriconecta.dto;

import java.time.LocalDateTime;

public class SolicitacaoDTO {
    
    private Long id;
    private Long usuarioId;
    private String descricao;
    private LocalDateTime dataSolicitacao;
    private String status;
    
    public SolicitacaoDTO() {
    }
    
    public SolicitacaoDTO(Long id, Long usuarioId, String descricao, LocalDateTime dataSolicitacao, String status) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.descricao = descricao;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUsuarioId() {
        return usuarioId;
    }
    
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }
    
    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
