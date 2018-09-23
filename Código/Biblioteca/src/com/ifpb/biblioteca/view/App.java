package com.ifpb.biblioteca.view;

import com.ifpb.biblioteca.control.*;
import com.ifpb.biblioteca.exceptions.*;
import com.ifpb.biblioteca.model.Autor;
import com.ifpb.biblioteca.model.Funcionario;
import com.ifpb.biblioteca.model.Livro;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    private static CadastroAutor crudAutor;


	public static void main(String[] args) {
        CadastroFuncionario crudFuncionario = null;
        CadastroLivro crudLivro = null;
	    try{
            crudFuncionario = new CadastroFuncionario();
        }catch(Exception e){
            System.out.println("Error: Fluxo de cadastro de funcionarios!");
            System.exit(1);
        }
        try{
            crudLivro = new CadastroLivro();
        }catch(Exception e){
            System.out.println("Erro: Fluxo de cadastro de Livros!");
            System.exit(1);
        }
        setCrudAutor(new CadastroAutor());
        CadastroAutor crudAutor = new CadastroAutor();
        CadastroCliente crudCliente = new CadastroCliente();
        CadastroEmprestimos crudEmprestimo = new CadastroEmprestimos();
        CadastroDevolucao crudDevolucao = new CadastroDevolucao();
        boolean continua = true;
        int seleciona=0;
        int selecionaMenu=0;
        Scanner scan = new Scanner(System.in);


        while(continua){
            System.out.println(":.:.:.:.TELA INICIAL FUNCIONÁRIO.:.:.:.:\n\n");
            System.out.println("1: Autenticar");
            System.out.println("2: Criar nova conta:");
            try{
                seleciona = scan.nextInt();
            }catch(InputMismatchException ex){

            }
            if(seleciona<1||seleciona>2){
                System.out.println("ERROR:Por favor tente novamnete!");
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
                                try{
                                    selecionaMenu = scan.nextInt();
                                }catch(InputMismatchException ex){

                                }
                                if(selecionaMenu<1||selecionaMenu>6){
                                    System.out.println("ERROR:Por favor tente novamnete!");
                                    scan.nextLine();
                                }else {
                                    switch(selecionaMenu){
                                        case 1:
                                            System.out.println(crudLivro);
                                            break;
                                        case 2: 
                                        	try {
                                        		ShowText.readCliente(crudCliente);
                                        	} catch(UsuarioCadastroException ex){
                                        		System.out.println("Não foi possivel cadastrar o usuário! Tente novamente.");
                                        	}
                                            break;
                                        case 3:  System.out.println("Digite novamente o seu email:");
                                                 String email = scan.next();
                                                 System.out.println("Digite a sua senha\n");
                                                 String senha = scan.next();
                                                 if(email.equals("0")&&senha.equals("0")){
                                                     System.out.println("É impossivel deletar o usuário master!");
                                                 }
                                                 else if(crudFuncionario.autentication(email,senha)){
                                                     try{
                                                         Funcionario func = crudFuncionario.buscarFuncionario(email);
                                                         crudFuncionario.deletarEstaConta(func);
                                                     } catch (DeleteUsuarioException ex){
                                                         System.out.println("Erro ao deletar este usuário! Tente novamente.");
                                                     } catch (IOException e){
                                                         System.out.println("ERROR: atualização do arquivo!");
                                                     }
                                                     System.out.println("Funcionário deletado com sucesso!\n");
                                                     continuaMenu=false;
                                                 }else System.out.println("Email ou senha inválido!");
                                            break;
                                        case 4:
                                        	boolean continuaMenuEmprestimo = true;
                                        	while(continuaMenuEmprestimo){
                                                ShowText.gerenciaEmprestimo();
                                                int selecionaM = 0;
                                                try{
                                                    selecionaM = scan.nextInt();
                                                }catch(InputMismatchException ex){

                                                }
                                                if(selecionaM<1||selecionaM>6){
                                                    System.out.println("ERROR:Por favor tente novamente!");
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
                                                        	System.out.println("Informe o código do empréstimo: ");
                                                        	int codigo = -1;
                                                        	try{
                                                        	    codigo = scan.nextInt();
                                                            }catch(InputMismatchException ex){
                                                                System.out.println("ERROR: Valor inválido para código");
                                                            }
                                                        	try{
                                                        	    if(codigo>0)
                                                        		    ShowText.doDevolucao(crudEmprestimo.consulta(codigo), crudDevolucao);
                                                        	    else System.out.println("Código para emprestimo inválido!");
                                                        	} catch(NullPointerException ex){
                                                        		System.out.println("Empréstimo não encontrado! Por favor, informe um empréstimo válido.");
                                                        	}
                                                            break;
                                                        case 3: 
                                                        	try{
                                                        		ShowText.doEmprestimo(crudLivro, crudCliente, crudEmprestimo);
                                                        	}catch (SemLivroException ex){
                                                        		System.out.println("Não há livros cadastrados! Cadastre um livro antes de fazer um empréstimo.");
                                                        	}
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
                                                            try{
                                                                ShowText.readLivro(crudLivro,true);
                                                            }catch(LivroExistenteException ex){
                                                                System.out.println("Já existe um livro com este código. Por favor insira outro código!");
                                                            }catch(IOException ex){
                                                                System.out.println("Erro na atualização do arquivo!");
                                                            }
                                                            break;
                                                        case 2:
                                                            System.out.println("Selecione qual livro deseja deletar:");
                                                            System.out.println(crudLivro);
                                                            int deletar = -1;
                                                            try{
                                                                deletar = scan.nextInt();
                                                            }catch(InputMismatchException ex){
                                                                System.out.println("ERROR: Valor inválido para indice!");
                                                            }
                                                            try{
                                                                if(deletar>0){
                                                                    crudLivro.delete(deletar-1);
                                                                    System.out.println("Livro deletado com sucesso!!!");
                                                                }
                                                                else System.out.println("Valor inválido para indice");
                                                            }catch(IOException ex){
                                                                System.out.println("Erro ao tentar modificar o arquivo!");
                                                            }

                                                            break;
                                                        case 3:
                                                            System.out.println("Selecione qual livro deseja editar:");
                                                            System.out.println(crudLivro);
                                                            int edit = scan.nextInt();
                                                            Livro novo = null;
                                                            try{
                                                                novo = ShowText.readLivro(crudLivro,false);
                                                            }catch(LivroExistenteException ex){
                                                                System.out.println("Já existe um livro com esta matricula, por favor tente novamente!");
                                                            }catch(IOException ex){
                                                                System.out.println("Erro na atualização do arquivo!");
                                                            }
                                                            try{
                                                                crudLivro.update(edit-1,novo);
                                                            }catch(IOException ex){
                                                                System.out.println("Erro na atualização do arquivo!");
                                                            }catch(LivroNaoLidoException ex){
                                                                System.out.println("Ocorreu um erro na leitura do livro, por favor tente novamente!");
                                                            }
                                                            break;
                                                        case 4:
                                                        	boolean continuaMenuAutor = true;
                                                        	while(continuaMenuAutor){
                                                        		ShowText.gerenciaAutores(crudAutor);
                                                        		int opcao = scan.nextInt();
                                                        		if(opcao < 0 || opcao > 4){
                                                        			System.out.println("opção invalida!");
                                                        			opcao = scan.nextInt();
                                                        		}
                                                        		else{
                                                        			switch(opcao){
                                                        			case 1:
                                                        				ShowText.readAutor(crudAutor,true);
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
                                                                        int update = -1;
                                                                        try{
                                                                            update = scan.nextInt();
                                                                        }catch(InputMismatchException ex){
                                                                            System.out.println("Valor inválido para incide!");
                                                                        }
                                                                        Autor autorNovo = null;
                                                                        autorNovo = ShowText.readAutor(crudAutor,false);
                                                                        crudAutor.update(update-1, autorNovo);
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
                        }else System.out.println("Email ou senha inválidos!!!");

                        break;
                    case 2: try{
                                ShowText.readFuncionario(crudFuncionario);
                            }catch(IOException e){
                                System.out.println("ERROR: adicionar funcionario ao arquivo");
                            }
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
