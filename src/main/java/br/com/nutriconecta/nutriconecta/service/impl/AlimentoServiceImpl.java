package br.com.nutriconecta.nutriconecta.service.impl;

import br.com.nutriconecta.nutriconecta.model.Alimento;
import br.com.nutriconecta.nutriconecta.repository.AlimentoRepository;
import br.com.nutriconecta.nutriconecta.repository.ItemDoacaoRepository;
import br.com.nutriconecta.nutriconecta.service.AlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlimentoServiceImpl implements AlimentoService {

    private final AlimentoRepository alimentoRepository;
    private final ItemDoacaoRepository itemDoacaoRepository;

    @Override
    public Alimento salvar(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    @Override
    public List<Alimento> listarTodos() {
        return alimentoRepository.findAll();
    }

    @Override
    public Alimento buscarPorId(Long id) {
        return alimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alimento não encontrado com id: " + id));
    }

    @Override
    public void deletar(Long id) {
        Alimento alimento = buscarPorId(id);
        itemDoacaoRepository.deleteAll(itemDoacaoRepository.findByAlimento(alimento));
        alimentoRepository.deleteById(id);
    }
}