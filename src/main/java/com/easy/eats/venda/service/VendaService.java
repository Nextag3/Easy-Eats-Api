package com.easy.eats.venda.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easy.eats.itemVenda.model.ItemVenda;
import com.easy.eats.itemVenda.service.ItemVendaService;
import com.easy.eats.venda.model.Venda;
import com.easy.eats.venda.quicksort.ProdutoRanking;
import com.easy.eats.venda.quicksort.QuickSortProdutos;
import com.easy.eats.venda.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    VendaRepository repository;

    @Autowired
    ItemVendaService itemVendaService;

    public Venda salvar(Venda venda) {
        return repository.save(venda);
    }

    public List<Venda> listarTodos() {
        return repository.findAll();
    }

    public Optional<Venda> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public List<ProdutoRanking> rankingProdutos() {
        List<ItemVenda> itens = itemVendaService.listarTodos();

        Map<Integer, ProdutoRanking> mapa = new HashMap<>();

        for (ItemVenda item : itens) {
            if (item.getProduto() == null) continue;

            Integer idProduto = item.getProduto().getId();
            String nome = item.getProduto().getNome();

            if (mapa.containsKey(idProduto)) {
                ProdutoRanking ranking = mapa.get(idProduto);
                ranking.setQuantidadeVendida(ranking.getQuantidadeVendida() + item.getQuantidade());
                ranking.setFaturamentoTotal(ranking.getFaturamentoTotal() + item.getValor_total());
            } else {
                mapa.put(idProduto, new ProdutoRanking(nome, item.getQuantidade(), item.getValor_total()));
            }
        }

        List<ProdutoRanking> lista = new ArrayList<>(mapa.values());
        new QuickSortProdutos().ordenar(lista);
        return lista;
    }

}
