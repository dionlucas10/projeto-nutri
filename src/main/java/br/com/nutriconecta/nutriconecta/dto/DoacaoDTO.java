package br.com.nutriconecta.nutriconecta.dto;

import java.time.LocalDateTime;
import java.util.List;

public class DoacaoDTO {
    
    private Long id;
    private Long usuarioId;
    private LocalDateTime dataDoacao;
    private String status;
    private List<ItemDoacaoDTO> itens;
    
    public DoacaoDTO() {
    }
    
    public DoacaoDTO(Long id, Long usuarioId, LocalDateTime dataDoacao, String status) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.dataDoacao = dataDoacao;
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
    
    public LocalDateTime getDataDoacao() {
        return dataDoacao;
    }
    
    public void setDataDoacao(LocalDateTime dataDoacao) {
        this.dataDoacao = dataDoacao;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<ItemDoacaoDTO> getItens() {
        return itens;
    }
    
    public void setItens(List<ItemDoacaoDTO> itens) {
        this.itens = itens;
    }
}
