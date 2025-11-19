import java.io.*;
import java.util.*;

public class Principal {
    
    // Lista para armazenar os resultados formatados
    private static List<String[]> results = new ArrayList<>();

    public static void main(String[] args) {
        // Nome do arquivo de entrada: configurado para numeros_tamanho10000000.txt
        String inputFileName = "numeros_tamanho1000000.txt"; 
        List<Integer> numbers = readNumbersFromFile(inputFileName);

        if (numbers == null) {
            System.out.println("Erro ao ler o arquivo. Certifique-se de que '" + inputFileName + "' existe.");
            return;
        }

        System.out.println("--- 📊 Iniciando Testes de Algoritmos de Ordenação ---");
        System.out.println("Tamanho da amostra: " + numbers.size() + " números.");
        System.out.println("Arquivo de entrada: " + inputFileName + "\n");
        
        long startTime;
        long endTime;
        long durationNano;

        // --- 1. Testando BubbleSort --- (Pode ser muito lento para 10 milhões)
        int[] bubbleArray = listToArray(numbers);
        startTime = System.nanoTime();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(bubbleArray);
        endTime = System.nanoTime();
        durationNano = endTime - startTime;
        addResult("BubbleSort", durationNano, inputFileName);
        writeNumbersToFile(arrayToList(bubbleArray), inputFileName, "bubble");

        // --- 2. Testando InsertionSort --- (Pode ser muito lento para 10 milhões)
        int[] insertionArray = listToArray(numbers);
        startTime = System.nanoTime();
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(insertionArray);
        endTime = System.nanoTime();
        durationNano = endTime - startTime;
        addResult("InsertionSort", durationNano, inputFileName);
        writeNumbersToFile(arrayToList(insertionArray), inputFileName, "insertion");

        // --- 3. Testando QuickSort ---
        int[] quickArray = listToArray(numbers);
        startTime = System.nanoTime();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(quickArray, 0, quickArray.length - 1); 
        endTime = System.nanoTime();
        durationNano = endTime - startTime;
        addResult("QuickSort", durationNano, inputFileName);
        writeNumbersToFile(arrayToList(quickArray), inputFileName, "quick");

        // --- 4. Testando BucketSort ---
        List<Integer> bucketList = new ArrayList<>(numbers); 
        // Lidar com exceção para lista vazia, embora readNumbersFromFile retorne null
        int maxVal = numbers.isEmpty() ? 0 : Collections.max(numbers); 
        
        startTime = System.nanoTime();
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(bucketList, maxVal); 
        endTime = System.nanoTime();
        durationNano = endTime - startTime;
        addResult("BucketSort", durationNano, inputFileName);
        writeNumbersToFile(bucketList, inputFileName, "bucket");
        
        // --- 5. Testando MergeSort ---
        int[] mergeArray = listToArray(numbers);
        startTime = System.nanoTime();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(mergeArray, 0, mergeArray.length - 1); 
        endTime = System.nanoTime();
        durationNano = endTime - startTime;
        addResult("MergeSort", durationNano, inputFileName);
        writeNumbersToFile(arrayToList(mergeArray), inputFileName, "merge");
        
        // --- 6. Testando SelectionSort --- (Pode ser muito lento para 10 milhões)
        int[] selectionArray = listToArray(numbers);
        startTime = System.nanoTime();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(selectionArray);
        endTime = System.nanoTime();
        durationNano = endTime - startTime;
        addResult("SelectionSort", durationNano, inputFileName);
        writeNumbersToFile(arrayToList(selectionArray), inputFileName, "selection");
        
        // Imprime os resultados formatados na tabela
        printFormattedResults();
    }
    
    // MÉTODO MODIFICADO: Seleciona segundos ou milissegundos
    private static void addResult(String algorithm, long durationNano, String inputFileName) {
        // 1 segundo em nanosegundos
        final long ONE_SECOND_NANO = 1_000_000_000L; 
        
        String formattedTime;
        
        if (durationNano >= ONE_SECOND_NANO) {
            // Tempo em segundos (s)
            double durationSeconds = durationNano / 1_000_000_000.0;
            formattedTime = String.format("%.3f s", durationSeconds);
        } else {
            // Tempo em milissegundos (ms)
            double durationMillis = durationNano / 1_000_000.0;
            formattedTime = String.format("%.3f ms", durationMillis);
        }
        
        String outputFileName = inputFileName.replace(".txt", "_" + algorithm.toLowerCase().replace("sort", "") + ".txt");
        
        results.add(new String[]{
            algorithm,
            formattedTime, // Usa o tempo formatado (s ou ms)
            outputFileName
        });
    }
    
    // MÉTODO MODIFICADO: Aumenta o espaço para o tempo para acomodar valores maiores em segundos
    private static void printFormattedResults() {
        System.out.println("\n--- ⏱️ Tabela de Tempo de Execução ---");
        
        // Aumenta o espaço para TEMPO de 12 para 14 para caber algo como "123.456 s"
        String header = String.format("| %-15s | %-14s | %-35s |", 
                                      "ALGORITMO", "TEMPO", "ARQUIVO DE SAÍDA");
        
        // Imprime a linha de separação e o cabeçalho
        String separator = new String(new char[header.length()]).replace('\0', '-');
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        
        // Imprime os dados
        for (String[] result : results) {
            System.out.println(String.format("| %-15s | %-14s | %-35s |", 
                                              result[0], result[1], result[2]));
        }
        System.out.println(separator);
    }
    
    // --- MÉTODOS AUXILIARES (inalterados) ---

    private static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numberStrings = line.split("[,\\s]+"); 
                for (String numStr : numberStrings) {
                    try {
                        String trimmedStr = numStr.trim();
                        if (!trimmedStr.isEmpty()) { 
                            numbers.add(Integer.parseInt(trimmedStr)); 
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Aviso: Erro ao converter número em '" + fileName + "': " + numStr);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return numbers;
    }

    private static int[] listToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    private static void writeNumbersToFile(List<Integer> numbers, String inputFileName, String algorithm) {
        String outputFileName = inputFileName.replace(".txt", "_" + algorithm + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int number : numbers) {
                bw.write(number + " ");
            }
            bw.newLine();
            System.out.println("✔ Arquivo de saída criado: " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}