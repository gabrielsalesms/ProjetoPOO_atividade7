package poo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Pedido {
    private int numero;
    private LocalDate data;
    private String status;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private IPagamento metodoPagamento;
    private StatusPedido statusPedido;

   public Pedido(int numero, String status, LocalDate data, Cliente cliente){
        this.numero = numero;
        this.status = status;
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<>();

    }

    public IPagamento getMetodoPagamento(){
        return metodoPagamento;
    }
    
    public void setMetodoPagamento(IPagamento metodoPagamento){
        this.metodoPagamento = metodoPagamento;
    }

    public void adicionarItem(Produto produto, int quantidade){
        for (ItemPedido item: this.itens){
            if (item.getProduto() == produto){
                item.setQuantidade(item.getQuantidade()+quantidade);
                return;
            }
        }
        this.itens.add(new ItemPedido(produto, quantidade));
    }

    public void removerItem(ItemPedido item){
        this.itens.remove(item);
    }

    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }

    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public LocalDate getData(){
        return this.data;
    }
    public void setData(LocalDate data){
        this.data = data;
    }
    public Cliente getCliente(){ 
        return this.cliente; 
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens(){
        return this.itens; 
    }
    public double calcularTotal(){
        double total = 0.0;
        for (int i = 0; i < itens.size(); i++) {
            total += itens.get(i).getSubtotal();
        }
        return total;
    }

    public double aplicarDesconto (double desconto){
        double valorComDesconto = calcularTotal() - (calcularTotal() * (desconto/100));
        return valorComDesconto;
    }
    public boolean confirmarPedido(){
        if (statusPedido != StatusPedido.PENDENTE){
            return false;
        }
        if (statusPedido == null){
            return false;
        }
       if(metodoPagamento.processarPagamento(this.calcularTotal())){
            statusPedido = StatusPedido.PROCESSANDO;
            return true;
       } else{
            statusPedido = StatusPedido.PENDENTE;
            return false;
       }
    }
}
