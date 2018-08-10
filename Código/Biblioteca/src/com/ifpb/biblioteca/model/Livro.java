package com.ifpb.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
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
    private Genero genero;
    private String editora;
    private List<Autor> autores;
    private String descricao;
    private boolean status;



    public Livro(String titulo, int codigo, Genero genero, List<Autor> autores, String descricao) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.genero = genero;
        autores = new ArrayList<Autor>();
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    public void setGenero(int genero) {
        if (genero == Genero.ROMANCE.getID()) {
            setGenero(Genero.ROMANCE);
        } else if (genero == Genero.TERROR.getID()) {
            setGenero(Genero.TERROR);
        } else if (genero == Genero.POESIA.getID()) {
            setGenero(Genero.POESIA);
        } else if (genero == Genero.FANTASIA.getID()){
            setGenero(Genero.FANTASIA);
        } else if (genero == Genero.AVENTURA.getID()){
        setGenero(Genero.AVENTURA);
        } else if (genero == Genero.BIOGRAFIA.getID()){
        setGenero(Genero.BIOGRAFIA);
        } else if (genero == Genero.DIDATICO.getID()){
        setGenero(Genero.DIDATICO);
    }
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
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

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", codigo=" + codigo +
                ", genero=" + genero +
                ", editora='" + editora + '\'' +
                ", autores=" + autores +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                '}';
    }

}
