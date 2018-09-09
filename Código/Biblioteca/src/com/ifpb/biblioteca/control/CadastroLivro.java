package com.ifpb.biblioteca.control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;

import com.ifpb.biblioteca.model.*;


public class CadastroLivro {

    private Estante estante;

    public CadastroLivro() {
        estante = new Estante();
    }


    public Estante getEstante() {
        if (estante.isEmpty()){
            System.out.println("Não há livros cadastrados!!!");
        }
        return estante;
    }

    public boolean cadastrar(Livro novo) {
        estante.addLivro(novo);
        System.out.println("Livro cadastrado com sucesso!!!");
        return true;
    }


    public Livro consulta(int index) {
        if(index>estante.size()-1){
            return null;
        }
        return estante.selecionaIndex(index);
    }


    public boolean update(int index,Livro novo){
        if(index>estante.size()-1){
            return false;
        }
        estante.atualizar(index,novo);
        return true;
    }



    public boolean delete(int index){
        if(index>estante.size()-1){
            return false;
        }
        estante.removeLivro(index);
        return true;
    }

    @Override
    public String toString() {
        if(estante.isEmpty()){
            return "Não há livros cadastrados!";
        }
        String str = ":.:.:.:.:.:LIVROS:.:.:.:.:.:\n";
        List<Livro> livros = estante.getLivros();
        int cont = 0;
        for (Livro livro:livros) {
            cont++;
            str += cont+":    \n"+livro.toString();
        }
        return str;
    }
}


