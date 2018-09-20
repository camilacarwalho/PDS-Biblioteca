package com.ifpb.biblioteca.model;

import java.util.Objects;


public class Cliente {

    private String nome;
    private int matricula;
    private String cpf;
    private String email;
    private String senha;
    private static int codigoCliente;


    public Cliente(String nome, String cpf, String email, String senha) {
        matricula = ++codigoCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return matricula == cliente.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    public boolean autentication(String email, String senha){
        return Objects.equals(this.email, email) && Objects.equals(this.senha, senha);
    }
}
