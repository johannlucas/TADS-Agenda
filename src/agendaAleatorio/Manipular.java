package agendaAleatorio;

import agenda.*;
import java.io.IOException;
import java.util.Scanner;

public class Manipular {

    /////COLOCAR ARQUIVO AQUI/////
    //Windows
    //String arquivo = "C:\\Users\\k27394\\Documents\\minhaagenda.dat";
    String arquivo = "D:\\TADS\\Agenda\\minhaagenda.dat";
    //Linux
    //String arquivo = "/local/home/tads/Documentos/minhaagenda.dat";

    public static void main(String[] args) throws IOException {

        //System.out.println("Insira o nome do arquivo: ");
        //Linux
        //String arquivo = "/local/home/tads/Documentos/minhaagenda.dat";
        //Windows
        Manipular contexto = new Manipular();

        Scanner entrada = new Scanner(System.in);
        Boolean sair = true;

        System.out.println("------------------------------------------");
        System.out.println("-------------Olá! Bem vindo!--------------");
        System.out.println("------------------------------------------");
        
        while (sair) {

            Opcoes();
            switch (entrada.next()) {
                case "1":
                    contexto.Inserir();
                    break;
                case "2":
                    contexto.Alterar();
                    break;
                case "3":
                    contexto.Buscar();
                    break;
                case "4":
                    contexto.Listar();
                    break;
                case "5":
                    contexto.Excluir();
                    break;
                default:
                    sair = false;
                    System.out.println("------------------------------------------");
                    System.out.println("----------------Até mais!-----------------");
                    System.out.println("------------------------------------------");
                    break;
            }
        }
    }

    private static void Opcoes() {
        System.out.println("1- Inserir");
        System.out.println("2- Alterar");
        System.out.println("3- Buscar");
        System.out.println("4- Listar");
        System.out.println("5- Excluir");
        System.out.println("6- Sair");
    }

    private void Inserir() throws IOException {
        Scanner entrada = new Scanner(System.in);
        //Pedir informacoes
        System.out.println("Insira um ID");
        int id = entrada.nextInt();
        System.out.println("Insira um nome: ");
        String nome = entrada.next();
        //String nome = padRight(entrada.next(), 10);
        System.out.println("Insira um telefone: ");
        String telefone = entrada.next();
        //String telefone = padRight(entrada.next(), 8);

        //Instanciando agenda
        Agenda age = new Agenda(id, nome, telefone);

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, age);
        //Salvar arquivo
        arq.Inserir();
    }

    private void Alterar() throws IOException {
        Scanner entrada = new Scanner(System.in);
        //Pedir informacoes
        System.out.println("Insira o ID do registro que você quer alterar:");
        int id = entrada.nextInt();
        System.out.println("Insira um nome: ");
        String nome = entrada.next();
        System.out.println("Insira um telefone: ");
        String telefone = entrada.next();

        //Instanciando agenda
        Agenda age = new Agenda(id, nome, telefone);

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, age);
        //Buscar arquivo
        arq.Atualizar();
    }

    private void Buscar() throws IOException {
        Scanner entrada = new Scanner(System.in);

        //Pedir informacoes
        System.out.println("Insira um ID");
        int id = entrada.nextInt();

        //Instanciando agenda
        Agenda age = new Agenda(id);

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, age);
        
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        
        //Buscar arquivo
        arq.Buscar();
        
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
    }

    private void Excluir() throws IOException {
        Scanner entrada = new Scanner(System.in);
        //Pedir informacoes
        System.out.println("Insira um ID");
        int id = entrada.nextInt();

        //Instanciando agenda
        Agenda age = new Agenda(id);

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, age);
        //Buscar arquivo
        arq.Deletar();
    }

    private void Listar() throws IOException {
        //Pedir informacoes
        System.out.println("Agenda completa");
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, new Agenda());
        //Buscar arquivo
        arq.Listar();
        
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

}
