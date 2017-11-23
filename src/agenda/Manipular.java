/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author tads
 */
public class Manipular {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Boolean sair = true;

        while (sair) {
            
            Opcoes();
            switch (entrada.next()) {
                case "1":
                    Inserir();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    sair = false;
                    break;
            }
        }

    }
    
    private static void Opcoes()
    {
        System.out.println("1- Inserir");
        System.out.println("2- Atualizar");
        System.out.println("3- Listar");
        System.out.println("4- Deletar");
        System.out.println("5- Sair");
    }

    private static void Inserir() {
        Scanner entrada = new Scanner(System.in);

        //Pedir informacoes
        System.out.println("Insira um nome: ");
        String nome = entrada.next();
        System.out.println("Insira um telefone: ");
        String telefone = entrada.next();
        System.out.println("Insira um endereço: ");
        String endereco = entrada.next();
        System.out.println("Insira uma data de nascimento: ");
        String data = entrada.next();
        //System.out.println("Insira o nome do arquivo: ");
        String arquivo = "/local/home/tads/Documentos/minhaagenda.txt";

        //Instanciando agenda
        Agenda age = new Agenda(nome, telefone, endereco, data);

        //Instanciando arquivo
        Arquivo arq = new Arquivo(arquivo, age.toString());
        //Salvar arquivo
        arq.Inserir();
    }
}
