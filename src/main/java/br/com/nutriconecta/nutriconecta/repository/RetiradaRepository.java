package br.com.nutriconecta.nutriconecta.repository;

import br.com.nutriconecta.nutriconecta.model.Retirada;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetiradaRepository extends JpaRepository<Retirada, Long> {

    Retirada findBySolicitacao(Solicitacao solicitacao);
}