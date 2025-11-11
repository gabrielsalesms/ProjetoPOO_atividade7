package poo;
public class Cliente {
    private String nome;
    private String email;
    private int idade;

    public Cliente(String nome, String email){ 
        this.nome = nome;
        this.email = email;
    }

    public String getNome(){ 
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getIdade(){ 
        return this.idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
