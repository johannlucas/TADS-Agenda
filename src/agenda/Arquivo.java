package agenda;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo {

    private String path;
    private Agenda content;

    private static RandomAccessFile arquivo;

    public Arquivo(String path, Agenda content) {
        this.path = path;
        this.content = content;
    }

    public void Buscar() throws FileNotFoundException, IOException {
        
        BufferedReader buff = new BufferedReader(new FileReader(this.path));
        
        String line;
        while ((line = buff.readLine().trim()) != null) {
            if (line.equals(String.valueOf(this.content.getId()))) {
                System.out.println("Id: " + line);
                System.out.println("Nome: " + buff.readLine().trim());
                System.out.println("Telefone: " + buff.readLine().trim());

                break;
            }
        }
    }

    public void Inserir() throws FileNotFoundException, IOException {

        DataOutputStream stream = new DataOutputStream(
                new FileOutputStream(this.path, true));

        stream.writeUTF(this.content.getId() + "\n");
        stream.writeUTF(this.content.getNome() + "\n");
        stream.writeUTF(this.content.getTelefone() + "\n");

        stream.flush();
        stream.close();

        System.out.println("Arquivo escrito com sucesso!");
    }

    public void Deletar() {

    }
}
