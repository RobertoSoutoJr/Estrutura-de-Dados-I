public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> primeiro;
    private NoDuplo<T> ultimo;

    public ListaDuplamenteEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    // Adicionar no início
    public void adicionarInicio(T dado) {
        NoDuplo<T> novoNo = new NoDuplo<>(dado);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            novoNo.setProximo(primeiro);
            primeiro.setAnterior(novoNo);
            primeiro = novoNo;
        }
    }

    // Adicionar no final
    public void adicionarFim(T dado) {
        NoDuplo<T> novoNo = new NoDuplo<>(dado);
        if (ultimo == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProximo(novoNo);
            novoNo.setAnterior(ultimo);
            ultimo = novoNo;
        }
    }

    // Adicionar em índice específico
    public void adicionarEmIndice(T dado, int indice) {
        if (indice <= 0) {
            adicionarInicio(dado);
            return;
        }

        NoDuplo<T> atual = primeiro;
        int cont = 0;

        while (atual != null && cont < indice - 1) {
            atual = atual.getProximo();
            cont++;
        }

        if (atual == null || atual.getProximo() == null) {
            adicionarFim(dado);
            return;
        }

        NoDuplo<T> novoNo = new NoDuplo<>(dado);
        novoNo.setProximo(atual.getProximo());
        novoNo.setAnterior(atual);
        atual.getProximo().setAnterior(novoNo);
        atual.setProximo(novoNo);
    }

    // Imprimir lista
    public void imprimir() {
        NoDuplo<T> atual = primeiro;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.getDado() + " <-> ");
            atual = atual.getProximo();
        }
        System.out.println("null");
    }


    // Remover elemento por índice
public T removerPorIndice(int indice) {
    if (primeiro == null) {
        return null; // lista vazia
    }

    if (indice == 0) { // remover o primeiro
        T valor = primeiro.getDado();
        primeiro = primeiro.getProximo();
        if (primeiro != null) {
            primeiro.setAnterior(null);
        } else {
            ultimo = null; // lista ficou vazia
        }
        return valor;
    }

    NoDuplo<T> atual = primeiro;
    int cont = 0;

    while (atual != null && cont < indice) {
        atual = atual.getProximo();
        cont++;
    }

    if (atual == null) {
        return null; // índice fora do alcance
    }

    T valor = atual.getDado();

    NoDuplo<T> anterior = atual.getAnterior();
    NoDuplo<T> proximo = atual.getProximo();

    if (anterior != null) {
        anterior.setProximo(proximo);
    }

    if (proximo != null) {
        proximo.setAnterior(anterior);
    } else {
        ultimo = anterior; // se removeu o último
    }

    return valor;
}

}
