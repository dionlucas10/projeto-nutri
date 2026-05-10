package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.ItemDoacao;
import java.util.List;

public interface ItemDoacaoService {

    ItemDoacao salvar(ItemDoacao item);

    List<ItemDoacao> listarPorDoacao(Doacao doacao);
}