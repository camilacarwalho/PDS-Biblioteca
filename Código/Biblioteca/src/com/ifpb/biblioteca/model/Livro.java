package com.ifpb.biblioteca.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Camila
 *
 * O objeto do tipo Livro a ser cadastrado no sistema.
 */

//Rever status
//Editar toString
//rever getgenero(eduardo)

public class Livro implements Serializable {
    private String titulo;
    private int codigo;
    private Genero genero;
    private Autor autor;
    private String descricao;
    private boolean status;

    public Livro(String titulo, int codigo, Genero genero, Autor autor, String descricao) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.genero = genero;
        this.autor = autor;
        this.descricao = descricao;
        status = false;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutores(Autor autor) {
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

    public String isDisponivel(){
        if (!(status)){
            return "disponível";
        } else return "indisponível";
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
        String S="";
        if(status){
            S+="                INDISPONIVEL                \n";
        }
        return S+".-----------------------------------------.\n" +
                "Titulo:" + titulo + '\n'+
                "Codigo:" + codigo  + '\n'+
                "Genero:" + genero + '\n'+
                "Autor:"+ autor + '\n'+
                "Descrição:" + descricao + '\n'+
                "Status:" + isDisponivel()+ '\n'+
                ".-----------------------------------------.\n";
    }

}
