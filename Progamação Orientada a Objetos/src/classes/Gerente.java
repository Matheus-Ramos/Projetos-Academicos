package classes;

import java.util.Scanner;

public class Gerente extends Funcionarios{
	Scanner input = new Scanner(System.in);

    private int pessoasSupervisionadas;
	
	public Gerente(int id, String nome, String email, long telefone, long cpf, int cargo, int pesSuperv) {
		super(id, nome, email, telefone, cpf, cargo);
		this.pessoasSupervisionadas = pesSuperv;
	}

    public int getpessoasSupervisionadas() {
        return pessoasSupervisionadas;
    }
    
	public void imprimir() {
		
			System.out.println("**********RELATÓRIO DO GERENTE:**********");
			System.out.println("Identificação do Gerente: " + getId());
			System.out.println("Nome do Gerente: " + getNome());
			System.out.println("Email do Gerente: " + getEmail());
			System.out.println("Telefone do Gerente: " + getTelefone());
			System.out.println("CPF do Gerente: " + getCPF());
			System.out.println("Quantidade de pessoas supervisionadas: " + getpessoasSupervisionadas());
			System.out.println("*****************************************");
	}

}
