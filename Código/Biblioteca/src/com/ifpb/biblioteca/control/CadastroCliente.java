package com.ifpb.biblioteca.control;

import com.ifpb.biblioteca.model.Cliente;	

import java.util.ArrayList;
import java.util.List;


public class CadastroCliente {

    private List<Cliente> cadastrados;

    public CadastroCliente() {
        cadastrados = new ArrayList<>();
    }


    public List<Cliente> getCadastrados() {
        return cadastrados;
    }


    public boolean cadastrar(Cliente novo) {
        return cadastrados.add(novo);
    }

    public boolean autentication(String email, String senha) {
        for (Cliente cliente: cadastrados) {
            if(cliente.autentication(email,senha)){
                return true;
            }
        }
        return false;
    }


    public Cliente consulta(String email, String senha) {
        for (Cliente cliente: cadastrados) {
            if(cliente.autentication(email,senha)){
                System.out.println(cliente);
                return cliente;
            }
        }
        System.out.println("Cliente não cadastrado!!!");
        return null;
    }

    public boolean update(int index, Cliente novo){
        if(index>cadastrados.size()-1){
            return false;
        }
        cadastrados.set(index,novo);
        return true;
    }


    public boolean updateThis(String email, String senha, Cliente novo){
        Cliente antigo = consulta(email,senha);
        return update(cadastrados.indexOf(antigo),novo);
    }

    public boolean delete(int index){
        if(index>cadastrados.size()-1){
            return false;
        }
        cadastrados.remove(index);
        return true;
    }



    public boolean deleteThis(String email, String senha){
        Cliente deletar = consulta(email,senha);
        return delete(cadastrados.indexOf(deletar));
    }

    @Override
    public String toString() {
        if(cadastrados.isEmpty()){
            return "Não existem clientes cadastrados!";
        }
        String str = ":.:.:.:.:.:CLIENTES::.:.:.:.:.:\n";
        int cont = 0;
        for (Cliente cliente:cadastrados) {
            cont++;
            str += cont+":    \n"+ cliente.toString();
        }
        return str;
    }
}


