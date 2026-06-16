package com.easy.eats.estoque.bst;

import com.easy.eats.estoque.model.Insumo;

public class ArvoreInsumos {

    private NoInsumo raiz;

    public void inserir(Insumo insumo) {
        raiz = inserirRecursivo(raiz, insumo);
    }

    private NoInsumo inserirRecursivo(NoInsumo atual, Insumo insumo) {

        if (atual == null) {
            return new NoInsumo(insumo);
        }

        if (insumo.getNome().compareToIgnoreCase(atual.insumo.getNome()) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, insumo);
        } else {
            atual.direita = inserirRecursivo(atual.direita, insumo);
        }

        return atual;
    }

    public Insumo buscar(String nome) {
        return buscarRecursivo(raiz, nome);
    }

    private Insumo buscarRecursivo(NoInsumo atual, String nome) {

        if (atual == null) {
            return null;
        }

        int comparacao =
                nome.compareToIgnoreCase(atual.insumo.getNome());

        if (comparacao == 0) {
            return atual.insumo;
        }

        if (comparacao < 0) {
            return buscarRecursivo(atual.esquerda, nome);
        }

        return buscarRecursivo(atual.direita, nome);
    }
}