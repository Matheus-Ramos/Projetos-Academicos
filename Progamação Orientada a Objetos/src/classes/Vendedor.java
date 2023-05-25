package classes;

import java.util.Scanner;

public class Vendedor extends Funcionarios{
	Scanner input = new Scanner(System.in);

    private int metaVendas;
	
	public Vendedor(int id, String nome, String email, long telefone, long cpf, int cargo, int metaVendas) {
		super(id, nome, email, telefone, cpf, cargo);
		this.metaVendas = metaVendas;
	}

    public int getMetaVendas() {
        return metaVendas;
    }

    public void imprimir() {
		
		System.out.println("**********RELATÓRIO DO VENDEDOR:**********");
		System.out.println("Identificação do Vendedor: " + getId());
		System.out.println("Nome do Vendedor: " + getNome());
		System.out.println("Email do Vendedor: " + getEmail());
		System.out.println("Telefone do Vendedor: " + getTelefone());
		System.out.println("CPF do Vendedor: " + getCPF());
		System.out.println("Meta mensal de vendas: " + getMetaVendas());
		System.out.println("******************************************");
}
}
