package com.ifpb.biblioteca.view;

import com.ifpb.biblioteca.control.*;
import com.ifpb.biblioteca.exceptions.EmprestimoInexistenteException;
import com.ifpb.biblioteca.exceptions.LivroExistenteException;
import com.ifpb.biblioteca.exceptions.LivroInexistenteException;
import com.ifpb.biblioteca.exceptions.LivroNaoLidoException;
import com.ifpb.biblioteca.exceptions.SemLivroException;
import com.ifpb.biblioteca.exceptions.UsuarioCadastroException;
import com.ifpb.biblioteca.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowText {

    private static Scanner scan;
	private static Scanner scan2;
	private static Scanner scan3;
	private static Scanner scan4;
	private static Scanner scan5;
	private static Scanner scan6;
	private static Scanner scan7;

	public static boolean login(CadastroFuncionario crudF) {
        scan = new Scanner(System.in);
        System.out.println(":.:.:.:.:.LOGIN.:.:.:.:.:\n\n");
        System.out.println("        FUNCIONARIO       \n");
        System.out.println("Informe o seu email:");
        String email = scan.next();
        System.out.println("Informe sua senha:");
        String senha = scan.next();
        return crudF.autentication(email, senha);
    }

    public static boolean loginCliente(CadastroCliente crudC) {
        scan2 = new Scanner(System.in);
        System.out.println(":.:.:.:.:.LOGIN.:.:.:.:.:\n\n");
        System.out.println("         CLIENTE         \n");
        System.out.println("Informe o seu email:");
        String email = scan2.next();
        System.out.println("Informe sua senha:");
        String senha = scan2.next();
        return crudC.autentication(email, senha);
    }

    public static void menuFuncionario() {
        System.out.println(":.:.:.:.:.MENU PRINCIPAL.:.:.:.:.:\n\n");
        System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO:");
        System.out.println("1. Visualizar lista de livros");
        System.out.println("2. Deletar esta conta");
        System.out.println("3. Ir para a gerencia de clientes");
        System.out.println("4. Ir para a gerencia de emprestimos");
        System.out.println("5. Ir para o gerencia de livros");
        System.out.println("6. Sair desta conta");
    }

    public static void gerenciaCliente(){
        System.out.println(":.:.:.:.:.GERÊNCIA DE CLIENTES.:.:.:.:.:\n\n");
        System.out.println("1. Cadastrar um cliente");
        System.out.println("2. Atualizar os dados de um cliente");
        System.out.println("3. Deletar um cliente");
        System.out.println("4. Mostrar todo os clientes cadastrados");
        System.out.println("5. Voltar ao menu principal");
    }

    public static void gerenciaEmprestimo() {
        System.out.println(":.:.:.:.:.GERÊNCIDA DE EMPRESTIMOS.:.:.:.:.:\n\n");
        System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO:");
        System.out.println("1. Visualizar emprestimos");
        System.out.println("2. Realizar devolução");
        System.out.println("3. Realizar emprestimo");
        System.out.println("4. Voltar ao menu principal");
    }

    public static void gerenciaLivros() {
        System.out.println(":.:.:.:.:.GERENCIA DE LIVROS.:.:.:.:.:\n\n");
        System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO:");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Deletar livro");
        System.out.println("3. Editar livro");
        System.out.println("4. Voltar ao menú principal");
    }

    public static void readFuncionario(CadastroFuncionario crudF) throws IOException{
        scan3 = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(":.:.:.:.:.CADASTRO.:.:.:.:.:\n\n");
        System.out.println("        FUNCIOANRIO         \n");
        System.out.println("Informe seu email:");
        String email = scan3.next();
        System.out.println("Informe sua senha:");
        String senha = scan3.next();
        System.out.println("Informe seu nome:");
        String nome = scan3.next();
        System.out.println("Informe seu CPF:");
        String CPF = scan3.next();
        System.out.println("Informe sua data de nasicmento:");
        String data = scan3.next();
        LocalDate nascimento = LocalDate.parse(data, formatter);
        Funcionario novo = new Funcionario(email, senha, nome, CPF, nascimento);
        crudF.adicionar(novo);

    }

    public static Cliente readCliente(CadastroCliente crudC,boolean cadastrar) throws UsuarioCadastroException, IOException {
        scan4 = new Scanner(System.in);
        System.out.println(":.:.:.:.:.CADASTRO.:.:.:.:.:\n\n");
        System.out.println("          CLIENTE           \n");
        System.out.println("Informe seu email:");
        String email = scan4.next();
        System.out.println("Informe sua senha:");
        String senha = scan4.next();
        System.out.println("Informe seu nome:");
        String nome = scan4.next();
        System.out.println("Informe seu CPF:");
        String CPF = scan4.next();
        Cliente novo = new Cliente(nome, CPF, email, senha);
        if(cadastrar){
            crudC.cadastrar(novo);
            return null;
        }else return novo;
    }

    public static Livro readLivro(CadastroLivro crudL,boolean adicionar) throws LivroExistenteException, IOException {
        scan5 = new Scanner(System.in);
        System.out.println(":.:.:.:.:.CADASTRO.:.:.:.:.:\n\n");
        System.out.println("           LIVRO            \n");
        System.out.println("Informe o titulo do livro:");
        String titulo = scan5.nextLine();
        System.out.println("Informe o códgo do livro:");
        int codigo = scan5.nextInt();
        System.out.println("Selecione o genero:");
        System.out.println("1. ROMANCE\n2. TERROR\n3. POESIA\n4. FANTASIA\n5. AVENTURA\n6. BIOGRAFIA\n7. DIDATICO");
        int choise = scan5.nextInt();
        Genero genero;
        switch (choise) {
            case 1:
                genero = Genero.ROMANCE;
                break;
            case 2:
                genero = Genero.TERROR;
                break;
            case 3:
                genero = Genero.POESIA;
                break;
            case 4:
                genero = Genero.FANTASIA;
                break;
            case 5:
                genero = Genero.AVENTURA;
                break;
            case 6:
                genero = Genero.BIOGRAFIA;
                break;
            case 7:
                genero = Genero.DIDATICO;
                break;
            default:
                genero = Genero.ROMANCE;
        }
        System.out.println("Informe o nome do autor:");
        scan5.nextLine();
        String autor = scan5.nextLine();
        System.out.println("Informe a descrição do livro:");
        String descricao = scan5.nextLine();
        Livro novo = new Livro(titulo, codigo, genero, autor, descricao);
        if(adicionar){
            try{
                crudL.cadastrar(novo);
            }catch(LivroNaoLidoException ex){
                System.out.println(ex.getMessage());
            }
            return null;
        }else return novo;
    }

    public static void doEmprestimo(CadastroLivro crudL, CadastroCliente crudC, CadastroEmprestimos crudE) throws SemLivroException, LivroInexistenteException{
        scan7 = new Scanner(System.in);
        System.out.println(":.:.:.:.:.EMPRESTIMO.:.:.:.:.:\n\n");
        System.out.println("      SELECIONE UM LIVRO      \n");
        System.out.println(crudL);
        if (crudL.isEmpty()){
            throw new SemLivroException("a");
        }else {
        	int choise = -1;
        	try{
        	    choise = scan7.nextInt();
        	    if(choise>0){
                    Livro escolhido = crudL.consulta(choise - 1);
                    if (escolhido == null){
                    	throw new LivroInexistenteException("a");
                    }
                    System.out.println("Informe o email do cliente:");
                    String email = scan7.next();
                    System.out.println("Informe a senha do cliente:");
                    String senha = scan7.next();
                    Cliente cliente = crudC.consulta(email, senha);
                    Emprestimo emprestimo = new Emprestimo(escolhido, cliente);
                    System.out.println("A devolução deve ser feita na data: " + emprestimo.getDataDevolucao());
                    crudE.cadastrar(emprestimo);
                }else {
                    System.out.println("Valor inválido para indice");
                }
            }catch(InputMismatchException ex){
                System.out.println("Valor inválido para indice");
            }
        }
    }
    
    public static void doDevolucao(Emprestimo emprestimo, CadastroDevolucao crudDevolucao, CadastroEmprestimos crudEmprestimo, int codigo) throws EmprestimoInexistenteException{
        System.out.println(":.:.:.:.:.DEVOLUÇÃO.:.:.:.:.:\n\n");
        if(emprestimo == null){
        	throw new EmprestimoInexistenteException("a");
        }
        if(emprestimo.getDataDevolucao().isBefore(LocalDate.now())){
        	Devolucao devolucao = new Devolucao(emprestimo);
        	float multa = 0;
        	try{
        		multa = crudDevolucao.cadastrar(devolucao);
        		crudEmprestimo.delete(codigo-1);
        		System.out.println("Devolvido com sucesso! A multa é de " + multa);
        	}catch(NullPointerException ex){
        		System.out.println("Erro ao tentar cadastrar a devolução. Por favor, tente novamente.");
        	}
        }
        else{
        	crudEmprestimo.delete(codigo-1);
        	Livro livro = emprestimo.getLivro();
        	livro.setStatus(false);
        	System.out.println("devolvido com sucesso!");
        }
        
    }

}


