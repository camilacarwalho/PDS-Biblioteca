package com.ifpb.biblioteca.control;

import com.ifpb.biblioteca.exceptions.ClienteInexistenteException;
import com.ifpb.biblioteca.model.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CadastroCliente {

    private File file;
    private List<Cliente> cadastrados;

    public CadastroCliente() throws IOException, ClassNotFoundException {
        file = new File("Cadastrados");

        if(!file.exists()){
            file.createNewFile();
            cadastrados = new ArrayList<>();
        }else{
            if(file.length()>0){
                try(ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream(file))){
                    cadastrados = (List<Cliente>) in.readObject();
                    int maior = 0;
                    for (Cliente cliente : cadastrados) {
                        if(cliente.getMatricula()>maior){
                            maior = cliente.getMatricula();
                        }
                    }
                    Cliente.setCodigoCliente(maior);
                }
            }
            else cadastrados = new ArrayList<>();
        }
    }

    public List<Cliente> getClientes(){
        return cadastrados;
    }

    public boolean isEmpty(){
        return cadastrados.isEmpty();
    }

    public boolean cadastrar(Cliente novo) throws IOException {
        cadastrados.add(novo);
        atualizarArquivo();
        return true;
    }

    public boolean delete(int index) throws IOException {
        cadastrados.remove(index);
        atualizarArquivo();
        return true;
    }

    public boolean update(String email, String senha, Cliente novo) throws ClienteInexistenteException, IOException {
        Cliente antigo = consulta(email,senha);
        if(antigo==null){
            throw new  ClienteInexistenteException("O cliente solicitado não existe!");
        }else{
            cadastrados.set(cadastrados.indexOf(antigo),novo);
            atualizarArquivo();
            return true;
        }
    }

    public void atualizarArquivo() throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))){
            out.writeObject(cadastrados);
        }
    }

    public boolean autentication(String email, String senha) {
        for (Cliente cliente: cadastrados) {
            if(cliente.autentication(email,senha)){
                return true;
            }
        }
        return false;
    }


    public Cliente consulta(String email, String senha) throws ClienteInexistenteException {
        for (Cliente cliente: cadastrados) {
            if(cliente.autentication(email,senha)){
                return cliente;
            }
        }
        throw new ClienteInexistenteException("a");
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


