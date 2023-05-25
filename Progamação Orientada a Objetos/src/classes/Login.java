package classes;

import java.util.Scanner;

public class Login{
    
    private String email;
    private String senha;

    Scanner input = new Scanner(System.in);

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void add_login(){

        String aux; 

        System.out.println("Informe o Email para Cadastro: ");
        aux = input.nextLine();
        setEmail(aux);
        System.out.println("Informe a Senha: ");
        aux = input.nextLine();
        setSenha(aux);
    }

    public void recSenha(){

        String aux1; 
        String aux2;

        while(true){
            System.out.println("Informe a Nova Senha: ");
            aux1 = input.nextLine();
            System.out.println("Confirme a Nova Senha: ");
            aux2 = input.nextLine();
            if(aux1.equals(aux2)){
                setSenha(aux1);
                System.out.println("Senha Alterada com Sucesso");
                break;
            }else{
                System.out.println("Senha Incorreta");
                System.out.println("Digite Novamente");
            }
        }
    }

    public void acesso(){

        String aux; 

        while(true){
            System.out.println("Informe o Email: ");
            aux = input.nextLine();
            if(aux.equals(getEmail()) == false){
                System.out.println("Email Incorreto ou não Cadastrado");
                System.out.println("Digite Novamente ou Cadastre um Novo Email");
            }else{
                break;
            }
        }
        while(true){

            System.out.println("Informe a Senha: ");
            aux = input.nextLine();
            if(aux.equals(getSenha()) == false){
                System.out.println("Senha Incorreta");
                System.out.println("Digite Novamente");
            }else{
                System.out.println("Login Efetuado");
                break;
            } 
        }  
    }
}