public class QuickSort {
    public void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    /**
     * Particiona o subarray array[start..end] usando o esquema de Lomuto:
     * - pivot = array[end]
     * - coloca elementos <= pivot à esquerda e > pivot à direita
     * Retorna a posição final do pivot (index).
     */
    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1; // i é o índice do "último elemento <= pivot"
        for (int j = start; j <= end - 1; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end); // coloca pivot na posição correta
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        if (i == j) return;
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
