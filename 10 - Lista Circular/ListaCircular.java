public class ListaCircular<T> {

    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaCircular() {
    this.primeiroNo = null;
    this.ultimoNo = null;
    this.tamanho = 0;
    }

    // Adiciona no início
    public void addInicio(T dado) {
        No<T> novo = new No<>(dado);
        if (primeiroNo == null) {
            primeiroNo = novo;
            ultimoNo = novo;
            novo.setNextNo(novo);
        } else {
            novo.setNextNo(primeiroNo);
            primeiroNo = novo;
            ultimoNo.setNextNo(primeiroNo);
        }
        tamanho++;
    }

    // Adiciona no final
    public void addFinal(T dado) {
        No<T> novo = new No<>(dado);
        if (primeiroNo == null) {
            primeiroNo = novo;
            ultimoNo = novo;
            novo.setNextNo(novo);
        } else {
            ultimoNo.setNextNo(novo);
            novo.setNextNo(primeiroNo);
            ultimoNo = novo;
        }
        tamanho++;
    }

    // Remove do início
    public void removeInicio() {
        if (primeiroNo == null) {
            System.out.println("Lista vazia.");
            return;
        }

        if (primeiroNo == ultimoNo) {
            primeiroNo = null;
            ultimoNo = null;
        } else {
            primeiroNo = primeiroNo.getNextNo();
            ultimoNo.setNextNo(primeiroNo);
        }
        tamanho--;
    }

    // Remove do final
    public void removeFinal() {
        if (primeiroNo == null) {
            System.out.println("Lista vazia.");
            return;
        }

        if (primeiroNo == ultimoNo) {
            primeiroNo = null;
            ultimoNo = null;
        } else {
            No<T> atual = primeiroNo;
            while (atual.getNextNo() != ultimoNo) {
                atual = atual.getNextNo();
            }
            atual.setNextNo(primeiroNo);
            ultimoNo = atual;
        }
        tamanho--;
    }

    // Imprime a lista
    public void imprimeLista() {
        if (primeiroNo == null) {
            System.out.println("Lista vazia.");
            return;
        }

        No<T> atual = primeiroNo;
        do {
            System.out.print(atual.getDado() + " ");
            atual = atual.getNextNo();
        } while (atual != primeiroNo);
        System.out.println();
    }
}
