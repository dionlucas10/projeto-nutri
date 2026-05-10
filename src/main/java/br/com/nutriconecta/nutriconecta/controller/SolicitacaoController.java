package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import br.com.nutriconecta.nutriconecta.model.enums.StatusSolicitacao;
import br.com.nutriconecta.nutriconecta.service.DoacaoService;
import br.com.nutriconecta.nutriconecta.service.SolicitacaoService;
import br.com.nutriconecta.nutriconecta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/solicitacoes")
@RequiredArgsConstructor
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;
    private final DoacaoService doacaoService;
    private final UsuarioService usuarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("solicitacoes", solicitacaoService.listarTodas());
        return "solicitacoes/lista";
    }

    @GetMapping({"/nova", "/novo"})
    public String nova(Model model) {
        model.addAttribute("solicitacao", new Solicitacao());
        model.addAttribute("doacoes", doacaoService.listarTodas());
        model.addAttribute("instituicoes", usuarioService.listarTodos());
        return "solicitacoes/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Solicitacao solicitacao) {
        solicitacaoService.salvar(solicitacao);
        return "redirect:/solicitacoes/listar";
    }

    @GetMapping("/aprovar/{id}")
    public String aprovar(@PathVariable Long id) {
        solicitacaoService.alterarStatus(id, StatusSolicitacao.APROVADA);
        return "redirect:/solicitacoes/listar";
    }

    @GetMapping("/rejeitar/{id}")
    public String rejeitar(@PathVariable Long id) {
        solicitacaoService.alterarStatus(id, StatusSolicitacao.REJEITADA);
        return "redirect:/solicitacoes/listar";
    }
}