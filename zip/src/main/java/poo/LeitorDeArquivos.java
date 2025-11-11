package poo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LeitorDeArquivos {
    public static void main(String[] args) {
        BufferedReader leitor = null;
        try {
            FileReader fileReader = new FileReader("produtos.cvs");
            leitor = new BufferedReader(fileReader);
            String linha = leitor.readLine();
            System.out.println(linha);
            while((linha = leitor.readLine())!=null){
                System.out.println(linha);
                String[] colunas = linha.split(",");
                String id = (colunas[0]);
                String nome = (colunas[1]);
                double preco = Double.valueOf(colunas[2]);
            }

        } catch (IOException e) {
            System.err.printf("Arquivo não encontrado!\n");
        } finally{
            try {
                leitor.close();
            } catch (IOException e) {}
            System.out.println("Entrou no finally!\n");
        }
    }
}
