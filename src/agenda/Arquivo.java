package agenda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo {

    private String path;
    private String content;

    private static RandomAccessFile arquivo;

    public Arquivo(String path, String content) {
        this.path = path;
        this.content = content;
    }

    public void Buscar() {
        try {
            File file = new File(this.path);
            arquivo = new RandomAccessFile(file, "r");

            String linha;
            while ((linha = arquivo.readLine()) != null) {
                System.out.println(linha);
            }

            System.out.println(arquivo.readLine());

        } catch (IOException e) {
            System.out.println("Arquivo Inexistente");
            System.exit(0);
        }
    }

    public void Inserir() {
        try {
            File file = new File(this.path);

            arquivo = new RandomAccessFile(file, "rw");
            Escrever();

            System.out.println("Foi!");
        } catch (FileNotFoundException e) {
            //No caso do arquivo nao existir  
            System.out.println("Arquivo Inexistente");
            System.exit(0);
        }
    }

    public void Deletar() {
        try {
            File file = new File(this.path);

            arquivo = new RandomAccessFile(file, "rwd");
            Escrever();

            System.out.println("Foi!");
        } catch (FileNotFoundException e) {
            //No caso do arquivo nao existir  
            System.out.println("Arquivo Inexistente");
            System.exit(0);
        }
    }

    //Auxiliares
    private void Escrever() {
        try {
            arquivo.writeChars(content);
        } catch (IOException e) {
            System.out.println("Erro escrevendo no arquivo");
            System.exit(0);
        }
    }
}
