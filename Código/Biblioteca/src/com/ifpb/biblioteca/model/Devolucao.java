package com.ifpb.biblioteca.model;

import java.time.LocalDate;
import java.time.Period;

public class Devolucao {
	
	private Emprestimo emprestimo;
	private LocalDate DataDevolucao;
	private float multa;
	private Period periodomulta;
	
	public Devolucao(Emprestimo emprestimo){
		this.emprestimo = emprestimo;
		this.DataDevolucao = LocalDate.now();
		setPeriodomulta(Period.between(emprestimo.getDataDevolucao(), this.getDataDevolucao()));
		this.multa = (periodomulta.getDays()) * 2;
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public LocalDate getDataDevolucao() {
		return DataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		DataDevolucao = dataDevolucao;
	}
	public float getMulta() {
		return multa;
	}
	public void setMulta(float multa) {
		this.multa = multa;
	}

	public Period getPeriodomulta() {
		return periodomulta;
	}

	public Period setPeriodomulta(Period periodomulta) {
		this.periodomulta = periodomulta;
		return periodomulta;
	}

}
