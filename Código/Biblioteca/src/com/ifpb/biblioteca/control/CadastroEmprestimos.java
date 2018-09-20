package com.ifpb.biblioteca.control;

import com.ifpb.biblioteca.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CadastroEmprestimos {

    List<Emprestimo> emprestimos;

    public CadastroEmprestimos(){
        emprestimos = new ArrayList<>();
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public boolean cadastrar(Emprestimo novo) {
        if(emprestimos.add(novo)){
        System.out.println("Emprestimo feito com sucesso!!");
        return true;
        }
        System.out.println("Ocorreu um erro durante o cadastro do emprestimo. Por favor, tente novamente.");
        return false;
    }


    public String consulta(int codigo) {
        for (Emprestimo emprestimo: emprestimos) {
            if(codigo == emprestimo.getCodigo()){
                return emprestimo.toString();
            }
        }
        return "Este emprestimo não existe.";
    }


    public boolean update(int index,Emprestimo novo){
        if(index>emprestimos.size()-1){
            return false;
        }
        emprestimos.set(index,novo);
        return true;
    }



    public boolean delete(int index){
        if(index>emprestimos.size()-1){
            return false;
        }
        emprestimos.remove(index);
        return true;
    }

    @Override
    public String toString() {
        String s ="";
        int cont = 0;
        for (Emprestimo emprestimo: emprestimos) {
            cont++;
            s += cont + "\n" + emprestimo.toString();
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CadastroEmprestimos that = (CadastroEmprestimos) o;
        return Objects.equals(emprestimos, that.emprestimos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(emprestimos);
    }
}
