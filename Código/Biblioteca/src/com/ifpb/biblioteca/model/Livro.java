package com.ifpb.biblioteca.model;

import java.util.Objects;

/**
 * @author Camila
 * O objeto do tipo Livro a ser cadastrado no sistema.
 */
//Rever status
//Editar toString
public class Livro {
    private String titulo;
    private int codigo;
    private String genero; //Passar para Enum?
    private String autor;
    private String descricao;
    private boolean status;


    public Livro(String titulo, int codigo, String genero, String autor, String descricao) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.genero = genero;
        this.autor = autor;
        this.descricao = descricao;
        this.status = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", codigo=" + codigo +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return codigo == livro.codigo;
    }

    @Override
    public int hashCode() {

        return Objects.hash(codigo);
    }
}
