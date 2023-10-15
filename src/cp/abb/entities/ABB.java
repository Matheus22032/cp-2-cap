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
        }
        else if (info.getSaldo() < p.dado.getSaldo())
            p.esq= inserir (p.esq, info);
        else
            p.dir=inserir(p.dir, info);
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


}
