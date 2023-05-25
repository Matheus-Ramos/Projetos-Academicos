package classes;

import java.util.Scanner;

public abstract class Funcionarios{

    private String nome;
    private long cpf;
    private int id;
    private String email;
    private long telefone;
    private int cargo;

    Scanner input = new Scanner(System.in);

    public Funcionarios(int id, String nome, String email, long telefone, long cpf, int cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public long getTelefone() {
        return telefone;
    }

    public long getCPF() {
        return cpf;
    }

    public int getCargo() {
        return cargo;
    }

    public abstract void imprimir();

    public void M_Inicial() {// função de apoio
        System.out.println("Informe o campo que deseja alterar:");
        System.out.println("ID(1);\n" + "Nome Completo(2);\n" + "Email(3);\n" + "Telefone(4);\n" + "CPF(5);\n"
                + "Cargo(6);\n" + "Sair(7).");
    }

    public void editar() throws Exception{// Alterar detalhes de um empregado
        int opcao = 1;

        while (opcao != 7) {
            M_Inicial();
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Informe o Novo Id (atual: " + getId() + "): ");
                    id = input.nextInt();
                    this.id = id;
                    input.nextLine();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Informe o Novo Nome (atual: " + getNome() + "): ");
                    nome = input.nextLine();
                    this.nome = nome;
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Informe o Novo Email: (atual: " + getEmail() + "): ");
                    email = input.nextLine();
                    this.email = email;
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Informe o Novo Telefone(somente numeros): (atual: " + getTelefone() + "): ");
                    telefone = input.nextLong();
                    this.telefone = telefone;
                    input.nextLine();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Informe o Novo CPF(somente numeros): (atual: " + getCPF() + "): ");
                    cpf = input.nextLong();
                    this.cpf = cpf;
                    input.nextLine();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Informe o Novo Cargo: (atual: " + getCargo() + "): ");
                    cargo = input.nextInt();
                    this.cargo = cargo;
                    System.out.println();
                    break;
                case 7:
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
