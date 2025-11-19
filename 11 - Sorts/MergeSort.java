public class MergeSort {
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    private void merge(int[] array, int start, int middle, int end) {
        int size = end - start + 1;
        int[] temp = new int[size];
        int left = start, right = middle + 1, index = 0;

        while (left <= middle && right <= end) {
            if (array[left] <= array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }

        while (left <= middle) {
            temp[index++] = array[left++];
        }

        while (right <= end) {
            temp[index++] = array[right++];
        }

        for (int i = 0; i < size; i++) {
            array[start + i] = temp[i];
        }
    }
}
