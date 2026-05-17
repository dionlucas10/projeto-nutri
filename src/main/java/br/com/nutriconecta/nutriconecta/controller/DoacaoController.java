package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.enums.StatusDoacao;
import br.com.nutriconecta.nutriconecta.service.DoacaoService;
import br.com.nutriconecta.nutriconecta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doacoes")
@RequiredArgsConstructor
public class DoacaoController {

    private final DoacaoService doacaoService;
    private final UsuarioService usuarioService;

    @GetMapping
    public String raiz() {
        return "redirect:/doacoes/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("doacoes", doacaoService.listarTodas());
        return "doacoes/lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("doacao", new Doacao());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("statusList", StatusDoacao.values());
        return "doacoes/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Doacao doacao) {
        doacaoService.salvar(doacao);
        return "redirect:/doacoes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("doacao", doacaoService.buscarPorId(id));
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("statusList", StatusDoacao.values());
        return "doacoes/form";
    }

    @GetMapping("/cancelar/{id}")
    public String cancelar(@PathVariable Long id) {
        Doacao doacao = doacaoService.buscarPorId(id);
        if (doacao.getStatus() == StatusDoacao.ABERTA) {
            doacaoService.alterarStatus(id, StatusDoacao.CANCELADA);
        }
        return "redirect:/doacoes/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        doacaoService.deletar(id);
        return "redirect:/doacoes/listar";
    }
}