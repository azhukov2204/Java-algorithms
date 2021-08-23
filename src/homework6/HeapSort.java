package homework6;

public class HeapSort {
    private static int heapSize; // Размер кучи, равный размеру массива

    // Сортировка кучи
    public static void sort(int[] array) {
        buildHeap(array); // Строительство кучи
        while (heapSize > 1) {
            swap(array, 0, heapSize - 1); // Здесь могут нарушаться свойства кучи
            heapSize--;
            heapify(array, 0);        // Делается восстановления свойства кучи после метода swap
        }
    }

    // Создание кучи
    private static void buildHeap(int[] array) {
        heapSize = array.length;
        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i); // Восстановление свойств бинарной кучи
        }
    }

    // метод "хипфи" для восстановления свойств бинарной пирамиды
    private static void heapify(int[] array, int currentNodeIndex) {
        int leftChildIndex = left(currentNodeIndex);  // Определяем левого потомка
        int rightChildIndex = right(currentNodeIndex); // Определяем правого потомка
        int largestElementIndex = currentNodeIndex;  // Устанавливаем наибольший наш элемент
        if (leftChildIndex < heapSize && array[currentNodeIndex] < array[leftChildIndex]) {
            largestElementIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && array[largestElementIndex] < array[rightChildIndex]) {
            largestElementIndex = rightChildIndex;
        }
        if (currentNodeIndex != largestElementIndex) // Если currentNodeIndex не наибольшее, то происходят замены
        {
            swap(array, currentNodeIndex, largestElementIndex);
            heapify(array, largestElementIndex);
        }
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
