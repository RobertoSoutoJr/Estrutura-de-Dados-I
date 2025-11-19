public class BubbleSort {
    public void sort(int[] vector) {
        int i, continuas, aux, fim = vector.length;
        do {
            continuas = 0;
            for (i = 0; i < fim - 1; i++) {
                if (vector[i] > vector[i + 1]) {
                    aux = vector[i];
                    vector[i] = vector[i + 1];
                    vector[i + 1] = aux;
                } else {
                    continuas++;
                }
            }
            fim--;
        } while (continuas < fim - 1);
    }
}