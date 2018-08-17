package com.ifpb.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clientes {
    private List<Cliente> clientes;

    public Clientes(){
        clientes = new ArrayList<Cliente>();
            }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "clientes=" + clientes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes1 = (Clientes) o;
        return Objects.equals(clientes, clientes1.clientes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clientes);
    }


    public boolean addCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    public boolean removeCliente(Cliente cliente) {
        return clientes.remove(cliente);}

    public void editaCliente(Cliente cliente, int indice){
        clientes.set(indice,cliente);
    }
}
