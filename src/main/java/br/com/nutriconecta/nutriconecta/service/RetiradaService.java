package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Retirada;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;

public interface RetiradaService {

    Retirada registrar(Retirada retirada);

    Retirada buscarPorSolicitacao(Solicitacao solicitacao);
}