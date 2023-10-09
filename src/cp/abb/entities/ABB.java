package cp.abb.entities;

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


}
