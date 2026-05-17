package br.com.nutriconecta.nutriconecta.service.impl;

import br.com.nutriconecta.nutriconecta.model.Retirada;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import br.com.nutriconecta.nutriconecta.repository.RetiradaRepository;
import br.com.nutriconecta.nutriconecta.service.RetiradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public Retirada buscarPorId(Long id) {
        return retiradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Retirada não encontrada com id: " + id));
    }

    @Override
    public List<Retirada> listarTodas() {
        return retiradaRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        retiradaRepository.deleteById(id);
    }
}