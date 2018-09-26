package com.ifpb.biblioteca.control;

import java.util.ArrayList;	
import com.ifpb.biblioteca.model.Devolucao;
import com.ifpb.biblioteca.model.Livro;

public class CadastroDevolucao {
	
	private ArrayList<Devolucao> devolucoes;
	
	public CadastroDevolucao(){
		setDevolucoes(new ArrayList<Devolucao>());
	}

	public ArrayList<Devolucao> getDevolucoes() {
		return devolucoes;
	}

	public void setDevolucoes(ArrayList<Devolucao> devolucoes) {
		this.devolucoes = devolucoes;
	}
	
	public float cadastrar(Devolucao devolucao) throws NullPointerException{
		if(devolucao == null){
			throw new NullPointerException("a");
		}
		else{
			devolucoes.add(devolucao);
			Livro livro = devolucao.getEmprestimo().getLivro();
			livro.setStatus(false);
			
			return devolucao.getMulta();
		}
	}
	
	public boolean remover(Devolucao devolucao){
		if(devolucao == null){
			System.out.println("Ocorreu um erro ao tentar remover a devolu��o no array. Por favor, tente novamente.");
			return false;
		}
		return devolucoes.remove(devolucao);
	}
	
	public Devolucao consulta(int index){
		if(index < devolucoes.size()){
			System.out.println("Ocorreu um erro ao tentar consultar a devolu��o no array. Por favor, tente novamente.");
			return null;
		}
		return devolucoes.get(index);
	}
	
	public boolean atualizar(Devolucao devolucao, int index){
		if(index < devolucoes.size()){
			System.out.println("Ocorreu um erro ao tentar atualizar a devolu��o no array. Por favor, tente novamente.");
			return false;
		}
		devolucoes.set(index, devolucao);
		return true;
	}

}
