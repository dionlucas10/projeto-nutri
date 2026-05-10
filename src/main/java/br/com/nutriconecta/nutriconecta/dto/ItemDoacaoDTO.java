package br.com.nutriconecta.nutriconecta.dto;

public class ItemDoacaoDTO {
    
    private Long id;
    private Long alimentoId;
    private Integer quantidade;
    private String unidade;
    
    public ItemDoacaoDTO() {
    }
    
    public ItemDoacaoDTO(Long id, Long alimentoId, Integer quantidade, String unidade) {
        this.id = id;
        this.alimentoId = alimentoId;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getAlimentoId() {
        return alimentoId;
    }
    
    public void setAlimentoId(Long alimentoId) {
        this.alimentoId = alimentoId;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getUnidade() {
        return unidade;
    }
    
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
