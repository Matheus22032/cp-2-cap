package cp.abb;

import cp.abb.entities.ABB;
import cp.abb.entities.Cliente;

import java.util.Scanner;

public class DivulgaOfertas {
    /*
     * Breno Tosi Barros - 93435
     * Gustavo Henrique Omai Da Silva - 96059
     * Luigi de Lima Galati - 95618
     * Matheus Gonçalves Sant'Ana - 96166
     *
     */
    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        /*
         * Cria a uma árvore de busca binária para cada tipo de conta
         * (pessoa física ou jurídica)
         */
        ABB arvoreFisica = new ABB();
        ABB arvoreJuridica = new ABB();

        int opcao, op, numeroConta;
        String nome, cpfCnpj;
        String tipoConta = null;
        double saldo;
        do {
            System.out.println(" 0 - Encerrar o programa");
            System.out.println(" 1 - Inscrição cliente");
            System.out.println(" 2 - Oferta de novo serviço e/ou aplicação");
            System.out.println(" 3 – Entrar no Submenu ");
            opcao = le.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite nome: ");
                    nome = le.next();
                    System.out.print("Digite cpf: ");
                    cpfCnpj = le.next();
                    System.out.print("Digite número da conta: ");
                    numeroConta = le.nextInt();
                    do {
                        System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
                        op = le.nextInt();
                        switch (op) {
                            case 1:
                                tipoConta = "Física";
                                break;
                            case 2:
                                tipoConta = "Jurídica";
                                break;
                            default:
                                System.out.println("Opção inválida ");
                                op = -1;
                        }
                    } while (op == -1);
                    System.out.print("Informe saldo em aplicações R$: ");
                    saldo = le.nextDouble();
                    Cliente cliente = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo);
                    if(tipoConta.equals("Física")){
                        arvoreFisica.root = arvoreFisica.inserir(arvoreFisica.root, cliente);
                    }else{
                        arvoreJuridica.root = arvoreJuridica.inserir(arvoreJuridica.root, cliente);
                    }
                    /*
                     * Intancia um objeto da classe Cliente e insere na ABB correspondente
                     * a tipo de conta
                     */
                    break;
                case 2:
                    System.out.print("Qual tipo de conta a oferta se destina ? ");
                    do {
                        System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica:");
                        op = le.nextInt();
                        switch (op) {
                            case 1:
                                tipoConta = "Física";
                                break;
                            case 2:
                                tipoConta = "Jurídica";
                                break;
                            default:
                                System.out.println("Opção inválida ");
                                op = -1;
                        }
                    } while (op == -1);
                    System.out.print("Qual o valor de saldo mínimo exigido R$: ");
                    saldo = le.nextDouble();
                    /*
                     * Fazendo uso de um método da classe ABB, desenvolvido para este
                     * problema, uma lista de clientes aptos para a oferta é gerada.
                     * Nesse trecho de programa que tentar fazer o contato com todos os
                     * clientes presente na lista.
                     */
                    if (tipoConta.equals("Física")) {
                        System.out.println("Clientes que aceitaram a oferta");
                        System.out.println(arvoreFisica.buscar(arvoreFisica.root, saldo));
                    } else {
                        System.out.println("Clientes que aceitaram a oferta");
                        System.out.println(arvoreJuridica.buscar(arvoreJuridica.root, saldo));
                    }
                    break;
                case 3:
                    /*
                     * Implemente o submenu descrito no texto
                     */
                    break;
            }
        } while (opcao != 0);
        System.out.println("Clientes que não aceitaram ou não estavam adequados para a oferta");
        /*
         * Esvazia as ABBs apresentando todos os clientes que aguardam nova portunidade
         */
        le.close();
    }
}
