package classes;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GerenciamentoFuncionarios {
	List<Funcionarios> funcionarios = new ArrayList<>();

	public void imprimirFuncionarios() {
		funcionarios.forEach((f) -> {
			f.imprimir();
		});
	}

	public int buscaId(){
		Scanner input = new Scanner(System.in);

		System.out.println("Informe o número do ID a ser localizado: ");
		int busca;
		busca = input.nextInt();

		int i;
		System.out.println();

		for(i = 0; i < funcionarios.size(); i++)
		{
			int idteste = funcionarios.get(i).getId();
			if (idteste == busca) {
				return i;
			}
		}
		return (-1);
	}

	public void editarFuncionarios() {
		int indice = buscaId();
		if (indice == -1){
			System.out.println("ID de produto não encontrado! Tente novamente");
			System.out.println();
		}else {
			try {
				funcionarios.get(indice).editar();
			}catch(Exception e){
				System.out.println("Ocorreu um Erro na Leitura de 1 ou + Dados!");
			}
		}
	}

	public void removerfuncionarios() {
		int indice = buscaId();
		if (indice == -1){
			System.out.println("ID de produto não encontrado! Tente novamente");
			System.out.println();
		}else {
			funcionarios.remove(indice);
			System.out.println("Produto removido com sucesso!");
			System.out.println();
		}
	}
	
	//CORREÇÃO ID
	public Funcionarios correcaoId(Funcionarios f) {

		Scanner input = new Scanner(System.in);

		int busca;
		busca = f.getId();

		int i, aux1;

		if(funcionarios.size() > 0){
			for (i = 0; i < funcionarios.size(); i++) {
				int idteste = funcionarios.get(i).getId();
				if (idteste == busca) {
					System.out.println("ID Ja Existente!!");
					System.out.println("Digite Novamente");
					System.out.println("Informe o código de identificação do funcionario: ");
					aux1 = input.nextInt();
					input.nextLine();
					f.setId(aux1);
					correcaoId(f);
					break;
				}
			}
		}
		return f;
	}

	public void M_Inicial() {// função de apoio
		System.out.println("Qual o cargo do funcionário a ser adicionado?");
		System.out.println("*  [1] Vendedor                       *");
		System.out.println("*  [2] Gerente                        *");
	}

	public void gerenciamentoCargo() throws Exception{

		Scanner input = new Scanner(System.in);

		int flag = 0;

		int cargo = -1;
		String nome;
		long cpf;
		int id;
		String email;
		long telefone;
		int mVendas;
		int pSuperv;

		while (flag != 1) {
			M_Inicial();
			cargo = input.nextInt();
			input.nextLine();
			switch(cargo){
				case 1:
					System.out.println("Informe o código de identificação do vendedor: ");
					id = input.nextInt();
					input.nextLine();
					System.out.println("Informe o Nome Completo: ");
					nome = input.nextLine();
					System.out.println("Informe o Email: ");
					email = input.nextLine();
					System.out.println("Informe o Telefone(somente numeros): ");
					telefone = input.nextLong();
					input.nextLine();
					System.out.println("Informe o CPF: ");
					cpf = input.nextLong();
					input.nextLine();
					System.out.println("Informe a Meta Mensal das Vendas: ");
					mVendas = input.nextInt();
					input.nextLine();
					System.out.println();

					Funcionarios v = new Vendedor(id, nome, email, telefone, cpf, cargo, mVendas);
					correcaoId(v);
					funcionarios.add(v);

					System.out.println("Vendedor "+ nome +" cadastrado com sucesso!");
					flag = 1;
					break;
				case 2:
					System.out.println("Informe o código de identificação do gerente: ");
					id = input.nextInt();
					input.nextLine();
					System.out.println("Informe o Nome Completo: ");
					nome = input.nextLine();
					System.out.println("Informe o Email: ");
					email = input.nextLine();
					System.out.println("Informe o Telefone(somente numeros): ");
					telefone = input.nextLong();
					input.nextLine();
					System.out.println("Informe o CPF: ");
					cpf = input.nextLong();
					input.nextLine();
					System.out.println("Informe a Quantidade de Pessoas Supervisionadas: ");
					pSuperv = input.nextInt();
					input.nextLine();
					System.out.println();

					Funcionarios g = new Gerente(id, nome, email, telefone, cpf, cargo, pSuperv);
					correcaoId(g);
					funcionarios.add(g);

					System.out.println("Gerente "+ nome +" cadastrado com sucesso!");
					flag = 1;
					break;
				default:
					System.out.println("Opção Invalida!!!");
					System.out.println("Digite Novamente");
					System.out.println();
			}
		}
	}
}
