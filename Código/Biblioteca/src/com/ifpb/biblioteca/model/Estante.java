package com.ifpb.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Estante {
    private List<Livro> livros;

    public Estante(List<Livro> livros) {
       livros = new ArrayList<Livro>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Estante{" +
                "livros=" + livros +
                '}';
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void removeLivro(Livro livro) {
        livros.remove(livro);}

    public void editaLivro(Livro livro, int indice){
        livros.set(indice,livro);
    }
    //Sujeito a mudanças na segunda fase;

}
