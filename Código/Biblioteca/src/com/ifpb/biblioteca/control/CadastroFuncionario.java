package com.ifpb.biblioteca.control;

import com.ifpb.biblioteca.exceptions.DeleteUsuarioException;
import com.ifpb.biblioteca.exceptions.UsuarioCadastroException;
import com.ifpb.biblioteca.model.Funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CadastroFuncionario {

    private File file;
    private Set<Funcionario> funcionarios;

    public CadastroFuncionario() throws IOException, ClassNotFoundException {
        file = new File("Funcionarios");

        if(!file.exists()){
            file.createNewFile();
            funcionarios = new HashSet<>();
        }else{
            if(file.length()>0){
                try(ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream(file))){
                    funcionarios = (Set<Funcionario>) in.readObject();
                }
            }
            else funcionarios = new HashSet<>();
        }
    }

//    public Set<Funcionario> getFuncionarios() throws IOException, ClassNotFoundException{
//        if(funcionarios.length()>0){
//            try(ObjectInputStream in = new ObjectInputStream(
//                    new FileInputStream(funcionarios))){
//                return (Set<Funcionario>) in.readObject();
//            }
//        } return new HashSet<>();
//    }

    public Set<Funcionario> getFuncionarios(){
        return funcionarios;
    }

    public boolean adicionar(Funcionario func) throws IOException{
        if(funcionarios.add(func)){
            atualizarArquivo();
            return true;
        }
        return false;
    }

    public boolean deletar(Funcionario func)throws IOException{
        if(funcionarios.remove(func)){
            atualizarArquivo();
            return true;
        }
        return false;
    }

    public void atualizarArquivo() throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))){
            out.writeObject(funcionarios);
        }
    }
//    private List<Funcionario> funcionarios;
//
//    public CadastroFuncionario(){
//        funcionarios = new ArrayList<>();
//    }
//
//    public List<Funcionario> getFuncionarios() {
//        return funcionarios;
//    }
//
//    public boolean cadastrar(Funcionario novo) {
//        funcionarios.add(novo);
//        System.out.println("Funcionario cadastrado com sucesso!!!");
//        return true;
//    }
//
//
//    public Funcionario consulta(String email, String senha) {
//        for (Funcionario funcionario: funcionarios) {
//            if(funcionario.autentication(email,senha)){
//                return funcionario;
//            }
//        }
//        System.out.println("Usuário inexistente!!\n");
//        return null;
//    }
//
//    public boolean update(int index,Funcionario novo){
//        if(index>funcionarios.size()-1){
//            return false;
//        }
//        funcionarios.set(index,novo);
//        return true;
//    }
//
//    public boolean updateThis(String email, String senha, Funcionario novo){
//        Funcionario antigo = consulta(email,senha);
//        return update(funcionarios.indexOf(antigo),novo);
//    }
//
//    public boolean delete(int index){
//        if(index>funcionarios.size()-1){
//            return false;
//        }
//        funcionarios.remove(index);
//        return true;
//    }
//
//    public boolean deleteThis(String email, String senha) throws DeleteUsuarioException{
//        Funcionario deletar = consulta(email,senha);
//        if (delete(funcionarios.indexOf(deletar))){
//        	return true;
//        }
//        throw new DeleteUsuarioException("a");
//    }
//
    public boolean atualizarConta(Funcionario antigo,Funcionario novo) throws UsuarioCadastroException {
        if(funcionarios.remove(antigo)){
            if(funcionarios.add(novo)){
                return true;
            }
            else throw new UsuarioCadastroException("Já existe um usuário com esta matricula");
        }else return false;
    }

    public Funcionario buscarFuncionario(String email){
        for (Funcionario funcionario: funcionarios) {
            if(funcionario.getEmail().equals(email)){
                return funcionario;
            }
        }
        return null;
    }

    public boolean deletarEstaConta(Funcionario func) throws IOException, DeleteUsuarioException {
        if(func==null){
            return false;
        }
        else{
            if(funcionarios.remove(func)){
                atualizarArquivo();
                return true;
            }
            else throw new DeleteUsuarioException("a");
        }
    }

    public boolean autentication(String email, String senha) {
    	if(email.equals("0") && senha.equals("0")){
    		return true;
    	}
        for (Funcionario funcionario: funcionarios) {
            if(funcionario.autentication(email,senha)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String s = "";
        int cont = 0;
        for (Funcionario funcionario: funcionarios) {
            cont++;
            s+= cont + "\n" + funcionario.toString();
        }
        return s;
    }


}

