package com.ifpb.biblioteca.view;

import com.ifpb.biblioteca.control.*;
import com.ifpb.biblioteca.exceptions.*;
import com.ifpb.biblioteca.model.Cliente;
import com.ifpb.biblioteca.model.Funcionario;
import com.ifpb.biblioteca.model.Livro;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
//    private static CadastroAutor crudAutor;


	public static void main(String[] args) {
        CadastroFuncionario crudFuncionario = null;
        CadastroLivro crudLivro = null;
        CadastroCliente crudCliente = null;
	    try{
            crudFuncionario = new CadastroFuncionario();
        }catch(Exception e){
            System.err.println("Error: Fluxo de cadastro de funcionarios!");
            System.exit(1);
        }
        try{
            crudLivro = new CadastroLivro();
        }catch(IOException ex){
            System.err.println("Erro: Fluxo de cadastro de Livros!");
            System.exit(1);
        }catch(ClassNotFoundException ex){
            System.err.println("errrr");
        }
        try{
	        crudCliente = new CadastroCliente();
        }catch(Exception e){
            System.err.println("Erro: Fluxo de cadastro de cliente");
            System.exit(1);
        }
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
                System.err.println("VALOR INVALIDO!");
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
                                    System.err.println("VALOR INVALIDO!");
                                    scan.nextLine();
                                }
                                if(selecionaMenu<1||selecionaMenu>6){
                                    System.err.println("ERROR:Por favor tente novamente!");
                                    scan.nextLine();
                                }else {
                                    switch(selecionaMenu){
                                        case 1:
                                            System.out.println(crudLivro);
                                            break;
                                        case 3:
                                            boolean continuaClientes = true;
                                            while(continuaClientes){
                                                ShowText.gerenciaCliente();
                                                int selecionaC = 0;
                                                try{
                                                    selecionaC = scan.nextInt();
                                                }catch(InputMismatchException ex){
                                                    System.err.println("VALOR INVALIDO!");
                                                    scan.nextLine();
                                                }
                                                if(selecionaC<1||selecionaC>5){
                                                    System.err.println("ERROR:Por favor tente novamente!");
                                                    scan.nextLine();
                                                }else{
                                                    switch(selecionaC){
                                                        case 1: try{
                                                                    ShowText.readCliente(crudCliente,true);
                                                                }catch(UsuarioCadastroException ex){
                                                                    System.err.println("Este usuário já existe!");
                                                                }catch(IOException ex){
                                                                    System.err.println("ERROR: Atualização do arquivo!");
                                                                }
                                                                break;
                                                        case 2: System.out.println("Digite o email do cliente:");
                                                                String email = scan.next();
                                                                System.out.println("Digite a senha do cliente:");
                                                                String senha = scan.next();
                                                                if(crudCliente.autentication(email,senha)){
                                                                    try{
                                                                        Cliente novo  = ShowText.readCliente(crudCliente,false);
                                                                        try{
                                                                            crudCliente.update(email,senha,novo);
                                                                        }catch(ClienteInexistenteException ex){
                                                                            System.err.println("Os dados não foram lidos corretamente!");
                                                                        }
                                                                    }catch(UsuarioCadastroException ex){
                                                                        System.err.println("Este Cliente já existe!");
                                                                    }catch(IOException ex){
                                                                        System.err.println("Error: Atualização do arquivo!");
                                                                    }
                                                                }else{
                                                                    System.out.println("Email ou senha inválidos!");
                                                                }
                                                                break;
                                                        case 3: if(!crudCliente.isEmpty()){
                                                                    System.out.println("Selecione o cliente que deseja deletar");
                                                                    int choice = 0;
                                                                    System.out.println(crudCliente);
                                                                    try{
                                                                      choice = scan.nextInt();
                                                                    }catch(InputMismatchException ex){
                                                                       System.err.println("ERROR: Valor para incide invalido!");
                                                                    }
                                                                    if(choice>0){
                                                                      try{
                                                                          crudCliente.delete(choice-1);
                                                                          System.out.println("Cliente deletado com sucesso!");
                                                                    }catch(IOException ex){
                                                                        System.err.println("ERROR: Atualização de arquivo!");
                                                                      }
                                                                    }else{
                                                                        System.out.println("Valor invalido, tente novamente!");
                                                                    }
                                                                }else{
                                                                    System.out.println("Não temos clientes cadastrados!");
                                                                }
                                                                break;
                                                        case 4: System.out.println(crudCliente);
                                                                break;
                                                        case 5: continuaClientes = false;
                                                                break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 2:  System.out.println("Digite novamente o seu email:");
                                                 String email = scan.next();
                                                 System.out.println("Digite a sua senha\n");
                                                 String senha = scan.next();
                                                 if(email.equals("0")&&senha.equals("0")){
                                                     System.err.println("É impossivel deletar o usuário master!");
                                                 }
                                                 else if(crudFuncionario.autentication(email,senha)){
                                                     try{
                                                         Funcionario func = crudFuncionario.buscarFuncionario(email);
                                                         crudFuncionario.deletarEstaConta(func);
                                                     } catch (DeleteUsuarioException ex){
                                                         System.err.println("Erro ao deletar este usuário! Tente novamente.");
                                                     } catch (IOException e){
                                                         System.err.println("ERROR: atualização do arquivo!");
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
                                                    System.err.println("VALOR INVALIDO!");
                                                }
                                                if(selecionaM<1||selecionaM>6){
                                                    System.err.println("ERROR:Por favor tente novamente!");
                                                    scan.nextLine();
                                                }
                                                else{
                                                    switch(selecionaM){
                                                        case 1:
                                                            if(crudEmprestimo.toString().equals("")){
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
                                                                System.err.println("ERROR: Valor inválido para código");
                                                            }
                                                        	    try{
                                                        	    	ShowText.doDevolucao(crudEmprestimo.consulta(codigo), crudDevolucao, crudEmprestimo, codigo);
                                                        	    }catch(EmprestimoInexistenteException ex){
                                                        	    	System.out.println("Código para emprestimo inválido! Por favor, informe um código válido.");
                                                        	    }
                                                            break;
                                                        case 3: 
                                                        	try{
                                                        		ShowText.doEmprestimo(crudLivro, crudCliente, crudEmprestimo);
                                                        	}catch (SemLivroException ex){
                                                        		System.out.println("Não há livros cadastrados! Cadastre um livro antes de fazer um empréstimo.");
                                                        	}catch (LivroInexistenteException ex){
                                                        		System.out.println("Livro nao existente. Por favor, informe um livro existente.");
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
                                                int selecionaM = 0;
                                                try{
                                                    selecionaM = scan.nextInt();
                                                }catch(InputMismatchException ex){
                                                    System.err.println("VALOR INVALIDO!");
                                                }
                                                if(selecionaM<1||selecionaM>4){
                                                    System.err.println("ERROR:Por favor tente novamente!");
                                                    scan.nextLine();
                                                }
                                                else{
                                                    switch(selecionaM){
                                                        case 1:
                                                            try{
                                                                ShowText.readLivro(crudLivro,true);
                                                            }catch(LivroExistenteException ex){
                                                                System.err.println("Já existe um livro com este código. Por favor insira outro código!");
                                                            }catch(IOException ex){
                                                                System.err.println("Erro na atualização do arquivo!");
                                                            }
                                                            break;
                                                        case 2:
                                                            System.out.println("Selecione qual livro deseja deletar:");
                                                            System.out.println(crudLivro);
                                                            int deletar = -1;
                                                            try{
                                                                deletar = scan.nextInt();
                                                            }catch(InputMismatchException ex){
                                                                System.err.println("ERROR: Valor inválido para indice!");
                                                            }
                                                            try{
                                                                if(deletar>0){
                                                                    crudLivro.delete(deletar-1);
                                                                    System.out.println("Livro deletado com sucesso!!!");
                                                                }
                                                                else System.out.println("Valor inválido para indice");
                                                            }catch(IOException ex){
                                                                System.err.println("Erro ao tentar modificar o arquivo!");
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
                                                                System.err.println("Já existe um livro com esta matricula, por favor tente novamente!");
                                                            }catch(IOException ex){
                                                                System.err.println("Erro na atualização do arquivo!");
                                                            }
                                                            try{
                                                                crudLivro.update(edit-1,novo);
                                                            }catch(IOException ex){
                                                                System.err.println("Erro na atualização do arquivo!");
                                                            }catch(LivroNaoLidoException ex){
                                                                System.err.println("Ocorreu um erro na leitura do livro, por favor tente novamente!");
                                                            }
                                                            break;
                                                        case 4:
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
                                System.err.println("ERROR: adicionar funcionario ao arquivo");
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

}
