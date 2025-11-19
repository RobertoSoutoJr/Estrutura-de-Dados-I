public class MergeSort {

    /**
     * Ponto de entrada público para o MergeSort.
     * Inicia a ordenação.
     * @param arr O array de inteiros a ser ordenado.
     * @param l O índice inicial (left).
     * @param r O índice final (right).
     */
    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            // Encontra o ponto do meio
            int m = l + (r - l) / 2; // Maneira mais segura de calcular o meio

            // Ordena as duas metades
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Combina as duas metades ordenadas
            merge(arr, l, m, r);
        }
    }
    
    // Método auxiliar para combinar (merge) as sub-matrizes
    private void merge(int[] arr, int l, int m, int r) {
        // 
        
        int n1 = m - l + 1;
        int n2 = r - m;

        // Cria arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia dados para os arrays temporários L[] e R[]
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0; // Índices iniciais das sub-matrizes temporárias
        int k = l;        // Índice inicial da sub-matriz mesclada

        // Mescla L[] e R[] de volta em arr[l..r]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de L[], se houver
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de R[], se houver
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}