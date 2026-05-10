package br.com.nutriconecta.nutriconecta.dto;

public class EstatisticasDTO {
    
    private Long totalUsuarios;
    private Long totalDoacoes;
    private Long totalSolicitacoes;
    private Long totalAlimentos;
    
    public EstatisticasDTO() {
    }
    
    public EstatisticasDTO(Long totalUsuarios, Long totalDoacoes, Long totalSolicitacoes, Long totalAlimentos) {
        this.totalUsuarios = totalUsuarios;
        this.totalDoacoes = totalDoacoes;
        this.totalSolicitacoes = totalSolicitacoes;
        this.totalAlimentos = totalAlimentos;
    }
    
    public Long getTotalUsuarios() {
        return totalUsuarios;
    }
    
    public void setTotalUsuarios(Long totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }
    
    public Long getTotalDoacoes() {
        return totalDoacoes;
    }
    
    public void setTotalDoacoes(Long totalDoacoes) {
        this.totalDoacoes = totalDoacoes;
    }
    
    public Long getTotalSolicitacoes() {
        return totalSolicitacoes;
    }
    
    public void setTotalSolicitacoes(Long totalSolicitacoes) {
        this.totalSolicitacoes = totalSolicitacoes;
    }
    
    public Long getTotalAlimentos() {
        return totalAlimentos;
    }
    
    public void setTotalAlimentos(Long totalAlimentos) {
        this.totalAlimentos = totalAlimentos;
    }
}
