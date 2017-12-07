package agendaAleatorio;

import agenda.*;
import java.util.Scanner;

public class Agenda {

    private int id;
    private String nome;
    private String telefone;
    
    public static int tamanho = Integer.BYTES + (2 * (Character.BYTES * 15));

    public Agenda()
    {
        
    }
    
    public Agenda(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    //Construtor para ler
    public Agenda(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        
        return this.id
                + "\n"
                + this.nome
                + "\n"
                + this.telefone
                + "\n";
    }
}
