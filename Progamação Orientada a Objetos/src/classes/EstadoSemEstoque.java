package classes;

public class EstadoSemEstoque implements Estado{

    @Override
    public void adicionaProduto(Produtos p) {
        p.setStatus("Sem Estoque");
    }

    @Override
    public void removeProduto(Produtos p) {

    }
}
