package agenda;

import java.util.Scanner;

public class Agenda {

    private String id;
    private String nome;
    private String telefone;

    public Agenda()
    {
        
    }
    
    public Agenda(String id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    //Construtor para ler
    public Agenda(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
