package classes;

import java.util.Scanner;

public class Pagamento {

    private double valor;
    private long nCartao;
    private String validadeCartao;
    private int cvcCartao;
    private String tipoCartao;

    Scanner input = new Scanner(System.in);

    public void setValor(double val){
        this.valor = val;
    }

    public double getValor(){
        return valor;
    }

    public void setNCartao(long cart){
        this.nCartao = cart;
    }

    public long getNCartao(){
        return nCartao;
    }

    public void setValidadeCartao(String vldd){
        this.validadeCartao = vldd;
    }

    public String getValidadeCartao(){
        return validadeCartao;
    }

    public void setCVCCartao(int cvc){
        this.cvcCartao = cvc;
    }

    public int getCVCCartao(){
        return cvcCartao;
    }

    public void setTipoCartao(int t){
        if (t == 2){
            this.tipoCartao = "Debito";
        }else{// (t == 3)
            this.tipoCartao = "Credito";
        }
    }

    public String getTipoCartao(){
        return tipoCartao;
    }

    public void setAtributosCartao(){ // função para atributos do cartão

        long aux1;
        String aux2;
        int aux3;

        System.out.println("Informe o Número do Cartao de " + getTipoCartao() + " : ");
        aux1 = input.nextLong();
        input.nextLine();
        setNCartao(aux1);
        System.out.println("Informe a Validade do Cartao de " + getTipoCartao() + " : ");
        aux2 = input.nextLine();
        setValidadeCartao(aux2);
        System.out.println("Informe o CVC do Cartao de " + getTipoCartao() + " : ");
        aux3 = input.nextInt();
        input.nextLine();
        setCVCCartao(aux3);
    }

    public void M_Inicial() {// função de apoio

        System.out.println("Informe a Forma de Pagamento do Empregado: ");
        System.out.println("Dinheiro(1);\n" + "Cartão de Debito(2);\n" + "Cartão de Credito(3);\n" + "Pix(4);\n"
                + "Transferencia Bancaria(5).\n");
    }

    public void setPagamento() throws Exception{

        double v;

        System.out.println("Informe o Valor da Compra: ");
        v = input.nextDouble();
        input.nextLine();
        setValor(v);

        int p;
        boolean flag = true;

        while(flag){

            M_Inicial();
            p = input.nextInt();
            input.nextLine();
            switch(p){
                case 1:
                    double v2;
                    System.out.println("Informe o Valor Recebido: ");
                    v2 = input.nextDouble();
                    System.out.println("Seu Troco é de: " + (v2 - v));
                    flag = false;
                    break;
                case 2: // debito
                    setTipoCartao(2);
                    setAtributosCartao();
                    flag = false;
                    break;
                case 3: // credito
                    setTipoCartao(3);
                    setAtributosCartao();
                    flag = false;
                    break;
                case 4:
                    System.out.println("Chaves Pix da Loja Super Estoque:");
                    System.out.println("314159265");
                    System.out.println("superestoque@gmail.com");
                    flag = false;
                    break;
                case 5:
                    System.out.println("Banco: DELL");
                    System.out.println("Agencia: 2023");
                    System.out.println("Numero da Conta: 27182-8");
                    flag = false;
                    break;
                default:
                    System.out.println("Forma de Pagamento Invalida!!");
                    System.out.println("Digite Novamente");
                    System.out.println();
            }
        }
        System.out.println();
        System.out.println("Tenha um Bom Dia, Volte Sempre!");
    }
}
