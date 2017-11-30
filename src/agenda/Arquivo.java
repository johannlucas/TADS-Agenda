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

    public void Inserir() throws FileNotFoundException, IOException {

        DataOutputStream stream = new DataOutputStream(new FileOutputStream(this.path, true));

        stream.writeUTF(this.content.getId() + "\n");
        stream.writeUTF(this.content.getNome() + "\n");
        stream.writeUTF(this.content.getTelefone() + "\n");

        stream.flush();
        stream.close();

        System.out.println("Arquivo escrito com sucesso!");
    }

    public void Alterar() throws IOException {

        BufferedReader buff = new BufferedReader(new FileReader(this.path));
        String line;
        while ((line = buff.readLine().trim()) != null) {
            if (line.equals(String.valueOf(this.content.getId()))) {

                String contentToDelete = line + buff.readLine() + buff.readLine();
                System.out.println("Id: " + line);
                System.out.println("Nome: " + buff.readLine().trim());
                System.out.println("Telefone: " + buff.readLine().trim());
                break;
            }
        }
    }

    public void Listar() throws IOException {

        BufferedReader buff = new BufferedReader(new FileReader(this.path));

        String line;
        while ((line = buff.readLine()) != null) {
            System.out.println("Id: " + line.trim());
            System.out.println("Nome: " + buff.readLine().trim());
            System.out.println("Telefone: " + buff.readLine().trim());
            
        }
        
    }

    public void Buscar() throws IOException {

        BufferedReader buff = new BufferedReader(new FileReader(this.path));

        String line;
        while ((line = buff.readLine()) != null) {
            if (line.equals(String.valueOf(this.content.getId()))) {
                System.out.println("Id: " + line);
                System.out.println("Nome: " + buff.readLine().trim());
                System.out.println("Telefone: " + buff.readLine().trim());
            }
        }
    }

    public void Excluir() throws IOException {

        BufferedReader buff = new BufferedReader(new FileReader(this.path));

        File fileAux = new File(new File(this.path).getParent() + "/temp.dat");
        File file = new File(this.path);

        DataOutputStream stream = new DataOutputStream(new FileOutputStream(fileAux));

        String line;

        while ((line = buff.readLine().trim()) != null) {
            if (line.equals(String.valueOf(this.content.getId()))) {

                //Pular duas linhas
                buff.readLine();
                buff.readLine();
            } else {
                stream.writeUTF(buff.readLine());
                stream.writeUTF(buff.readLine());
                stream.writeUTF(buff.readLine());

                //Apagar arquivo antigo
                file.delete();
                fileAux.renameTo(file);
            }
        }
    }
}
