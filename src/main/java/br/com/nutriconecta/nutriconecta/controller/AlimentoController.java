package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Alimento;
import br.com.nutriconecta.nutriconecta.service.AlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alimentos")
@RequiredArgsConstructor
public class AlimentoController {

    private final AlimentoService alimentoService;

    @GetMapping
    public String raiz() {
        return "redirect:/alimentos/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alimentos", alimentoService.listarTodos());
        return "alimentos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("alimento", new Alimento());
        return "alimentos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Alimento alimento) {
        alimentoService.salvar(alimento);
        return "redirect:/alimentos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("alimento", alimentoService.buscarPorId(id));
        return "alimentos/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        alimentoService.deletar(id);
        return "redirect:/alimentos/listar";
    }
}