package br.com.nutriconecta.nutriconecta.service.impl;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.ItemDoacao;
import br.com.nutriconecta.nutriconecta.repository.ItemDoacaoRepository;
import br.com.nutriconecta.nutriconecta.service.ItemDoacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemDoacaoServiceImpl implements ItemDoacaoService {

    private final ItemDoacaoRepository itemDoacaoRepository;

    @Override
    public ItemDoacao salvar(ItemDoacao item) {
        return itemDoacaoRepository.save(item);
    }

    @Override
    public List<ItemDoacao> listarPorDoacao(Doacao doacao) {
        return itemDoacaoRepository.findByDoacao(doacao);
    }
}