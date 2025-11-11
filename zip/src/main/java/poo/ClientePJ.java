package poo;
public class ClientePJ extends Cliente{
    private String cnpj;

    public ClientePJ(String nome, String email, String cnpj){
        super(nome, email);
        this.cnpj = cnpj;
    }
    public String getCNPJ(){ 
        return this.cnpj;
    }
    public void setCPF(String cnpj){
        this.cnpj = cnpj;
    }
    
}