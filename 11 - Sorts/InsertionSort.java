public class InsertionSort {
    public void insercao(int[] vetor) {
        int aux, i, j;
        for (i = 1; i < vetor.length; i++) {
            aux = vetor[i];
            for (j = i; (j > 0) && (aux < vetor[j - 1]); j--) {
                vetor[j] = vetor[j - 1];
            }
            vetor[j] = aux;
        }
    }
}

