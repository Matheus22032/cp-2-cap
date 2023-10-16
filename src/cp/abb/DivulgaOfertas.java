package cp.abb;

import cp.abb.entities.ABB;
import cp.abb.entities.Cliente;

import java.util.ArrayList;
import java.util.List;
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
                    if (tipoConta.equals("Física")) {
                        arvoreFisica.root = arvoreFisica.inserir(arvoreFisica.root, cliente);
                    } else {
                        arvoreJuridica.root = arvoreJuridica.inserir(arvoreJuridica.root, cliente);
                    }
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
                    List<Cliente> clientes = new ArrayList<>();
                    if (tipoConta.equals("Física")) {
                        clientes.addAll(arvoreFisica.buscar(arvoreFisica.root, saldo));
                    } else {
                        clientes.addAll(arvoreJuridica.buscar(arvoreJuridica.root, saldo));
                    }
                    if (clientes.isEmpty()) {
                        System.out.println("Não há clientes aptos para a oferta");
                    } else {
                        while (!clientes.isEmpty()) {
                            Cliente clienteReceberOferta = clientes.remove(0);
                            System.out.println("Cliente: " + clienteReceberOferta.getNome());
                            System.out.println("CPF/CNPJ: " + clienteReceberOferta.getCpfCnpj());
                            System.out.println("Número da conta: " + clienteReceberOferta.getNumeroConta());
                            System.out.println("Tipo de conta: " + clienteReceberOferta.getTipoConta());
                            System.out.println("Saldo: " + clienteReceberOferta.getSaldo());
                            System.out.println();
                            System.out.println("Deseja receber a oferta? 1-Sim 2-Não");
                            op = le.nextInt();
                            if (op == 1) {
                                System.out.println("Oferta aceita");
                                if (tipoConta.equals("Física"))
                                    arvoreFisica.root = arvoreFisica.remove(arvoreFisica.root, clienteReceberOferta.getSaldo());
                                else
                                    arvoreJuridica.root = arvoreJuridica.remove(arvoreJuridica.root, clienteReceberOferta.getSaldo());
                            } else {
                                System.out.println("Oferta não aceita");
                            }
                        }
                    }
                    break;
                case 3:
                    int alt = -1;
                    while (alt == -1) {
                        System.out.println(" 1 - Consultar cliente");
                        System.out.println(" 2 - Alterar saldo");
                        System.out.println(" 3 - Numero de clientes");
                        System.out.println(" 4 - Clientes com saldo maior que");
                        System.out.println(" 5 - voltar ao menu principal");
                        op = le.nextInt();
                        switch (op) {
                            case 1:
                                System.out.println("Digite se é pessoa 1- física ou 2- jurídica");
                                op = le.nextInt();
                                if (op == 1) {
                                    tipoConta = "Física";
                                } else {
                                    tipoConta = "Jurídica";
                                }
                                System.out.println("Digite o cpf ou cnpj");
                                cpfCnpj = le.next();
                                if (tipoConta.equals("Física")) {
                                    Cliente clienteProcurado = arvoreFisica.buscarCliente(arvoreFisica.root, cpfCnpj);
                                    if (clienteProcurado == null) {
                                        System.out.println("Cliente não encontrado");
                                    } else {
                                        System.out.println("Cliente: " + clienteProcurado.getNome());
                                        System.out.println("CPF: " + clienteProcurado.getCpfCnpj());
                                        System.out.println("Número da conta: " + clienteProcurado.getNumeroConta());
                                        System.out.println("Tipo de conta: " + clienteProcurado.getTipoConta());
                                        System.out.println("Saldo: " + clienteProcurado.getSaldo());
                                    }
                                } else {
                                    Cliente clienteProcurado = arvoreJuridica.buscarCliente(arvoreJuridica.root, cpfCnpj);
                                    if (clienteProcurado == null) {
                                        System.out.println("Cliente não encontrado");
                                    } else {
                                        System.out.println("Cliente: " + clienteProcurado.getNome());
                                        System.out.println("CNPJ: " + clienteProcurado.getCpfCnpj());
                                        System.out.println("Número da conta: " + clienteProcurado.getNumeroConta());
                                        System.out.println("Tipo de conta: " + clienteProcurado.getTipoConta());
                                        System.out.println("Saldo: " + clienteProcurado.getSaldo());
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Digite se é pessoa 1- física ou 2- jurídica");
                                op = le.nextInt();
                                System.out.println("Digite o numero da conta do cliente");
                                numeroConta = le.nextInt();
                                if (op == 1) {
                                    tipoConta = "Física";
                                } else {
                                    tipoConta = "Jurídica";
                                }
                                Cliente clienteAlterarSaldo;
                                if (tipoConta.equals("Física")) {
                                    clienteAlterarSaldo = arvoreFisica.buscarClienteNumeroConta(arvoreFisica.root, numeroConta);
                                    if (clienteAlterarSaldo == null) {
                                        System.out.println("Cliente não encontrado");
                                    } else {
                                        arvoreFisica.root = arvoreFisica.remove(arvoreFisica.root, clienteAlterarSaldo.getSaldo());
                                        System.out.println("Digite o novo saldo");
                                        saldo = le.nextDouble();
                                        clienteAlterarSaldo.setSaldo(saldo);
                                        System.out.println("Saldo alterado com sucesso");
                                        System.out.println("Cliente: " + clienteAlterarSaldo.getNome());
                                        System.out.println("CPF: " + clienteAlterarSaldo.getCpfCnpj());
                                        System.out.println("Número da conta: " + clienteAlterarSaldo.getNumeroConta());
                                        System.out.println("Tipo de conta: " + clienteAlterarSaldo.getTipoConta());
                                        System.out.println("Saldo: " + clienteAlterarSaldo.getSaldo());
                                        System.out.println();
                                        arvoreFisica.root = arvoreFisica.inserir(arvoreFisica.root, clienteAlterarSaldo);
                                    }
                                } else {
                                    clienteAlterarSaldo = arvoreJuridica.buscarClienteNumeroConta(arvoreJuridica.root, numeroConta);
                                    if (clienteAlterarSaldo == null) {
                                        System.out.println("Cliente não encontrado");
                                    } else {
                                        arvoreJuridica.root = arvoreJuridica.remove(arvoreJuridica.root, clienteAlterarSaldo.getSaldo());
                                        System.out.println("Digite o novo saldo");
                                        saldo = le.nextDouble();
                                        clienteAlterarSaldo.setSaldo(saldo);
                                        System.out.println("Saldo alterado com sucesso");
                                        System.out.println("Cliente: " + clienteAlterarSaldo.getNome());
                                        System.out.println("CNPJ: " + clienteAlterarSaldo.getCpfCnpj());
                                        System.out.println("Número da conta: " + clienteAlterarSaldo.getNumeroConta());
                                        System.out.println("Tipo de conta: " + clienteAlterarSaldo.getTipoConta());
                                        System.out.println("Saldo: " + clienteAlterarSaldo.getSaldo());
                                        System.out.println();
                                        arvoreJuridica.root = arvoreJuridica.inserir(arvoreJuridica.root, clienteAlterarSaldo);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Numero de clientes: " + arvoreFisica.numeroClientes(arvoreFisica.root));
                                break;
                            case 4:
                                System.out.println("Digite o saldo");
                                saldo = le.nextDouble();
                                List<Cliente> clientesComSaldoMaiorQue = arvoreFisica.buscar(arvoreFisica.root, saldo);
                                if (clientesComSaldoMaiorQue.isEmpty()) {
                                    System.out.println("Não há clientes com saldo maior que " + saldo);
                                } else {
                                    System.out.println("Clientes com saldo maior que " + clientesComSaldoMaiorQue.size());
                                }
                                break;
                            case 5:
                                alt = 0;
                                break;
                        }
                    }
                    break;
            }
        } while (opcao != 0);
        if (arvoreFisica.root != null || arvoreJuridica.root != null) {
            System.out.println("Clientes que não aceitaram ou não estavam adequados para a oferta");
            System.out.println();

            arvoreFisica.imprimir(arvoreFisica.root);
            arvoreJuridica.imprimir(arvoreJuridica.root);
            arvoreJuridica.root = null;
            arvoreFisica.root = null;
        } else {
            System.out.println("Não há clientes que não aceitaram ou não estavam adequados para a oferta");
        }


        le.close();
    }
}