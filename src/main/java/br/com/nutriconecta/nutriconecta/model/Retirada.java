package br.com.nutriconecta.nutriconecta.model;

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
@Table(name = "retiradas")
public class Retirada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataRetirada;
    private String responsavel;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @OneToOne
    @JoinColumn(name = "id_solicitacao")
    private Solicitacao solicitacao;
}