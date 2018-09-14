package com.ifpb.biblioteca.view;

import com.ifpb.biblioteca.control.*;
import com.ifpb.biblioteca.model.*;
//Menu de teste incompleto
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CadastroAutor crudAutor = new CadastroAutor();
        CadastroCliente crudCliente = new CadastroCliente();
        CadastroEmprestimos crudEmprestimo = new CadastroEmprestimos();
        CadastroLivro crudLivro = new CadastroLivro();
        CadastroFuncionario crudFuncionario = new CadastroFuncionario();
        ShowText menu = new ShowText();


        boolean continua = true;
        int seleciona;
        int selecionaMenu;
        Scanner scan = new Scanner(System.in);


        while(continua){
            System.out.println(":.:.:.:.TELA INICIAL.:.:.:.:\n\n");
            System.out.println("1: Autenticar");
            System.out.println("2: Criar nova conta:");
            seleciona = scan.nextInt();

            if(seleciona<0||seleciona>2){
                System.out.println("ERROR:Press ENTER para continar!");
                scan.nextLine();
            }
            else{
                switch(seleciona){
                    case 1:
                        if(menu.login(crudFuncionario)){
                            System.out.println("Login feito com sucesso!!!");
                            boolean continuaMenu = true;
                            while(continuaMenu) {
                                menu.menuFuncionario();
                                selecionaMenu = scan.nextInt();
                                if(selecionaMenu<1||selecionaMenu>6){
                                    System.out.println("ERROR:Press ENTER para continar!");
                                    scan.nextLine();
                                }else {
                                    int selecionaFunc;
                                    switch(selecionaMenu){
                                        case 1:
                                            System.out.println(crudLivro);
                                            break;
                                        case 2: menu.readCliente(crudCliente);
                                            break;
                                        case 3:  System.out.println("Digite novamente o seu email:");
                                                 String email = scan.next();
                                                 System.out.println("Digite a sua senha\n");
                                                 String senha = scan.next();
                                                 crudFuncionario.deleteThis(email, senha);
                                                 System.out.println("Funcionário deletado com sucesso!\n");
                                                 continuaMenu=false;
                                            break;
                                        case 4:
                                            boolean continuaM = true;
                                            int index;
                                            while(continuaMenu){
                                                menu.gerenciaEmprestimo();
                                                int selecionaM = scan.nextInt();
                                                if(selecionaM<1||selecionaM>6){
                                                    System.out.println("ERROR:Press ENTER para continar!");
                                                    scan.nextLine();
                                                }
                                                else{
                                                    switch(selecionaM){
                                                        case 1:
                                                            System.out.println(crudEmprestimo);
                                                            break;
                                                        case 2:
                                                            break;
                                                        case 3: menu.doEmprestimo(crudLivro, crudCliente, crudEmprestimo);
                                                            break;
                                                        case 4:
                                                         continuaM = false;
                                                            break;

                                                    }
                                                }
                                            }

                                            break;
                                        case 5:  boolean continuaL = true;
                                            int indexL;
                                            while(continuaL){
                                                menu.gerenciaLivros();
                                                int selecionaM = scan.nextInt();
                                                if(selecionaM<1||selecionaM>5){
                                                    System.out.println("ERROR:Press ENTER para continar!");
                                                    scan.nextLine();
                                                }
                                                else{
                                                    switch(selecionaM){
                                                        case 1:
                                                            menu.readLivro(crudLivro);
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
                                                            int editar = scan.nextInt();

                                                            //crudLivro.update(editar, );
                                                            break;
                                                        case 4:
                                                            continuaM = false;
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
                        }else System.out.println("Funcionário não cadastrado!!!");

                        break;
                    case 2: menu.readFuncionario(crudFuncionario);

                        break;

                    case 0: continua = false;
                }
            }
            limpaTela();
        }
        System.out.println("::.:.:.:.:.:FIM::.:.:.:.:.:");


    }


    public static void limpaTela(){
        for (int i=0; i<30;i++) System.out.println("\n");

    }

}
