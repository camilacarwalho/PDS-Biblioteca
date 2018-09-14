package com.ifpb.biblioteca.model;

public class Devolucao {
    private Emprestimo emprestimo;

    public Devolucao(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
}
