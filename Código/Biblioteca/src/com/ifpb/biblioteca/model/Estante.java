package com.ifpb.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

//metodos atualizar e editar(eduardo)

public class Estante {
    private List<Livro> livros;

    public Estante() {
       livros = new ArrayList<Livro>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public boolean isEmpty(){
        return livros.isEmpty();
    }

    public int size(){
        return livros.size();
    }

    public void removeLivro(int index) {
        livros.remove(index);}

    public void editaLivro(Livro livro, int indice){
        livros.set(indice,livro);
    }

    public void atualizar(int index, Livro novo) {
        livros.set(index, novo);
    }

    public Livro selecionaIndex(int index){
        return livros.get(index);
    }

    @Override
    public String toString() {
        return "Estante{" +
                "livros=" + livros +
                '}';
    }
}
