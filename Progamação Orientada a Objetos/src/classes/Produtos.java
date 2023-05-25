package classes;

import java.util.Scanner;

public class Produtos implements Base{

    public int id;
    public String nome;
    public String tamanho;
    public String cor;
    public String marca;
    public float preco;
    public String categoria;
    public String fabricante;
    public String fornecedor;
    public int quantidade;
    public String status;

    Scanner input = new Scanner(System.in);
    TipoProduto tp = new TipoProduto();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    public float getPreco(){
        return preco;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }

    public String getFabricante(){
        return fabricante;
    }

    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }

    public String getFornecedor(){
        return fornecedor;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void imprimir() {

        if (getId() != -1) {
            System.out.println("***********RELATÓRIO DO PRODUTO:**********");
            System.out.println("Identificação: " + getId());
            System.out.println("Nome: " + getNome());
            System.out.println("Tamanho: " + getTamanho());
            System.out.println("Cor: " + getCor());
            System.out.println("Marca: " + getMarca());
            System.out.println("Preço: " + getPreco());
            System.out.println("Categoria: " + getCategoria());
            System.out.println("Fabricante: " + getFabricante());
            System.out.println("Fornecedor: " + getFornecedor());
            System.out.println("Quantidade: " + getQuantidade());
            System.out.println("Status do Produto: " + getStatus());
            System.out.println("Localidade: Matriz");
            System.out.println("******************************************");
        } else {
            System.out.println("Produto não existente");
        }
        System.out.println();
    }

    public void adicionar () throws Exception {// Adição de um produto

        int aux1;
        String aux2;
        float aux3;

        System.out.println("Informe o código de identificação do produto: ");
        aux1 = input.nextInt();
        input.nextLine();
        setId(aux1);
        System.out.println("Informe o Nome: ");
        aux2 = input.nextLine();
        setNome(aux2);
        System.out.println("Informe o Tamanho: ");
        aux2 = input.nextLine();
        setTamanho(aux2);
        System.out.println("Informe a cor: ");
        aux2 = input.nextLine();
        setCor(aux2);
        System.out.println("Informe a marca: ");
        aux2 = input.nextLine();
        setMarca(aux2);
        System.out.println("Informe o preco: ");
        aux3 = input.nextFloat();
        input.nextLine();
        setPreco(aux3);
        //Categoria do Produto
        aux2 = tp.CategoriaProduto();
        setCategoria(aux2);
        //Categoria do Produto
        System.out.println("Informe o fabricante: ");
        aux2 = input.nextLine();
        setFabricante(aux2);
        System.out.println("Informe o fornecedor: ");
        aux2 = input.nextLine();
        setFornecedor(aux2);
        System.out.println("Informe a quantidade: ");
        aux1 = input.nextInt();
        input.nextLine();
        setQuantidade(aux1);
    }

    public void M_Inicial() {// função de apoio

        System.out.println("Informe o campo que deseja alterar:");
        System.out.println("ID(1);\n" + "Nome(2);\n" + "Tamanho(3);\n" +
                "Cor(4);\n" + "Marca(5);\n" + "Preço(6);\n" + "Categoria(7);\n" +
                "Fabricante(8);\n" + "Fornecedor(9);\n" + "Quantidade(10);\n" + "Sair(11).");
    }

    public void editar() throws Exception{// Alterar detalhes de um produto

        int opcao = 1;
        int aux1;
        String aux2;
        float aux3;

        while (opcao != 11) {

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
                    System.out.println("Informe o Novo Nome (atual: " + getNome() + "): ");
                    aux2 = input.nextLine();
                    setNome(aux2);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Informe o Novo Tamanho (atual: " + getTamanho() + " ): ");
                    aux2 = input.nextLine();
                    setTamanho(aux2);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Informe a Nova Cor (atual: " + getCor() + "): ");
                    aux2 = input.nextLine();
                    setCor(aux2);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Informe a Nova Marca (atual: " + getMarca() + "): ");
                    aux2 = input.nextLine();
                    setMarca(aux2);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Informe o Novo Preço (atual: " + getPreco() + "): ");
                    aux3 = input.nextFloat();
                    setPreco(aux3);
                    input.nextLine();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Categoria Atual: " + getCategoria());
                    //Categoria do Produto
                    aux2 = tp.CategoriaProduto();
                    setCategoria(aux2);
                    //Categoria do Produto
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Informe o Novo Fabricante (atual: " + getFabricante() + "): ");
                    aux2 = input.nextLine();
                    setFabricante(aux2);
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Informe o Novo Fornecedor (atual: " + getFornecedor() + "): ");
                    aux2 = input.nextLine();
                    setFornecedor(aux2);
                    System.out.println();
                    break;
                case 10:
                    System.out.println("Informe a Nova Quantidade (atual: " + getQuantidade() + "): ");
                    aux1 = input.nextInt();
                    setQuantidade(aux1);
                    input.nextLine();
                    System.out.println();
                    break;
                case 11:
                    System.out.println("Modificações Salvas!!");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção Invalida!!!");
                    System.out.println("Digite Novamente");
                    System.out.println();
            }
        }
    }
}
