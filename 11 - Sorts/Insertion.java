public class Insertion {
    public void sort(int[] vector) {
        int i, j, key;
        for (i = 1; i < vector.length; i++) {
            key = vector[i];
            j = i - 1;
            while (j >= 0 && vector[j] > key) {
                vector[j + 1] = vector[j];
                j = j - 1;
            }
            vector[j + 1] = key;
        }
    }
}