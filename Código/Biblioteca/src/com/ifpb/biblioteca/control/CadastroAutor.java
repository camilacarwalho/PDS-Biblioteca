package com.ifpb.biblioteca.control;

import com.ifpb.biblioteca.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CadastroAutor {

    private List<Autor> autores;

    public CadastroAutor(){
        autores = new ArrayList<>();
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public boolean cadastrar(Autor novo) {
        if(autores.add(novo)){
        	System.out.println("Autor cadastrado com sucesso!!!");
        	return true;
        }
        System.out.println("Ocorreu algum erro ao tentar cadastrar, por favor, tente novamente.");
        return false;
    }


    public Autor consulta(int codAutor) {
        for (Autor autor: autores) {
            if(codAutor == autor.getCodAutor()){
                return autor;
            }
        }
        return null;
    }


    public boolean update(int index,Autor novo){
        if(index>autores.size()-1){
            return false;
        }
        autores.set(index,novo);
        return true;
    }


    public boolean delete(int index){
        if(index>autores.size()-1){
            return false;
        }
        autores.remove(index);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CadastroAutor that = (CadastroAutor) o;
        return Objects.equals(autores, that.autores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autores);
    }

    public String toString() {
        if(autores.isEmpty()){
            return "Não há Autores cadastrados!";
        }
        String str = ":.:.:.:.:.:Autores:.:.:.:.:.:\n";
        int cont = 0;
        for (Autor autor:autores) {
            cont++;
            str += cont+":    \n"+autor.toString();
        }
        return str;
    }

}


