package com.ifpb.biblioteca.view;

import com.ifpb.biblioteca.model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Autor stephen = new Autor("Stephen Hawking",23);
        Autor edgar = new Autor("Edgar Allan Poe",34);
        Livro livros[] ={
               new Livro("O gato preto",12,Genero.TERROR,edgar,"Poe conta a história de um homem que, movido pelo abuso de álcool e transtornado pelo amor incondicional que um bicho pode dedicar a seu dono, acaba por enforcar seu próprio gato de estimação. Perseguido pelo fantasma do animal, ele adota outro gato, que, com o passar do tempo, além de despertar a mesma aversão em seu dono, revela, em sua pelagem, a marca da forca."),
               new Livro("Uma Breve História do Tempo",2,Genero.DIDATICO,stephen,"Uma Breve História do Tempo: do Big Bang aos Buracos Negros, é um livro de divulgação científica escrito pelo Professor Stephen Hawking, publicado pela primeira vez em 1988")


        };
        Cliente cliente = new Cliente("Teo",23421,"111.111.111-11","teofanes@email.com","camiulaehlinda123");
        boolean continua = true;
        int seleciona;
        Scanner scan = new Scanner(System.in);
        while(continua){

            System.out.println("1: Adicionar livro");
            System.out.println("2: Editar livro");
            System.out.println("3: Adicionar cliente");
            System.out.println("4: Editar cliente");
            System.out.println("5: Emprestar livro");
            System.out.println("6: Ver livros");
            System.out.println("7: Devolver livro");
            System.out.println("0: Encerrar programa");

            seleciona = scan.nextInt();

            if(seleciona<0){
                System.out.println("ERROR:Press ENTER para continar!");
                scan.nextLine();
            }
            else{

                switch(seleciona){
                    case 1:System.out.println("Cadastro de Livro:");
                        System.out.println("Título:");
                        String titulo = scan.next();
                        System.out.println("Código:");
                        int codigo = scan.nextInt();
                        System.out.println("Gênero \n 1:ROMANCE \n 2:TERROR \n 3:POESIA\n4:FANTASIA\n5:AVENTURA");
                        int genero = scan.nextInt();
                        System.out.println("Autor:");
                        String autor = scan.next();
                        System.out.println("Descrição");
                        String descricao = scan.next();
                        Livro livroNovo = new Livro(titulo,codigo,Genero.ROMANCE,edgar,descricao);
                        System.out.println("LIVRO CADASTRADO COM SUCESSO");
                        break;
                    case 2: System.out.println("Qual livro deseja editar?");
                            System.out.println(livros);
                            System.out.println("Digite o código:");
                            int codigoEditar = scan.nextInt();
                        break;
                    case 3: System.out.println("Cadastro de Cliente");
                        System.out.println("Nome:");
                        String nome = scan.next();
                        System.out.println("Matricula");
                        int matricula = scan.nextInt();
                        System.out.println("CPF");
                        String cpf = scan.next();
                        System.out.println("E-mail:");
                        String email = scan.next();
                        System.out.println("Senha:");
                        String senha = scan.next();
                        Cliente clienteNovo = new Cliente(nome,matricula,cpf,email,senha);
                        System.out.println("CLIENTE CADASTRADO COM SUCESSO");
                        break;
                    case 4:
                        System.out.println("Que cliente deseja editar?");
                        break;
                    case 5: System.out.println("Informe titulo do livro que deseja emprestar");
                        break;
                    case 6: System.out.println("Livros:");
                        break;
                    case 7: System.out.println("Informe título do livro que deseja devolver:");

                        break;

                    case 0: continua = false;
                }
            }
            limpaMinhaTelaUltraAdvancedMaisMais();
        }
        System.out.println("---------FIM---------");

    }
    public static void limpaMinhaTelaUltraAdvancedMaisMais(){
        for (int i=0; i<40;i++) System.out.println("\n");

    }

}
