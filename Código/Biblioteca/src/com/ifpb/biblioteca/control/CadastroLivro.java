package com.ifpb.biblioteca.control;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.ifpb.biblioteca.exceptions.LivroExistenteException;
import com.ifpb.biblioteca.exceptions.LivroNaoLidoException;
import com.ifpb.biblioteca.model.*;


public class CadastroLivro {

    private File file;
    private List<Livro> estante;

    public CadastroLivro() throws IOException, ClassNotFoundException {
        file = new File("Estante");

        if(!file.exists()){
            file.createNewFile();
            estante = new ArrayList<>();
        }else{
            if(file.length()>0){
                try(ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream(file))){
                    estante = (List<Livro>) in.readObject();
                }
            }
            else estante = new ArrayList<>();
        }
    }

    public List<Livro> getLivros(){
        return estante;
    }

    public boolean cadastrar(Livro novo) throws LivroExistenteException, IOException {
        for (Livro livro: estante){
            if(novo.equals(livro)){
                throw new LivroExistenteException("Já existe um livro com este código!");
            }
        }
        estante.add(novo);
        atualizarArquivo();
        return true;
    }

    public boolean delete(int index) throws IOException {
        if(index>estante.size()-1){
            return false;
        }
        else{
            estante.remove(index);
            atualizarArquivo();
            return true;
        }
    }

    public boolean update(int index, Livro novo) throws IOException, LivroNaoLidoException {
        if(novo==null){
            throw new LivroNaoLidoException("O livro enviado tem valor null!");
        }
        if(index>estante.size()-1){
            return false;
        }else{
            estante.set(index,novo);
            atualizarArquivo();
            return true;
        }
    }


    public void atualizarArquivo() throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))){
            out.writeObject(estante);
        }
    }

    public boolean isEmpty(){
        return estante.isEmpty();
    }

    public Livro consulta(int index) {
        if(index>estante.size()-1){
            return null;
        }
        return estante.get(index);
    }

//    private Estante estante;
//
//    public CadastroLivro() {
//        estante = new Estante();
//    }
//
//
//    public Estante getEstante() {
//        if (estante.isEmpty()){
//            return null;
//        }
//        return estante;
//    }
//
//    public boolean cadastrar(Livro novo) {
//        estante.addLivro(novo);
//        System.out.println("Livro cadastrado com sucesso!!!");
//        return true;
//    }
//
//
//
//
//    public boolean update(int index,Livro novo){
//        if(index>estante.size()-1){
//            return false;
//        }
//        estante.atualizar(index,novo);
//        return true;
//    }
//
//
//
//    public boolean delete(int index){
//        if(index>estante.size()-1){
//            return false;
//        }
//        estante.removeLivro(index);
//        return true;
//    }

    @Override
    public String toString(){
        if(estante.isEmpty()){
            return "Não Existem livros cadastrados!";
        }
        String str = ":.:.:.:.:.:LIVROS:.:.:.:.:.:\n";
        int cont = 0;
        for (Livro livro:estante) {
            cont++;
            str += cont+":    \n"+livro.toString();
        }
        return str;
    }
}


