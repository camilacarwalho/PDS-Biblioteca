package com.ifpb.biblioteca.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario implements Serializable {

    private String email;
    private String senha;
    private String nome;
    private String CPF;
    private LocalDate data;

    public Funcionario(String email,String senha,String nome,String CPF,LocalDate data){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.CPF = CPF;
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean autentication(String email, String senha){
        return Objects.equals(this.email, email) && Objects.equals(this.senha, senha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return  "------------------------------\n"+
                "Funcionario: \n\n" +
                "email='" + email + '\n' +
                "senha='" + senha + '\n' +
                "nome='" + nome + '\n' +
                "CPF='" + CPF + '\n' +
                "data=" + data +
                "------------------------------";
    }
}


