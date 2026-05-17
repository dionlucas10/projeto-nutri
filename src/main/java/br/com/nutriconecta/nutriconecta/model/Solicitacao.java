package br.com.nutriconecta.nutriconecta.model;

import br.com.nutriconecta.nutriconecta.model.enums.StatusSolicitacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitacoes")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataSolicitacao = LocalDateTime.now();

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacao status = StatusSolicitacao.PENDENTE;

    @ManyToOne
    @JoinColumn(name = "id_doacao")
    private Doacao doacao;

    @ManyToOne
    @JoinColumn(name = "id_instituicao")
    private Usuario instituicao;
}