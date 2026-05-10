package br.com.nutriconecta.nutriconecta.model;

import br.com.nutriconecta.nutriconecta.model.enums.StatusDoacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doacoes")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusDoacao status = StatusDoacao.ABERTA;

    private LocalDate dataExpiracao;

    @Column(nullable = false)
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "id_doador")
    private Usuario doador;
}