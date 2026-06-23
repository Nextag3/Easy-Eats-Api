package com.easy.eats.estoque.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.easy.eats.estoque.model.Insumo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.easy.eats.estoque.service.EstoqueService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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
    @PutMapping("/atualizar/{nome}")
public String atualizar(
        @PathVariable String nome,
        @RequestBody Insumo insumo) {

    boolean atualizado =
            estoqueService.atualizarInsumo(nome, insumo);

    return atualizado
            ? "Insumo atualizado com sucesso!"
            : "Insumo não encontrado!";
}

@DeleteMapping("/remover/{nome}")
public String remover(@PathVariable String nome) {

    boolean removido =
            estoqueService.removerInsumo(nome);

    return removido
            ? "Insumo removido com sucesso!"
            : "Insumo não encontrado!";
}

}

