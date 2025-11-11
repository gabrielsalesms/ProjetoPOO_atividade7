package poo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SistemaPedidos {
    public static void main(String[] args) {
        SpringApplication.run(SistemaPedidos.class, args);
    }
    @GetMapping("/produtos")
    public List<Produto> produtos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            FileReader reader = new FileReader("produtos.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linha = bufferedReader.readLine();
            while ((linha = bufferedReader.readLine()) != null) {
                if (linha.isBlank()) continue;
                String[] colunas = linha.split(",");
                String id = colunas[0];
                String nome = colunas[1];
                double preco = Double.parseDouble(colunas[2]);
                String descricao = colunas[3];
                int estoque = Integer.parseInt(colunas[4]);
                Produto produto = new Produto(id, nome, preco, estoque, descricao);
                produtos.add(produto);
            }
        } catch (IOException e) {
        }
        return produtos;
    }
}