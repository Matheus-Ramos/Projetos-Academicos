package classes;

import java.util.Scanner;

public class Pagamento {

    private double valor;
    private long nCartaoCredito;
    private String validadeCartaoCredito;
    private int cvcCartaoCredito;
    private long nCartaoDebito;
    private String validadeCartaoDebito;
    private int cvcCartaoDebito;

    Scanner input = new Scanner(System.in);

    public void setValor(double val) {
        this.valor = val;
    }

    public double getValor() {
        return valor;
    }

    // Cartao de Credito
    public void setNCartCred(long cart) {
        this.nCartaoCredito = cart;
    }

    public long getNCartCred() {
        return nCartaoCredito;
    }

    public void setValidadeCartCred(String vldd) {
        this.validadeCartaoCredito = vldd;
    }

    public String getValidadeCartCred() {
        return validadeCartaoCredito;
    }

    public void setCVCCartCred(int cvc) {
        this.cvcCartaoCredito = cvc;
    }

    public int getCVCCartCred() {
        return cvcCartaoCredito;
    }

    // Cartao de Debito
    public void setNCartDebito(long cart) {
        this.nCartaoDebito = cart;
    }

    public long getNCartDebito() {
        return nCartaoDebito;
    }

    public void setValidadeCartDebito(String vldd) {
        this.validadeCartaoDebito = vldd;
    }

    public String getValidadeCartDebito() {
        return validadeCartaoDebito;
    }

    public void setCVCCartDebito(int cvc) {
        this.cvcCartaoDebito = cvc;
    }

    public int getCVCCartDebito() {
        return cvcCartaoDebito;
    }

    public void setAtriCCred() {// função para atributos do cartão de credito

        long aux1;
        String aux2;
        int aux3;

        System.out.println("Informe o Número do Cartao de Credito: ");
        aux1 = input.nextLong();
        input.nextLine();
        setNCartCred(aux1);
        System.out.println("Informe a Validade do Cartao de Credito: ");
        aux2 = input.nextLine();
        setValidadeCartCred(aux2);
        System.out.println("Informe o CVC do Cartao de Credito: ");
        aux3 = input.nextInt();
        input.nextLine();
        setCVCCartCred(aux3);
    }

    public void setAtriCDeb() {// função para atributos do cartão de debito

        long aux1;
        String aux2;
        int aux3;

        System.out.println("Informe o Número do Cartao de Debito: ");
        aux1 = input.nextLong();
        input.nextLine();
        setNCartDebito(aux1);
        System.out.println("Informe a Validade do Cartao de Debito: ");
        aux2 = input.nextLine();
        setValidadeCartDebito(aux2);
        System.out.println("Informe o CVC do Cartao de Debito: ");
        aux3 = input.nextInt();
        input.nextLine();
        setCVCCartDebito(aux3);
    }

    public void M_Inicial() {// função de apoio

        System.out.println("Informe a Forma de Pagamento do Empregado: ");
        System.out.println("Dinheiro(1);\n" + "Cartão de Debito(2);\n" + "Cartão de Credito(3);\n" + "Pix(4);\n"
                + "Transferencia Bancaria(5).\n");
    }

    public void setPagamento() {

        double v;

        System.out.println("Informe o Valor da Compra: ");
        v = input.nextDouble();
        input.nextLine();
        setValor(v);

        int p;

        while (true) {

            M_Inicial();
            p = input.nextInt();
            input.nextLine();
            if ((p < 1) || (p > 5)) {
                System.out.println("Forma de Pagamento Invalida!!");
                System.out.println("Digite Novamente");
            } else {
                break;
            }
        }
        if (p == 1) {
            double v2;
            System.out.println("Informe o Valor Recebido: ");
            v2 = input.nextDouble();
            System.out.println("Seu Troco é de: " + (v2 - v));
        } else if (p == 2) {
            setAtriCDeb();
        } else if (p == 3) {
            setAtriCCred();
        } else if (p == 4) {
            System.out.println("Chaves Pix da Loja Super Estoque:");
            System.out.println("314159265");
            System.out.println("superestoque@gmail.com");
        } else {
            System.out.println("Banco: DELL");
            System.out.println("Agencia: 2023");
            System.out.println("Numero da Conta: 27182-8");
        }
    }

}