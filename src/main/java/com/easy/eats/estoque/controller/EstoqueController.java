package com.easy.eats.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.easy.eats.estoque.model.Insumo;
import com.easy.eats.estoque.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("/insumo")
    public String cadastrar(@RequestBody Insumo insumo) {

        estoqueService.cadastrarInsumo(insumo);

        return "Insumo cadastrado com sucesso!";
    }

    @GetMapping("/buscar/{nome}")
    public Insumo buscar(@PathVariable String nome) {
        return estoqueService.buscarInsumo(nome);
    }
}