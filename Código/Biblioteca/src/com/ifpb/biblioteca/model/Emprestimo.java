package com.ifpb.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;


    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(10);
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return ".-----------------------------------------.\n" +
                "Livro: " + livro.getTitulo() + '\n' +
                "Cliente: " + cliente.getNome() + '\n'+
                "Data para Devolução" + dataDevolucao + '\n' +
                ".-----------------------------------------.\n";
    }
}
