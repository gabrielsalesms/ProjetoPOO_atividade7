package poo;
public class PagamentoBoleto implements IPagamento {
    private StatusPagamento statusPagamento;
    @Override
    public boolean processarPagamento( double valor){
        if(valor<1000){
            statusPagamento = StatusPagamento.APROVADO;
            return true;
        } else{
            return false;
        }
    }

}