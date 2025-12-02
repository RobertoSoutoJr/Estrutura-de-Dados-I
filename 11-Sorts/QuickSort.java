public class QuickSort {

    /**
     * Ponto de entrada público para o QuickSort. 
     * Inicia a ordenação chamando o método auxiliar com os limites 
     * do array (low=0 e high=length-1).
     * @param arr O array de inteiros a ser ordenado.
     * @param low O índice inicial do segmento a ser ordenado.
     * @param high O índice final do segmento a ser ordenado.
     */
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            // pi é o índice de partição, arr[pi] está agora no lugar certo
            int pi = partition(arr, low, high);

            // Chamada recursiva nos sub-arrays antes e depois da partição
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // Método auxiliar para realizar a partição
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Escolhe o pivô como o último elemento
        int i = (low - 1); // Índice do menor elemento

        for (int j = low; j < high; j++) {
            // Se o elemento atual for menor ou igual ao pivô
            if (arr[j] <= pivot) {
                i++;

                // Troca arr[i] e arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Troca arr[i+1] e arr[high] (ou o pivô)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}