public class Pilha<T> {
    private No<T> topo;

    public Pilha() {
        this.topo = null;
    }

    // Adicionar elemento (push)
    public void adicionar(T valor) {
        No<T> novoNo = new No<>(valor);
        novoNo.setNextNo(topo);
        topo = novoNo;
    }

    // Remover elemento do topo (pop)
    public T remover() {
        if (estaVazia()) {
            return null;
        }
        T valor = topo.getDado();
        topo = topo.getNextNo();
        return valor;
    }

    // Verifica se a pilha está vazia
    public boolean estaVazia() {
        return topo == null;
    }

    // Imprimir pilha
    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Pilha vazia!");
            return;
        }
        No<T> atual = topo;
        System.out.print("Pilha = ");
        while (atual != null) {
            System.out.print(atual.getDado() + " ");
            atual = atual.getNextNo();
        }
        System.out.println();
    }
}