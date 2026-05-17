package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.Usuario;
import br.com.nutriconecta.nutriconecta.model.enums.StatusDoacao;
import java.util.List;

public interface DoacaoService {

    long count();

    long totalAlimentosDistribuidos();

    Doacao salvar(Doacao doacao);

    Doacao buscarPorId(Long id);

    List<Doacao> listarTodas();

    List<Doacao> listarPorDoador(Usuario doador);

    void alterarStatus(Long id, StatusDoacao status);

    void deletar(Long id);
}