package com.ifpb.biblioteca.control;

import java.util.ArrayList;	
import com.ifpb.biblioteca.model.Devolucao;

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
	
	public boolean cadastrar(Devolucao devolucao){
		if(devolucao == null){
			System.out.println("Ocorreu um erro ao tentar inserir a devolução no array. Por favor, tente novamente.");
			return false;
		}
		return devolucoes.add(devolucao);
	}
	
	public boolean remover(Devolucao devolucao){
		if(devolucao == null){
			System.out.println("Ocorreu um erro ao tentar remover a devolução no array. Por favor, tente novamente.");
			return false;
		}
		return devolucoes.remove(devolucao);
	}
	
	public Devolucao consulta(int index){
		if(index < devolucoes.size()){
			System.out.println("Ocorreu um erro ao tentar consultar a devolução no array. Por favor, tente novamente.");
			return null;
		}
		return devolucoes.get(index);
	}
	
	public boolean atualizar(Devolucao devolucao, int index){
		if(index < devolucoes.size()){
			System.out.println("Ocorreu um erro ao tentar atualizar a devolução no array. Por favor, tente novamente.");
			return false;
		}
		devolucoes.set(index, devolucao);
		return true;
	}

}
