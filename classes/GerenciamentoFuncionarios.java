package classes;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GerenciamentoFuncionarios {
    List<Funcionarios> funcionarios = new ArrayList<>();

    public void adicionarFuncionarios(Funcionarios cp) {
        funcionarios.add(cp);
    }

    public void imprimirFuncionarios() {
        funcionarios.forEach((f) -> {
            System.out.println("********RELATÓRIO DO FUNCIONÁRIO:*********");
            System.out.println("Identificação: " + f.getId());
            System.out.println("Nome: " + f.getNome());
            System.out.println("Email: " + f.getEmail());
            System.out.println("Telefone: " + f.getTelefone());
            System.out.println("CPF: " + f.getCPF());
            System.out.println("Cargo: " + f.getCargo());
            System.out.println("******************************************");
        });
    }

    public void editarFuncionarios() {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o número do ID a ser localizado: ");
        int busca;
        busca = input.nextInt();
        input.nextLine();

        int i, achou=-1;
        System.out.println();

        for(i = 0; i < funcionarios.size(); i++)
        {
            int idteste = funcionarios.get(i).getId();
            if (idteste == busca) {
                funcionarios.get(i).editar();
                achou=1;
                break;
            }
        }

        if (achou==-1){
            System.out.println("ID do funcionario não encontrado! Tente novamente");
            System.out.println();
        }
    }

    public void removerfuncionarios() {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o número do ID do funcionario a ser removido: ");
        int busca;
        busca = input.nextInt();
        input.nextLine();

        int i, achou=-1;
        System.out.println();

        for(i = 0; i < funcionarios.size(); i++)
        {
            int idteste = funcionarios.get(i).getId();
            if (idteste == busca) {
                funcionarios.remove(i);
                System.out.println("Funcionario removido com sucesso!");
                System.out.println();
                achou=1;
                break;
            }
        }

        if (achou==-1){
            System.out.println("ID do funcionario não encontrado! Tente novamente");
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
}