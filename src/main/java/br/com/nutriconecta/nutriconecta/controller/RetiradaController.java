package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Retirada;
import br.com.nutriconecta.nutriconecta.service.RetiradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/retiradas")
@RequiredArgsConstructor
public class RetiradaController {

    private final RetiradaService retiradaService;

    @GetMapping
    public String raiz() {
        return "redirect:/retiradas/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("retiradas", retiradaService.listarTodas());
        return "retiradas/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("retirada", new Retirada());
        return "retiradas/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Retirada retirada) {
        retiradaService.registrar(retirada);
        return "redirect:/retiradas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("retirada", retiradaService.buscarPorId(id));
        return "retiradas/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        retiradaService.deletar(id);
        return "redirect:/retiradas/listar";
    }
}
