package classes;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Gerenciamento {
	List<Produtos> produtos = new ArrayList<>();

	//State
	GerenciamentoEstado ge = new GerenciamentoEstado();

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
			System.out.println("Categoria: " + p.getCategoria());
			System.out.println("Fabricante: " + p.getFabricante());
			System.out.println("Fornecedor: " + p.getFornecedor());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Status do Produto: " + p.getStatus());
			System.out.println("Localidade: Matriz");
			System.out.println("******************************************");
		});
	}

	public int buscaId(){
		Scanner input = new Scanner(System.in);

		System.out.println("Informe o número do ID a ser localizado: ");
		int busca;
		busca = input.nextInt();

		int i;
		System.out.println();

		for(i = 0; i < produtos.size(); i++)
		{
			int idteste = produtos.get(i).getId();
			if (idteste == busca) {
				return i;
			}
		}
		return (-1);
	}

	public void editarProdutos() {
		int indice = buscaId();
		if (indice == -1){
			System.out.println("ID de produto não encontrado! Tente novamente");
			System.out.println();
		}else {
			try {
				produtos.get(indice).editar();
				//State
				ge.verificaQuantidade(produtos.get(indice));
				ge.adicionaProduto(produtos.get(indice));
				//State
				produtos.get(indice).imprimir();
			}catch(Exception e){
				System.out.println("Ocorreu um Erro na Leitura de 1 ou + Dados!");
			}
		}
	}

	public void removerProduto() {
		int indice = buscaId();
		if (indice == -1){
			System.out.println("ID de produto não encontrado! Tente novamente");
			System.out.println();
		}else {
			produtos.remove(indice);
			System.out.println("Produto removido com sucesso!");
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
