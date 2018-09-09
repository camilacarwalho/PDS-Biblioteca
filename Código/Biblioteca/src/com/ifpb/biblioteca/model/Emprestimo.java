package com.ifpb.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private int codigo;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean finalizado;
    private static int numEmprestimo;


    public Emprestimo(Livro livro, Cliente cliente) {
        codigo = ++numEmprestimo;
        finalizado = false;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(10);
    }

    public int getCodigo() { return codigo; }

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

    public boolean isFinalizado() { return finalizado; }

    public void setFinalizado(boolean finalizado) { this.finalizado = finalizado; }

    @Override
    public String toString() {
        String s ="";
        if(isFinalizado()){
            s+= ".---------------FINALIZADO---------------.\n";
        }else s+= ".-----------------------------------------.\n";
        return  s+
                "Código: "+ codigo + "\n" +
                "Livro: " + livro.getTitulo() + '\n' +
                "Cliente: " + cliente + '\n'+
                "Data para Devolução" + dataDevolucao + '\n' +
                ".-----------------------------------------.\n";
    }
}
