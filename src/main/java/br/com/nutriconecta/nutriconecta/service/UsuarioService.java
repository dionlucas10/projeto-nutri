package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Usuario;
import java.util.List;

public interface UsuarioService {

    long countInstituicoes();

    Usuario salvar(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario buscarPorEmail(String email);

    List<Usuario> listarTodos();

    void deletar(Long id);
}