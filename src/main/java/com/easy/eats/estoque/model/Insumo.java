package com.easy.eats.estoque.model;

public class Insumo {

    private String nome;
    private int quantidade;
    private String unidade;

    public Insumo() {
    }

    public Insumo(String nome, int quantidade, String unidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}