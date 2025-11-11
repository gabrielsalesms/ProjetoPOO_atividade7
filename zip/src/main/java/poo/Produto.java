package poo;
public class Produto {
    private String nome;
    private double preco;
    private int estoque;
    private String descricao;
    private String id;
    public Produto(String id, String nome, double preco, int estoque, String descricao){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.descricao = descricao;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public double getPreco(){
        return this.preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public int getEstoque(){
        return this.estoque;
    }
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
    public void adicionarEstoque(int quantidade){
        if(quantidade>0){
            this.estoque = this.estoque + quantidade;
        }
    }
}