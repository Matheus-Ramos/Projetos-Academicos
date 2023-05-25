package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    Scanner input = new Scanner(System.in);

    public static void msgErroDados() {
        System.err.println("Dados informados incorretamente! Por favor, informe os dados corretamente.");
    }

    public static void msgErroOpcoes() {
        System.err.println("Por favor, selecione uma das opções válidas.");
    }

    public static int startOptions() {
        Scanner op = new Scanner(System.in); // scanner da opção de entrada
        int opt = -1;

        System.out.println("****************OPÇÕES:****************");
        System.out.println("*  [1] Adicionar Produto              *");
        System.out.println("*  [2] Adicionar Funcionário          *");
        System.out.println("*  [3] Editar Produto                 *");
        System.out.println("*  [4] Editar Funcionário             *");
        System.out.println("*  [5] Remover Produto                *");
        System.out.println("*  [6] Remover Funcionário            *");
        System.out.println("*  [7] Realizar Movimentação          *");
        System.out.println("*  [8] Realizar Pagamento             *");
        System.out.println("*  [9] Realizar Login                 *");
        System.out.println("*  [10] Relatório Geral               *");
        System.out.println("*  [0] Encerrar programa              *");
        System.out.println("***************************************");
        System.out.print("Selecione a opção desejada: ");

        try {
            opt = op.nextInt();
        } catch (InputMismatchException error) {
            msgErroOpcoes();
            opt = startOptions();
        }

        return opt;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Produtos produto = new Produtos();
        Movimentacao mov = new Movimentacao();
        Pagamento pag = new Pagamento();
        Login log = new Login();

        //Array_List
        Gerenciamento gp = new Gerenciamento();
        GerenciamentoFuncionarios gf = new GerenciamentoFuncionarios();
        GerenciamentoMovimentacao gm = new GerenciamentoMovimentacao();

        //State
        GerenciamentoEstado ge = new GerenciamentoEstado();

        System.out.println("***************************************");
        System.out.println("*                                     *");
        System.out.println("* SISTEMA DE GERENCIAMENTO DE ESTOQUE *");
        System.out.println("*                                     *");
        System.out.println("***************************************");
        System.out.println();

        int option = startOptions();

        while(option != 0){
            switch(option){
                case 1: // adiciona novo produto
                    System.out.println();
                    try {
                        produto.adicionar();
                        //State
                        ge.verificaQuantidade(produto);
                        ge.adicionaProduto(produto);
                        //State
                        produto.imprimir();
                        //arraylist
                        gp.correcaoId(produto);
                        gp.adicionarProdutos(produto);
                        //arraylist
                    }catch(Exception e){
                        System.out.println("Ocorreu um Erro na Leitura de 1 ou + Dados!");
                    }
                    System.out.println();
                    produto = new Produtos();
                    option = startOptions();
                    break;
                case 2: // adiciona novo funcionário
                    System.out.println();
                    try {
                        gf.gerenciamentoCargo();
                    }catch(Exception e){
                        System.out.println("Ocorreu um Erro na Leitura de 1 ou + Dados!");
                    }
                    System.out.println();
                    option = startOptions();
                    break;
                case 3: // edita produto existente
                    System.out.println();
                    gp.editarProdutos();
                    System.out.println();
                    option = startOptions();
                    break;
                case 4: // edita funcionário existente
                    System.out.println();
                    gf.editarFuncionarios();
                    System.out.println();
                    option = startOptions();
                    break;
                case 5: // remove produto existente
                    System.out.println();
                    gp.removerProduto();
                    System.out.println();
                    option = startOptions();
                    break;
                case 6: // remove funcionario existente
                    System.out.println();
                    gf.removerfuncionarios();
                    System.out.println();
                    option = startOptions();
                    break;
                case 7: // realiza uma movimentação de estoque
                    System.out.println();
                    try {
                        mov.adicionar();
                        gm.correcaoId(mov);
                        gm.adicionarMovimentacao(mov);
                    }catch(Exception e){
                        System.out.println("Ocorreu um Erro na Leitura de 1 ou + Dados!");
                    }
                    System.out.println();
                    mov = new Movimentacao();
                    option = startOptions();
                    break;
                case 8: // Realizar Pagamento
                    System.out.println();
                    try{
                        pag.setPagamento();
                    }catch(Exception e){
                        System.out.println("Ocorreu um Erro na Leitura de 1 ou + Dados!");
                    }
                    System.out.println();
                    option = startOptions();
                    break;
                case 9: // Realizar Login
                    System.out.println();
                    System.out.println("Ja possui cadastro?");
                    String aux;
                    aux = input.nextLine();
                    if (aux.equals("sim")) {
                        log.acesso();
                    } else {
                        log.add_login();
                    }
                    System.out.println();
                    option = startOptions();
                    break;
                case 10: // Relatório
                    System.out.println();
                    System.out.println("*******************************************");
                    System.out.println("*           RELATÓRIO DO GERAL:           *");
                    System.out.println("*******************************************");
                    System.out.println();
                    gp.imprimirProdutos();
                    gm.imprimirMovimentacao();
                    gf.imprimirFuncionarios();
                    System.out.println();
                    option = startOptions();
                    break;
                default:
                    System.out.println("Selecione uma opção válida!");
                    option = startOptions();
                    break;
            }
        }
    }
}
