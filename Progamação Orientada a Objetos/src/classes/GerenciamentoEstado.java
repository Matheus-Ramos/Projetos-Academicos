package classes;

public class GerenciamentoEstado{

    private Estado estadoAtual;

    public GerenciamentoEstado() {
        this.estadoAtual = new EstadoDisponivel();// define o estado inicial do estoque
    }

    public void mudarParaEstadoDisponivel() {
        this.estadoAtual = new EstadoDisponivel();
    }

    public void mudarParaEstadoPoucasUnidades() {
        this.estadoAtual = new EstadoPoucasUnidades();
    }

    public void mudarParaEstadoSemEstoque() {
        this.estadoAtual = new EstadoSemEstoque();
    }

    public void adicionaProduto(Produtos p) {
        this.estadoAtual.adicionaProduto(p);
    }

    public void removeProduto(Produtos p) {
        this.estadoAtual.removeProduto(p);
    }

    public void verificaQuantidade(Produtos p){
        if(p.getQuantidade() > 50){
            mudarParaEstadoDisponivel();//EstadoDisponivel
        }else if(p.getQuantidade() <= 50 && p.getQuantidade() > 0){
            mudarParaEstadoPoucasUnidades();//EstadoPoucasUnidades
        }else{ // if(p.getQuantidade() == 0)
            mudarParaEstadoSemEstoque() ;//EstadoSemEstoque
        }
    }
/*
    public void trocaEstado(){
        super.editar();
        setStatus(verificaQuantidade());
    }*/


}
