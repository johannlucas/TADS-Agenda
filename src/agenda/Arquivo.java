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
import java.nio.file.Files;

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

        stream.writeUTF(this.content.getId().trim() + "\n");
        stream.writeUTF(this.content.getNome().trim() + "\n");
        stream.writeUTF(this.content.getTelefone().trim() + "\n");

        stream.flush();
        stream.close();

        System.out.println("Arquivo escrito com sucesso!");
    }
    
    public void ExcluirAlterar(Boolean alterar) throws IOException {

        File fileAux = new File(new File(this.path).getParent() + "/temp.dat");

        try {
            BufferedReader buff = new BufferedReader(new FileReader(this.path));

            File file = new File(this.path);

            DataOutputStream stream = new DataOutputStream(new FileOutputStream(fileAux));

            String line;

            while ((line = buff.readLine()) != null) {
                if (line.trim().equals(String.valueOf(this.content.getId()))) {

                    //Pular duas linhas
                    if (alterar) {
                        stream.writeUTF(this.content.getId().trim() + "\n");
                        stream.writeUTF(this.content.getNome().trim() + "\n");
                        stream.writeUTF(this.content.getTelefone().trim() + "\n");
                    }

                    buff.readLine();
                    buff.readLine();
                } else {
                    stream.writeUTF(line.trim() + "\n");
                    stream.writeUTF(buff.readLine().trim() + "\n");
                    stream.writeUTF(buff.readLine().trim() + "\n");
                }
            }

            //Apagar arquivo antigo
            file.delete();
            fileAux.renameTo(new File(this.path));

            stream.flush();
            stream.close();

        } catch (Exception e) {
            if (fileAux.exists()) {
                fileAux.delete();
            }
        }
    }
    
    public void Buscar() throws IOException {

        BufferedReader buff = new BufferedReader(new FileReader(this.path));

        String line;
        while ((line = buff.readLine()) != null) {
            if (line.trim().equals(String.valueOf(this.content.getId()))) {
                System.out.println("Id: " + line.trim());
                System.out.println("Nome: " + buff.readLine().trim());
                System.out.println("Telefone: " + buff.readLine().trim());
                break;
            } else {
                buff.readLine();
                buff.readLine();
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
}
