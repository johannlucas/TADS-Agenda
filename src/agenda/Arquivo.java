package agenda;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    public void Buscar() {
//        try {
//            File file = new File(this.path);
//            arquivo = new RandomAccessFile(file, "r");
//
//            String linha;
//            while ((linha = arquivo.readLine()) != null) {
//                System.out.println(linha);
//            }
//
//            System.out.println(arquivo.readLine());
//
//        } catch (IOException e) {
//            System.out.println("Arquivo Inexistente");
//            System.exit(0);
//        }
    }

    public void Inserir() throws FileNotFoundException {
        
        DataOutputStream stream = new DataOutputStream(
        new FileOutputStream(this.path));
        
        
    }

    public void Deletar() {
        
    }
}
