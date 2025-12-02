public class InsertionSort {

    /**
     * Ordena um array de inteiros usando o algoritmo Insertion Sort.
     * * O Insertion Sort funciona construindo a sequência final ordenada
     * um item de cada vez. Ele itera sobre o array, pegando o elemento
     * atual e inserindo-o na posição correta da sub-lista já ordenada
     * (à sua esquerda).
     * * @param arr O array de inteiros a ser ordenado.
     */
    public void sort(int[] arr) {
        // 
        
        int n = arr.length;
        
        // Começamos do segundo elemento (índice 1), pois o primeiro elemento (índice 0) 
        // é trivialmente considerado como a primeira sub-lista ordenada.
        for (int i = 1; i < n; ++i) {
            
            // 'key' é o elemento a ser inserido na sub-lista ordenada.
            int key = arr[i];
            
            // 'j' é o índice do último elemento da sub-lista ordenada (à esquerda de 'key').
            int j = i - 1;

            // Move os elementos da sub-lista ordenada (arr[0...i-1]) que são 
            // MAIORES que 'key' uma posição à frente de sua posição atual.
            while (j >= 0 && arr[j] > key) {
                // Desloca o elemento para a direita.
                arr[j + 1] = arr[j]; 
                
                // Move para o próximo elemento à esquerda.
                j = j - 1;
            }
            
            // Insere 'key' na sua posição correta na sub-lista ordenada.
            arr[j + 1] = key;
        }
    }
}