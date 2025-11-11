package poo;
public class PagamentoCartaoCredito implements IPagamento {
    private StatusPagamento statusPagamento;

    @Override
    public boolean processarPagamento( double valor){
        if(valor<5000){
            statusPagamento = StatusPagamento.APROVADO;
            return true;
        } else{
            statusPagamento = StatusPagamento.RECUSADO;
            return false;
        }
    }
    public StatusPagamento getStatus(){
        return statusPagamento;
    }
}
