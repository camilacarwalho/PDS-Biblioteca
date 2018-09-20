package com.ifpb.biblioteca.control;

import com.ifpb.biblioteca.model.Funcionario;	
import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionario {

    private List<Funcionario> funcionarios;

    public CadastroFuncionario(){
        funcionarios = new ArrayList<>();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public boolean cadastrar(Funcionario novo) {
        funcionarios.add(novo);
        System.out.println("Funcionario cadastrado com sucesso!!!");
        return true;
    }


    public Funcionario consulta(String email, String senha) {
        for (Funcionario funcionario: funcionarios) {
            if(funcionario.autentication(email,senha)){
                return funcionario;
            }
        }
        System.out.println("Usuário inexistente!!\n");
        return null;
    }

    public boolean update(int index,Funcionario novo){
        if(index>funcionarios.size()-1){
            return false;
        }
        funcionarios.set(index,novo);
        return true;
    }

    public boolean updateThis(String email, String senha, Funcionario novo){
        Funcionario antigo = consulta(email,senha);
        return update(funcionarios.indexOf(antigo),novo);
    }

    public boolean delete(int index){
        if(index>funcionarios.size()-1){
            return false;
        }
        funcionarios.remove(index);
        return true;
    }

    public boolean deleteThis(String email, String senha){
        Funcionario deletar = consulta(email,senha);
        return delete(funcionarios.indexOf(deletar));
    }

    public boolean autentication(String email, String senha) {
        for (Funcionario funcionario: funcionarios) {
            if(funcionario.autentication(email,senha)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        int cont = 0;
        for (Funcionario funcionario: funcionarios) {
            cont++;
            s+= cont + "\n" + funcionario.toString();
        }
        return s;
    }
}
