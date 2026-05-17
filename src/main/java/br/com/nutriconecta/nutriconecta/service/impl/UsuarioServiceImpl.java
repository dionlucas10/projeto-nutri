package br.com.nutriconecta.nutriconecta.service.impl;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import br.com.nutriconecta.nutriconecta.model.Usuario;
import br.com.nutriconecta.nutriconecta.repository.UsuarioRepository;
import br.com.nutriconecta.nutriconecta.service.DoacaoService;
import br.com.nutriconecta.nutriconecta.service.SolicitacaoService;
import br.com.nutriconecta.nutriconecta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final DoacaoService doacaoService;
    private final SolicitacaoService solicitacaoService;

    @Override
    public long countInstituicoes() {
        return usuarioRepository.countInstituicoes();
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com email: " + email));
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        Usuario usuario = buscarPorId(id);

        List<Doacao> doacoes = doacaoService.listarPorDoador(usuario);
        doacoes.forEach(doacao -> {
            doacao.setDoador(null);
            doacaoService.salvar(doacao);
        });

        List<Solicitacao> solicitacoes = solicitacaoService.listarPorInstituicao(usuario);
        solicitacoes.forEach(solicitacao -> {
            solicitacao.setInstituicao(null);
            solicitacaoService.salvar(solicitacao);
        });

        usuarioRepository.deleteById(id);
    }
}