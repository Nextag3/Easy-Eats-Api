package com.easy.eats.itemVenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easy.eats.itemVenda.model.ItemVenda;
import com.easy.eats.itemVenda.repository.ItemVendaRepository;

@Service
public class ItemVendaService {

    @Autowired
    ItemVendaRepository repository;

    public List<ItemVenda> listarTodos() {
        return repository.findAll();
    }

}
