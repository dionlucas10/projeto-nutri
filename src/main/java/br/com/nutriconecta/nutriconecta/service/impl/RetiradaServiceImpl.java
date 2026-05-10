package br.com.nutriconecta.nutriconecta.service.impl;

import br.com.nutriconecta.nutriconecta.model.Retirada;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import br.com.nutriconecta.nutriconecta.repository.RetiradaRepository;
import br.com.nutriconecta.nutriconecta.service.RetiradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetiradaServiceImpl implements RetiradaService {

    private final RetiradaRepository retiradaRepository;

    @Override
    public Retirada registrar(Retirada retirada) {
        return retiradaRepository.save(retirada);
    }

    @Override
    public Retirada buscarPorSolicitacao(Solicitacao solicitacao) {
        return retiradaRepository.findBySolicitacao(solicitacao);
    }
}