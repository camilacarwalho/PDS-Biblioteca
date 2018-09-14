package com.ifpb.biblioteca.view;

import com.ifpb.biblioteca.control.*;
import com.ifpb.biblioteca.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ShowText {

    public static boolean login(CadastroFuncionario crudF) {
        Scanner scan = new Scanner(System.in);
        System.out.println(":.:.:.:.:.LOGIN.:.:.:.:.:\n\n");
        System.out.println("        FUNCIONARIO       \n");
        System.out.println("Informe o seu email:");
        String email = scan.next();
        System.out.println("Informe sua senha:");
        String senha = scan.next();
        return crudF.autentication(email, senha);
    }

    public static boolean loginCliente(CadastroCliente crudC) {
        Scanner scan = new Scanner(System.in);
        System.out.println(":.:.:.:.:.LOGIN.:.:.:.:.:\n\n");
        System.out.println("         CLIENTE         \n");
        System.out.println("Informe o seu email:");
        String email = scan.next();
        System.out.println("Informe sua senha:");
        String senha = scan.next();
        return crudC.autentication(email, senha);
    }

    public static void menuFuncionario() {
        System.out.println(":.:.:.:.:.MENU PRINCIPAL.:.:.:.:.:\n\n");
        System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO:");
        System.out.println("1. Visualizar lista de livros");
        System.out.println("2. Cadastrar cliente");
        System.out.println("3. Deletar esta conta");
        System.out.println("4. Ir para a gerencia de emprestimos");
        System.out.println("5. Ir para o gerencia de livros");
        System.out.println("6. Sair desta conta");
    }

    public static void gerenciaEmprestimo() {
        System.out.println(":.:.:.:.:.GERÊNCIDA DE EMPRESTIMOS.:.:.:.:.:\n\n");
        System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO:");
        System.out.println("1. Visualizar emprestimos");
        System.out.println("2. Realizar devolução");
        System.out.println("3. Realizar emprestimo");
        System.out.println("4. Voltar ao menú principal");
    }

    public static void gerenciaLivros() {
        System.out.println(":.:.:.:.:.GERENCIA DE LIVROS.:.:.:.:.:\n\n");
        System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO:");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Deletar livro");
        System.out.println("3. Editar livro");
        System.out.println("4. Ir para a gerencia de autores");
        System.out.println("5. Voltar ao menú principal");
    }

    public static void gerenciaAutores() {
        System.out.println(":.:.:.:.:.GERENCIA DE AUTORES.:.:.:.:.:\n\n");
        System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO:");
        System.out.println("1. Cadastrar autor");
        System.out.println("2. Deletar autor");
        System.out.println("3. Editar autor");
        System.out.println("4. voltar a genrencia de livros");
    }

    public static void readFuncionario(CadastroFuncionario crudF) {
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(":.:.:.:.:.CADASTRO.:.:.:.:.:\n\n");
        System.out.println("        FUNCIOANRIO         \n");
        System.out.println("Informe seu email:");
        String email = scan.next();
        System.out.println("Informe sua senha:");
        String senha = scan.next();
        System.out.println("Informe seu nome:");
        String nome = scan.next();
        System.out.println("Informe seu CPF:");
        String CPF = scan.next();
        System.out.println("Informe sua data de nasicmento:");
        String data = scan.next();
        LocalDate nascimento = LocalDate.parse(data, formatter);
        Funcionario novo = new Funcionario(email, senha, nome, CPF, nascimento);
        crudF.cadastrar(novo);

    }

    public static void readCliente(CadastroCliente crudC) {
        Scanner scan = new Scanner(System.in);
        System.out.println(":.:.:.:.:.CADASTRO.:.:.:.:.:\n\n");
        System.out.println("          CLIENTE           \n");
        System.out.println("Informe seu email:");
        String email = scan.next();
        System.out.println("Informe sua senha:");
        String senha = scan.next();
        System.out.println("Informe seu nome:");
        String nome = scan.next();
        System.out.println("Informe seu CPF:");
        String CPF = scan.next();
        Cliente novo = new Cliente(nome, CPF, email, senha);
        crudC.cadastrar(novo);
    }

    public static void readLivro(CadastroLivro crudL) {
        Scanner scan = new Scanner(System.in);
        System.out.println(":.:.:.:.:.CADASTRO.:.:.:.:.:\n\n");
        System.out.println("           LIVRO            \n");
        System.out.println("Informe o titulo do livro:");
        String titulo = scan.next();
        System.out.println("Informe o códgo do livro:");
        int codigo = scan.nextInt();
        System.out.println("Selecione o genero:");
        System.out.println("1. ROMANCE\n2. TERROR\n3. POESIA\n4. FANTASIA\n5. AVENTURA\n6. BIOGRAFIA\n7. DIDATICO");
        int choise = scan.nextInt();
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
        Autor autor = null;
        System.out.println("Informe a descrição do livro:");
        String descricao = scan.nextLine();
        scan.nextLine();
        Livro novo = new Livro(titulo, codigo, genero, autor, descricao);
        crudL.cadastrar(novo);
    }

    public static void readAutor(CadastroAutor crudA) {
        Scanner scan = new Scanner(System.in);
        System.out.println(":.:.:.:.:.CADASTRO.:.:.:.:.:\n\n");
        System.out.println("           AUTOR            \n");
        System.out.println("Informe o nome do autor:");
        String nome = scan.nextLine();
        scan.nextLine();
        Autor autor = new Autor(nome);
        crudA.cadastrar(autor);
    }

    public static void doEmprestimo(CadastroLivro crudL, CadastroCliente crudC, CadastroEmprestimos crudE) {
        Scanner scan = new Scanner(System.in);
        System.out.println(":.:.:.:.:.EMPRESTIMO.:.:.:.:.:\n\n");
        System.out.println("      SELECIONE UM LIVRO      \n");
        System.out.println(crudL);
        int choise = scan.nextInt();
        if (crudL.getEstante()==null){
            System.out.println("Empréstimo não pode ser realizado, não existem livros!!!");

        }else {
            Livro escolhido = crudL.consulta(choise - 1);
            System.out.println("Informe o email do cliente:");
            String email = scan.next();
            System.out.println("Informe a senha do cliente:");
            String senha = scan.next();
            Cliente cliente = crudC.consulta(email, senha);
            Emprestimo emprestimo = new Emprestimo(escolhido, cliente);
            System.out.println("A devolução deve ser feita na data: " + emprestimo.getDataDevolucao());
            crudE.cadastrar(emprestimo);
        }
    }

}


