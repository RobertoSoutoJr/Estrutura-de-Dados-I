public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
    }

    // Adicionar elemento à fila (enqueue)
    public void adicionar(T valor) {
        No<T> novoNo = new No<>(valor);
        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setNextNo(novoNo);
            ultimo = novoNo;
        }
    }

    // Remover elemento da fila (dequeue)
    public T remover() {
        if (estaVazia()) {
            return null;
        }
        T valor = primeiro.getDado();
        primeiro = primeiro.getNextNo();
        if (primeiro == null) { // fila ficou vazia
            ultimo = null;
        }
        return valor;
    }

    // Verifica se a fila está vazia
    public boolean estaVazia() {
        return primeiro == null;
    }

    // Imprimir fila
    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Fila está vazia!");
            return;
        }
        No<T> atual = primeiro;
        System.out.print("Fila = ");
        while (atual != null) {
            System.out.print(atual.getDado() + " -> ");
            atual = atual.getNextNo();
        }
        System.out.println();
    }
}
