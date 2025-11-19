import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    // Entrada pública com bucketSize padrão (10)
    public void sort(int[] array) {
        sort(array, 10);
    }

    // Versão configurável: bucketSize é o intervalo de valores em cada balde
    public void sort(int[] array, int bucketSize) {
        if (array == null || array.length <= 1) return;
        if (bucketSize <= 0) bucketSize = 10;

        // 1) encontrar valor mínimo e máximo
        int min = array[0], max = array[0];
        for (int v : array) {
            if (v < min) min = v;
            if (v > max) max = v;
        }

        // 2) determinar quantos buckets precisamos
        int bucketCount = (max - min) / bucketSize + 1;

        // 3) criar buckets (cada bucket é uma lista dinâmica)
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 4) distribuir os elementos entre os buckets
        for (int v : array) {
            int index = (v - min) / bucketSize; // posição do bucket
            buckets.get(index).add(v);
        }

        // 5) ordenar cada bucket (usamos insertion sort nas listas — estável)
        for (List<Integer> bucket : buckets) {
            insertionSortList(bucket);
        }

        // 6) concatenar os buckets de volta ao array original
        int pos = 0;
        for (List<Integer> bucket : buckets) {
            for (int v : bucket) {
                array[pos++] = v;
            }
        }
    }

    // Insertion sort em um List<Integer> — mantém estabilidade (elementos iguais na ordem de inserção)
    private void insertionSortList(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            // desloca elementos maiores que key para a direita
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}
