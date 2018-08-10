package com.ifpb.biblioteca.model;

import java.util.Objects;

public class Autor {
    private String nome;
    private int codAutor;

    public Autor(String nome, int codAutor) {
        this.nome = nome;
        this.codAutor = ++codAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return codAutor == autor.codAutor;
    }

    @Override
    public int hashCode() {

        return Objects.hash(codAutor);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", codAutor=" + codAutor +
                '}';
    }
}
