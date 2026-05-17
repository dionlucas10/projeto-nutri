package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import br.com.nutriconecta.nutriconecta.model.Usuario;
import br.com.nutriconecta.nutriconecta.model.enums.StatusSolicitacao;
import java.util.List;

public interface SolicitacaoService {

    Solicitacao salvar(Solicitacao solicitacao);

    List<Solicitacao> listarTodas();

    Solicitacao buscarPorId(Long id);

    void deletar(Long id);

    List<Solicitacao> listarPorInstituicao(Usuario instituicao);

    List<Solicitacao> listarPorDoacao(Doacao doacao);

    Solicitacao alterarStatus(Long id, StatusSolicitacao status);
}