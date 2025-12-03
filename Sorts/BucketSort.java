import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    /**
     * Ordena uma lista de inteiros usando o algoritmo Bucket Sort.
     * A assinatura deve aceitar List<Integer> e int (maxVal).
     * @param list A lista de inteiros a ser ordenada.
     * @param maxVal O valor máximo na lista.
     */
    public void sort(List<Integer> list, int maxVal) {
        
        int numBuckets = 10;
        List<List<Integer>> buckets = new ArrayList<>(numBuckets);
        
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Mapeia cada elemento para um balde
        for (int value : list) {
            // Garante que o índice não exceda o limite. Usamos (maxVal + 1) para evitar
            // divisão por zero e garantir que o valor máximo caia no último balde.
            int bucketIndex = (int) (((double) value / (maxVal + 1)) * numBuckets);
            buckets.get(bucketIndex).add(value);
        }
        
        // 

        // Ordena e concatena os baldes
        list.clear();
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); 
            list.addAll(bucket);
        }
    }
}