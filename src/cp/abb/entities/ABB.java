package cp.abb.entities;

import java.util.ArrayList;
import java.util.List;

public class ABB {


    private class ARVORE {
        Cliente dado;
        ARVORE esq;
        ARVORE dir;
    }

    public ARVORE root = null;


    public ARVORE inserir(ARVORE p, Cliente info) {
        // insere elemento em uma ABB
        if (p == null) {
            p = new ARVORE();
            p.dado = info;
            p.esq = null;
            p.dir = null;
        } else if (info.getSaldo() < p.dado.getSaldo())
            p.esq = inserir(p.esq, info);
        else
            p.dir = inserir(p.dir, info);
        return p;
    }

    public List<Cliente> buscar(ARVORE p, double info) {
        List<Cliente> clientes = new ArrayList<>();
        if (p == null) {
            return clientes;
        }
        clientes.addAll(buscar(p.dir, info));
        if (info <= p.dado.getSaldo()) {
            clientes.add(p.dado);
        }
        clientes.addAll(buscar(p.esq, info));
        return clientes;
    }

    public ARVORE remove(ARVORE p, double saldo) {
        if (p == null) {
            return null;
        }
        if (saldo < p.dado.getSaldo()) {
            p.esq = remove(p.esq, saldo);
        } else if (saldo > p.dado.getSaldo()) {
            p.dir = remove(p.dir, saldo);
        } else {
            if (p.esq == null && p.dir == null) {
                return null;
            } else if (p.esq == null) {
                return p.dir;
            } else if (p.dir == null) {
                return p.esq;
            } else {
                ARVORE aux, ref;
                aux = p.dir;
                ref = p.dir;
                while (aux.esq != null) {
                    aux = aux.esq;
                }
                aux.esq = p.esq;
                return ref;
            }
        }
        return p;
    }

    public Cliente buscarCliente(ARVORE root, String cpfCnpj) {
        if (root == null) {
            return null;
        }
        Cliente cliente;
        if (root.dado.getCpfCnpj().equals(cpfCnpj)) {
            return root.dado;
        }
        cliente = buscarCliente(root.dir, cpfCnpj);
        if (cliente != null) {
            return cliente;
        }
        cliente = buscarCliente(root.esq, cpfCnpj);
        return cliente;
    }

    public Cliente buscarClienteNumeroConta(ARVORE root, int numeroConta) {
        if (root == null) {
            return null;
        }
        Cliente cliente;
        if (root.dado.getNumeroConta() == (numeroConta)) {
            return root.dado;
        }
        cliente = buscarClienteNumeroConta(root.dir, numeroConta);
        if (cliente != null) {
            return cliente;
        }
        cliente = buscarClienteNumeroConta(root.esq, numeroConta);
        return cliente;
    }

    public int numeroClientes(ARVORE root) {
        if (root == null) {
            return 0;
        }
        return 1 + numeroClientes(root.esq) + numeroClientes(root.dir);
    }

    public void imprimir(ARVORE p) {
        if (p != null) {
            imprimir(p.dir);
            System.out.println("Cliente: " + p.dado.getNome());
            System.out.println("CPF/CNPJ: " + p.dado.getCpfCnpj());
            System.out.println("Número da conta: " + p.dado.getNumeroConta());
            System.out.println("Tipo de conta: " + p.dado.getTipoConta());
            System.out.println("Saldo: " + p.dado.getSaldo());
            System.out.println();
            imprimir(p.esq);
        }
    }
}
