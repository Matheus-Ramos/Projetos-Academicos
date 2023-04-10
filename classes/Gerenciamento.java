package classes;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Gerenciamento {
    List<Produtos> produtos = new ArrayList<>();

    public void adicionarProdutos(Produtos cp) {
        produtos.add(cp);
    }

    public void imprimirProdutos() {
        produtos.forEach((p) -> {
            System.out.println("***********RELATÓRIO DO PRODUTO:**********");
            System.out.println("Identificação: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Tamanho: " + p.getTamanho());
            System.out.println("Cor: " + p.getCor());
            System.out.println("Marca: " + p.getMarca());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("Categoria: " + p.getCategoriaString(p.getCategoria()));
            System.out.println("Fabricante: " + p.getFabricante());
            System.out.println("Fornecedor: " + p.getFornecedor());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("Status do Produto: " + p.getStatus());
            System.out.println("Localidade: Matriz");
            System.out.println("******************************************");
        });
    }

    public void editarProdutos() {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o número do ID a ser localizado: ");
        int busca;
        busca = input.nextInt();
        input.nextLine();

        int i, achou=-1;
        System.out.println();

        for(i = 0; i < produtos.size(); i++)
        {
            int idteste = produtos.get(i).getId();
            if (idteste == busca) {
                produtos.get(i).editar();
                achou=1;
                break;
            }
        }

        if (achou==-1){
            System.out.println("ID de produto não encontrado! Tente novamente");
            System.out.println();
        }
    }

    public void removerProduto() {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o número do ID do produto a ser removido: ");
        int busca;
        busca = input.nextInt();
        input.nextLine();

        int i, achou=-1;
        System.out.println();

        for(i = 0; i < produtos.size(); i++)
        {
            int idteste = produtos.get(i).getId();
            if (idteste == busca) {
                produtos.remove(i);
                System.out.println("Produto removido com sucesso!");
                System.out.println();
                achou=1;
                break;
            }
        }

        if (achou==-1){
            System.out.println("ID de produto não encontrado! Tente novamente");
            System.out.println();
        }
    }
    //CORREÇÃO ID
    public Produtos correcaoId(Produtos p) {

        Scanner input = new Scanner(System.in);

        int busca;
        busca = p.getId();

        int i, aux1;

        if(produtos.size() > 0){
            for (i = 0; i < produtos.size(); i++) {
                int idteste = produtos.get(i).getId();
                if (idteste == busca) {
                    System.out.println("ID Ja Existente!!");
                    System.out.println("Digite Novamente");
                    System.out.println("Informe o código de identificação do produto: ");
                    aux1 = input.nextInt();
                    input.nextLine();
                    p.setId(aux1);
                    correcaoId(p);
                    break;
                }
            }
        }
        return p;
    }
}