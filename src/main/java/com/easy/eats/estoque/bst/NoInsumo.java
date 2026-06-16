package com.easy.eats.estoque.bst;

import com.easy.eats.estoque.model.Insumo;

public class NoInsumo {

    Insumo insumo;
    NoInsumo esquerda;
    NoInsumo direita;

    public NoInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
}