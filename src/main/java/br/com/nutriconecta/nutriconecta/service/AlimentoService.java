package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Alimento;
import java.util.List;

public interface AlimentoService {

    Alimento salvar(Alimento alimento);

    List<Alimento> listarTodos();

    Alimento buscarPorId(Long id);

    void deletar(Long id);
}