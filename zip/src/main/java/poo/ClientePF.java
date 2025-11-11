package poo;
public class ClientePF extends Cliente {
    private String cpf;

    public ClientePF(String nome, String email, String cpf){
        super(nome, email);
        this.cpf = cpf;
    }
    public String getCPF(){ 
        return this.cpf;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
}
