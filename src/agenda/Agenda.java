package agenda;

import java.util.Scanner;

public class Agenda {

    private String nome;
    private String telefone;
    private String endereco;
    private String data;
    
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Agenda(String nome, String telefone, String endereco, String data) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.data = data;
    }

    @Override
    public String toString() {
        
        return this.nome
                + "\t"
                + this.telefone
                + "\t"
                + this.endereco
                + "\t"
                + this.data;
    }
    
    
}
