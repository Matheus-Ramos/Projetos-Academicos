package classes;

public class EstadoPoucasUnidades implements Estado{

    @Override
    public void adicionaProduto(Produtos p) {
        p.setStatus("Poucas Unidades");
    }

    @Override
    public void removeProduto(Produtos p) {

    }
}
