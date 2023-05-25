package classes;

public class EstadoDisponivel implements Estado{

    @Override
    public void adicionaProduto(Produtos p) {
        p.setStatus("Disponivel");
    }

    @Override
    public void removeProduto(Produtos p) {

    }
}
