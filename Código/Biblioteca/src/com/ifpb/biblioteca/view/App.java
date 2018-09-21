package com.ifpb.biblioteca.view;

import com.ifpb.biblioteca.control.*;
import com.ifpb.biblioteca.model.Autor;
import com.ifpb.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static CadastroAutor crudAutor;


	public static void main(String[] args) {
        setCrudAutor(new CadastroAutor());
        CadastroAutor crudAutor = new CadastroAutor();
        CadastroCliente crudCliente = new CadastroCliente();
        CadastroEmprestimos crudEmprestimo = new CadastroEmprestimos();
        CadastroLivro crudLivro = new CadastroLivro();
        CadastroFuncionario crudFuncionario = new CadastroFuncionario();
        CadastroDevolucao crudDevolucao = new CadastroDevolucao();
        boolean continua = true;
        int seleciona;
        int selecionaMenu;
        Scanner scan = new Scanner(System.in);


        while(continua){
            System.out.println(":.:.:.:.TELA INICIAL FUNCION¡RIO.:.:.:.:\n\n");
            System.out.println("1: Autenticar");
            System.out.println("2: Criar nova conta:");
            seleciona = scan.nextInt();

            if(seleciona<0||seleciona>2){
                System.out.println("ERROR:Press ENTER para continuar!");
                scan.nextLine();
            }
            else{
                switch(seleciona){
                    case 1:
                        if(ShowText.login(crudFuncionario)){
                            System.out.println("Login feito com sucesso!!!");
                            boolean continuaMenu = true;
                            while(continuaMenu) {
                                ShowText.menuFuncionario();
                                selecionaMenu = scan.nextInt();
                                if(selecionaMenu<1||selecionaMenu>6){
                                    System.out.println("ERROR:Press ENTER para continar!");
                                    scan.nextLine();
                                }else {
                                    switch(selecionaMenu){
                                        case 1:
                                            System.out.println(crudLivro);
                                            break;
                                        case 2: ShowText.readCliente(crudCliente);
                                            break;
                                        case 3:  System.out.println("Digite novamente o seu email:");
                                                 String email = scan.next();
                                                 System.out.println("Digite a sua senha\n");
                                                 String senha = scan.next();
                                                 crudFuncionario.deleteThis(email, senha);
                                                 System.out.println("Funcion√°rio deletado com sucesso!\n");
                                                 continuaMenu=false;
                                            break;
                                        case 4:
                                        	boolean continuaMenuEmprestimo = true;
                                        	while(continuaMenuEmprestimo){
                                                ShowText.gerenciaEmprestimo();
                                                int selecionaM = scan.nextInt();
                                                if(selecionaM<1||selecionaM>6){
                                                    System.out.println("ERROR:Press ENTER para continar!");
                                                    scan.nextLine();
                                                }
                                                else{
                                                    switch(selecionaM){
                                                        case 1:
                                                            if(crudEmprestimo.equals("")){
                                                            	System.out.println("Nenhum emprestimo salvo!");
                                                            }
                                                            else{
                                                            	System.out.println(crudEmprestimo);
                                                            };
                                                            break;
                                                        case 2:
                                                        		int codigo = scan.nextInt();
                                                        		ShowText.doDevolucao(crudEmprestimo.consulta(codigo));
                                                            break;
                                                        case 3: ShowText.doEmprestimo(crudLivro, crudCliente, crudEmprestimo);
                                                            break;
                                                        case 4:
                                                        	 continuaMenuEmprestimo = false;
                                                        	 break;
                                                    }
                                                }
                                            }

                                            break;
                                        case 5:  boolean continuaL = true;
										while(continuaL){
                                                ShowText.gerenciaLivros();
                                                int selecionaM = scan.nextInt();
                                                if(selecionaM<1||selecionaM>5){
                                                    System.out.println("ERROR:Press ENTER para continar!");
                                                    scan.nextLine();
                                                }
                                                else{
                                                    switch(selecionaM){
                                                        case 1:
                                                            ShowText.readLivro(crudLivro);
                                                            break;
                                                        case 2:
                                                            System.out.println("Selecione qual livro deseja deletar:");
                                                            System.out.println(crudLivro);
                                                            int deletar = scan.nextInt();
                                                            crudLivro.delete(deletar-1);
                                                            System.out.println("Livro deletado com sucesso!!!");
                                                            break;
                                                        case 3:
                                                            System.out.println("Selecione qual livro deseja editar:");
                                                            System.out.println(crudLivro);
                                                            int edit = scan.nextInt();
                                                            ShowText.readLivro(crudLivro);
                                                            List<Livro> livros = crudLivro.getEstante().getLivros();
                                                            int tamanhoarraylivros = livros.size();
                                                            crudLivro.update(edit, crudLivro.consulta(tamanhoarraylivros-1));
                                                            livros = null;
                                                            break;
                                                        case 4:
                                                        	boolean continuaMenuAutor = true;
                                                        	while(continuaMenuAutor){
                                                        		ShowText.gerenciaAutores(crudAutor);
                                                        		int opcao = scan.nextInt();
                                                        		if(opcao < 0 || opcao > 4){
                                                        			System.out.println("opÁ„o invalida!");
                                                        			opcao = scan.nextInt();
                                                        		}
                                                        		else{
                                                        			switch(opcao){
                                                        			case 1:
                                                        				ShowText.readAutor(crudAutor);
                                                        				break;
                                                        			case 2:
                                                        				System.out.println("Selecione qual Autor deseja deletar:");
                                                                        System.out.println(crudAutor);
                                                                        int delete = scan.nextInt();
                                                                        crudAutor.delete(delete-1);
                                                                        System.out.println("Autor deletado com sucesso!!!");
                                                                        break;
                                                        			case 3:
                                                        				System.out.println("Selecione qual Autor deseja alterar:");
                                                                        System.out.println(crudAutor);
                                                                        int update = scan.nextInt();
                                                                        ShowText.readLivro(crudLivro);
                                                                        List<Autor> autores = crudAutor.getAutores();
                                                                        int tamanhoarrayautores = autores.size();
                                                                        crudAutor.update(update, crudAutor.consulta(tamanhoarrayautores-1));
                                                                        livros = null;
                                                                        break;
                                                        			case 4:
                                                        				continuaMenuAutor = false;
                                                        				break;
                                                            		}
                                                        		}
                                                        	}
                                                        	break;
                                                        case 5:
                                                        	continuaL = false;
                                                        	break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 6: continuaMenu = false;
                                            break;
                                    }
                                }

                            }
                        }else System.out.println("Funcion√°rio n√£o cadastrado!!!");

                        break;
                    case 2: ShowText.readFuncionario(crudFuncionario);

                        break;

                    case 0: continua = false;
                }
            }
            limpaTela();
        }
        System.out.println("::.:.:.:.:.:FIM::.:.:.:.:.:");

        scan.close();
    }


    public static void limpaTela(){
        for (int i=0; i<10;i++) System.out.println("\n");

    }


	public static CadastroAutor getCrudAutor() {
		return crudAutor;
	}


	public static void setCrudAutor(CadastroAutor crudAutor) {
		App.crudAutor = crudAutor;
	}

}
