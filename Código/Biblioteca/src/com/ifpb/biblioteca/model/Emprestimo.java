package com.ifpb.biblioteca.model;

import java.time.LocalDate;
import com.ifpb.biblioteca.control.*;

public class Emprestimo {
    private int codigo;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean finalizado;
    private static int numEmprestimo;
    private CadastroDevolucao cadastrodevolucao;


    public Emprestimo(Livro livro, Cliente cliente) {
        codigo = ++numEmprestimo;
        finalizado = false;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(10);
    }

    public int getCodigo() { return codigo; }
 
    public boolean devolucao(Emprestimo emprestimo){
    	if(!(finalizado)){
    		System.out.println("Ocorreu um erro ao realizar a devolução. Por favor, tente novamente.");
    		return false;
    	}
    	if(dataDevolucao.isBefore(LocalDate.now())){
    		Devolucao devolucao = new Devolucao(emprestimo);
    		cadastrodevolucao.cadastrar(devolucao);
    		finalizado = false;
    		return true;
    	}
    	finalizado = false;
    	return true;
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

    public boolean isFinalizado() { return finalizado; }

    public void setFinalizado(boolean finalizado) { this.finalizado = finalizado; }

    @Override
    public String toString() {
        String s ="";
        if(isFinalizado()){
            s+= ".---------------FINALIZADO---------------.\n";
        }else s+= ".-----------------------------------------.\n";
        return  s+
                "CÃ³digo: "+ codigo + "\n" +
                "Livro: " + livro.getTitulo() + '\n' +
                "Cliente: " + cliente + '\n'+
                "Data para DevoluÃ§Ã£o" + dataDevolucao + '\n' +
                ".-----------------------------------------.\n";
    }
}
