package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Retirada;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import java.util.List;

public interface RetiradaService {

    Retirada registrar(Retirada retirada);

    Retirada buscarPorSolicitacao(Solicitacao solicitacao);

    Retirada buscarPorId(Long id);

    List<Retirada> listarTodas();

    void deletar(Long id);
}