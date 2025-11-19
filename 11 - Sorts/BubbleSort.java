public class BubbleSort {

    /**
     * Ordena um array de inteiros usando o algoritmo Bubble Sort.
     * @param arr O array de inteiros a ser ordenado.
     */
    public void sort(int[] arr) {
        int n = arr.length;
        // 
        
        // Loop externo: percorre o array n-1 vezes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Flag de otimização
            
            // Loop interno: compara elementos adjacentes
            // A cada iteração i, o maior elemento é 'empurrado' para a posição n-1-i
            for (int j = 0; j < n - 1 - i; j++) {
                
                // Se o elemento atual for maior que o próximo, troque-os
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // Se nenhum elemento foi trocado na passagem interna, o array está ordenado
            if (!swapped) {
                break;
            }
        }
    }
}