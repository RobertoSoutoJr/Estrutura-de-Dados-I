public class Deque<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public Deque() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    // Inserir no início
    public void addInicio(T dado) {
        No<T> novo = new No<>(dado);
        if (primeiro == null) {
            primeiro = ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
            primeiro = novo;
        }
        tamanho++;
    }

    // Inserir no final
    public void addFinal(T dado) {
        No<T> novo = new No<>(dado);
        if (ultimo == null) {
            primeiro = ultimo = novo;
        } else {
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    // Remover do início
    public T removeInicio() {
        if (primeiro == null) {
            System.out.println("Deque vazio!");
            return null;
        }
        T dado = primeiro.getDado();
        primeiro = primeiro.getProximo();
        if (primeiro != null) {
            primeiro.setAnterior(null);
        } else {
            ultimo = null;
        }
        tamanho--;
        return dado;
    }

    // Remover do final
    public T removeFinal() {
        if (ultimo == null) {
            System.out.println("Deque vazio!");
            return null;
        }
        T dado = ultimo.getDado();
        ultimo = ultimo.getAnterior();
        if (ultimo != null) {
            ultimo.setProximo(null);
        } else {
            primeiro = null;
        }
        tamanho--;
        return dado;
    }


    // Retorna primeiro elemento (sem remover)
    public T peekInicio() {
        return (primeiro != null) ? primeiro.getDado() : null;
    }

    // Retorna último elemento (sem remover)
    public T peekFinal() {
        return (ultimo != null) ? ultimo.getDado() : null;
    }

    // Atualiza o valor de um elemento em um índice específico
    public void atualizaIndice(int indice, T novoValor) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Índice fora dos limites!");
            return;
        }
        No<T> atual = primeiro;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        atual.setDado(novoValor);
    }

    // Destroi o deque, liberando todos os nós
    public void destruirDeque() {
        No<T> atual = primeiro;
        while (atual != null) {
            No<T> proximo = atual.getProximo();
            atual.setAnterior(null);
            atual.setProximo(null);
            atual = proximo;
        }
        primeiro = null;
        ultimo = null;
        tamanho = 0;
        System.out.println("Deque destruído!");
    }

    // Verifica se deque está vazio
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Retorna tamanho do deque
    public int size() {
        return tamanho;
    }

    // Imprime deque
    public void imprimeDeque() {
        if (primeiro == null) {
            System.out.println("Deque vazio!");
        } else {
            System.out.print("Deque: ");
            No<T> atual = primeiro;
            while (atual != null) {
                System.out.print(atual.getDado() + " ");
                atual = atual.getProximo();
            }
            System.out.println();
        }
    }
}
