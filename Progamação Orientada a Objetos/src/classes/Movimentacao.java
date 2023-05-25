package classes;

import java.util.Scanner;

public class Movimentacao implements Base{

    private String dataMovimentacao;
    private String Destino;
    private String Origem;
    private int idProduto;
    private String tipoProduto;
    private int idResponsavel;
    private int id;

    Scanner input = new Scanner(System.in);
    TipoProduto tp = new TipoProduto();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIdResponsavel(int idResponsavel){
        this.idResponsavel = idResponsavel;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setTipoProduto(String tipoProduto){
        this.tipoProduto = tipoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setDestino(String Destino){
        this.Destino = Destino;
    }

    public String getDestino() {
        return Destino;
    }

    public void setOrigem(String Origem){
        this.Origem = Origem;
    }

    public String getOrigem() {
        return Origem;
    }

    public void setDataMovimentacao(String dataMovimentacao){
        this.dataMovimentacao =  dataMovimentacao;
    }

    public String getDataMovimentacao() {
        return  dataMovimentacao;
    }

    public void imprimir() {

        if (getId() != -1) {
            System.out.println("********RELATÓRIO DA MOVIMENTAÇÃO:********");
            System.out.println("Identificação da Movimentação: " + getId());
            System.out.println("Data da Movimentação: " + getDataMovimentacao());
            System.out.println("Produto: " + getIdProduto());
            System.out.println("Categoria do Produto: " +  getTipoProduto());
            System.out.println("Origem da Movimentação: " + getOrigem());
            System.out.println("Destino da Movimentação: " + getDestino());
            System.out.println("ID do Responsavel da Movimentação: " + getIdResponsavel());
            System.out.println("******************************************");
        } else {
            System.out.println("Empregado não existente");
        }
        System.out.println();
    }

    public void adicionar() throws Exception {// Adição de uma movimentacao

        int aux1;
        String aux2;

        System.out.println("Informe o código de identificação da Movimentação: ");
        aux1 = input.nextInt();
        input.nextLine();
        setId(aux1);
        System.out.println("Informe a Identificação do Responsavel: ");
        aux1 = input.nextInt();
        setIdResponsavel(aux1);
        input.nextLine();
        System.out.println("Informe a Identificação do Produto:  ");
        aux1 = input.nextInt();
        setIdProduto(aux1);
        input.nextLine();
        //Categoria do Produto
        aux2 = tp.CategoriaProduto();
        setTipoProduto(aux2);
        //Categoria do Produto
        System.out.println("Informe O Destino do Produto: ");
        aux2 = input.nextLine();
        setDestino(aux2);
        System.out.println("Informe a Origem do Produto:");
        aux2 = input.nextLine();
        setOrigem(aux2);
        System.out.println("Informe a Data da Movimentação do Produto:(hh:mm DD/MM/YYYY)");
        aux2 = input.nextLine();
        setDataMovimentacao(aux2);
        System.out.println();
        imprimir();
    }

    public void M_Inicial() {// função de apoio

        System.out.println("Informe o campo que deseja alterar:");
        System.out.println("ID(1);\n" + "Identificação do Responsavel(2);\n" + "Identificação do Produto(3);\n" + "Categoria do Produto(4);\n"
                + "Destino do Produto(5);\n" + "Origem do Produto(6);\n" + "Data da Movimentação do Produto(7);\n" + "Sair(8).");
    }

    public void editar() throws Exception{// Alterar detalhes de uma movimentacao

        int opcao = 1;
        int aux1;
        String aux2;
        double aux3;

        while (opcao != 8) {

            M_Inicial();
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Informe o Novo Id (atual: " + getId() + "): ");
                    aux1 = input.nextInt();
                    setId(aux1);
                    input.nextLine();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Informe a Nova Identificação do Responsavel (atual: " + getIdResponsavel() + "): ");
                    aux1 = input.nextInt();
                    setIdResponsavel(aux1);
                    input.nextLine();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Informe a Nova Identificação do Produto (atual: " + getIdProduto() + "): ");
                    aux1 = input.nextInt();
                    setIdProduto(aux1);
                    input.nextLine();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Categoria Atual: " + getTipoProduto());
                    //Categoria do Produto
                    aux2 = tp.CategoriaProduto();
                    setTipoProduto(aux2);
                    //Categoria do Produto
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Informe O Novo Destino do Produto (atual: " + getDestino() + "): ");
                    aux2 = input.nextLine();
                    setDestino(aux2);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Informe a Nova Origem do Produto (atual: " + getOrigem() + "): ");
                    aux2 = input.nextLine();
                    setOrigem(aux2);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Informe a Nova Data da Movimentação do Produto:(hh:mm DD/MM/YYYY) (atual: " + getDataMovimentacao() + "): ");
                    aux2 = input.nextLine();
                    setDataMovimentacao(aux2);
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Modificações Salvas!!");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção Invalida!!!");
                    System.out.println("Digite Novamente");
                    System.out.println();
            }
        }
        imprimir();
    }
}
