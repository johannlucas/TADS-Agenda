package agendaAleatorio;

import agenda.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;

public class Arquivo {

    private String path;
    private Agenda content;

    private static RandomAccessFile arquivo;

    public Arquivo(String path, Agenda content) throws FileNotFoundException {
        this.path = path;
        this.content = content;

        arquivo = new RandomAccessFile(path, "rw");
    }

    public void Inserir() throws IllegalArgumentException, IOException {
        if (content.getId() == 0) {
            System.out.println("ID inválido!");
        } else {
            arquivo.seek((content.getId() - 1) * content.tamanho);

            arquivo.writeInt(content.getId());
            escreverString(content.getNome());
            escreverString(content.getTelefone());

            System.out.println("Arquivo escrito com sucesso!");
        }
    }

    public void Atualizar() throws IOException {
        if (content.getId() == 0) {
            System.out.println("Não é possível atualizar registro inexistente!");
        } else {
            arquivo.seek((content.getId() - 1) * content.tamanho);
            arquivo.writeInt(content.getId());
            escreverString(content.getNome());
            escreverString(content.getTelefone());

            System.out.println("Arquivo atualizado com sucesso!");
        }
    }

    public void Deletar() throws IOException {
        if (content.getId() == 0) {
            System.out.println("Não é possível excluir registro inexistente!");
        } else {
            arquivo.seek((content.getId() - 1) * content.tamanho);
            arquivo.writeInt(0);
            escreverString("");
            escreverString("");

            System.out.println("Arquivo apagado com sucesso!");
        }
    }

    public void Buscar() throws IOException {
        if (content.getId() < 1) {
            System.out.println("Registro não existe!");
        } else {
            arquivo.seek((content.getId() - 1) * content.tamanho);
            System.out.println(arquivo.readInt());
            System.out.println(lerString());
            System.out.println(lerString());
        }
    }

    public void Listar() throws IOException {
        try {
            arquivo.seek(0);
            while (true) {
                do {
                    System.out.println(arquivo.readInt());
                    System.out.println(lerString());
                    System.out.println(lerString());
                } while (content.getId() == 0);
                System.out.println(content.toString());
            }
        } catch (EOFException ex1) {
            return;
        } catch (IOException ex2) {
            System.out.println("Erro ao ler arquivo!");
        }

    }

    private void escreverString(String s) throws IOException {
        StringBuffer buffer;
        buffer = new StringBuffer(s);
        buffer.setLength(15);
        arquivo.writeChars(buffer.toString());
    }

    private String lerString() throws IOException {
        char[] s = new char[15];
        for (int i = 0; i < s.length; i++) {
            s[i] = arquivo.readChar();
        }
        return new String(s).replace('\0', ' ');
    }
}
