package agenda;

import java.io.IOException;
import java.util.Scanner;

public class Manipular {

    public static void main(String[] args) throws IOException {
		
		//System.out.println("Insira o nome do arquivo: ");
		//Linux
        //String arquivo = "/local/home/tads/Documentos/minhaagenda.dat";
        
        //Windows
        String arquivo = "C:\\Users\\k27394\\Documents\\minhaagenda.dat";
		
        Scanner entrada = new Scanner(System.in);
        Boolean sair = true;

        while (sair) {

            Opcoes();
            switch (entrada.next()) {
                case "1":
                    Inserir();
                    break;
                case "2":
					Alterar();
                    break;
                case "3":
                    Buscar();
                    break;
                case "4":
					Excluir();
                    break;
                default:
                    sair = false;
                    break;
            }
        }
    }

    private static void Opcoes() {
        System.out.println("1- Inserir");
        System.out.println("2- Alterar");
        System.out.println("3- Buscar");
        System.out.println("4- Excluir");
        System.out.println("5- Sair");
    }

    private static void Inserir() throws IOException {
        Scanner entrada = new Scanner(System.in);
        //Pedir informacoes
        System.out.println("Insira um ID");
        String id = entrada.next();
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
    
	
	private static void Alterar() throws IOException{
		Scanner entrada = new Scanner(System.in);
        //Pedir informacoes
        System.out.println("Insira um ID");
        int id = entrada.nextInt();

        //Instanciando agenda
        Agenda age = new Agenda(id);

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, age);
        //Buscar arquivo
        arq.Alterar();
	}
	
    private static void Buscar() throws IOException {
        Scanner entrada = new Scanner(System.in);
        //Pedir informacoes
        System.out.println("Insira um ID");
        int id = entrada.nextInt();

        //Instanciando agenda
        Agenda age = new Agenda(id);

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, age);
        //Buscar arquivo
        arq.Buscar();
    }
	
	private static void Excluir() throws IOException{
		Scanner entrada = new Scanner(System.in);
        //Pedir informacoes
        System.out.println("Insira um ID");
        int id = entrada.nextInt();

        //Instanciando agenda
        Agenda age = new Agenda(id);

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, age);
        //Buscar arquivo
        arq.Excluir();
	}
	
	public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
	
}
