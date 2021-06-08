package homework2;

import java.util.Arrays;
import java.util.Random;

public class MainHW2 {

    private static final Random random = new Random();
    private static final int GENERATE_INT_RANDOM_ARRAY_SIZE = 400;
    private static final int MAX_ARRAY_ITEM_VALUE = 400;

    public static void main(String[] args) {
        System.out.println("Homework2\n");
        /*Задание 2.1
        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
        Выполните обращение к массиву и базовые операции класса Arrays.
        Оценить выполненные методы с помощью базового класса System.nanoTime().*/

        int[] originalIntArray = generateIntRandomArray();

        long startTime, endTime;

        System.out.println("Тест метода toString:");
        startTime = System.nanoTime();
        System.out.println(Arrays.toString(originalIntArray));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Тест метода copyOf:");
        startTime = System.nanoTime();
        int[] copyIntArray = Arrays.copyOf(originalIntArray, originalIntArray.length);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Тест метода equals:");
        startTime = System.nanoTime();
        System.out.println("Are arrays equivalent? :" + Arrays.equals(originalIntArray, copyIntArray));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();


        /*Задание 2.2
        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.*/

        int valueToFind = originalIntArray[originalIntArray.length - 1];

        System.out.println("Тест линейного поиска:");
        startTime = System.nanoTime();
        System.out.printf("Искомое значение %d под индексом %d (первое совпадение)", valueToFind, linearSearch(valueToFind, originalIntArray));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Тест бинарного поиска:");
        int[] binarySearchArray = Arrays.copyOf(originalIntArray, originalIntArray.length);
        startTime = System.nanoTime();
        System.out.printf("Искомое значение %d под индексом %d (первое совпадение)", valueToFind, binarySearch(valueToFind, binarySearchArray));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 2.3
        Создайте массив размером 400 элементов.
        Выполните сортировку с помощью метода sort().
        Оцените сортировку с помощью базового класса System.nanoTime().*/
        System.out.println("Тест скорости сортировки методом sort:");
        int[] arrayForSort = Arrays.copyOf(originalIntArray, originalIntArray.length);
        startTime = System.nanoTime();
        Arrays.sort(arrayForSort);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 2.4
        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.*/
        System.out.println("Тест скорости сортировки пузырьком:");
        int[] arrayForBubbleSort = Arrays.copyOf(originalIntArray, originalIntArray.length);
        startTime = System.nanoTime();
        bubbleSort(arrayForBubbleSort);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 2.5
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.*/
        System.out.println("Тест скорости сортировки выбором:");
        int[] arrayForSelectionSort = Arrays.copyOf(originalIntArray, originalIntArray.length);
        startTime = System.nanoTime();
        selectionSort(arrayForSelectionSort);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 2.6
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.*/
        System.out.println("Тест скорости сортировки методом вставки:");
        int[] arrayForInsertionSort = Arrays.copyOf(originalIntArray, originalIntArray.length);
        startTime = System.nanoTime();
        insertionSort(arrayForInsertionSort);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();
    }

    private static int[] generateIntRandomArray() {
        int[] intArray = new int[GENERATE_INT_RANDOM_ARRAY_SIZE];
        for (int i = 0; i < GENERATE_INT_RANDOM_ARRAY_SIZE; i++) {
            intArray[i] = random.nextInt(MAX_ARRAY_ITEM_VALUE);
        }
        return intArray;
    }

    private static int linearSearch(int valueToFind, int[] source) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == valueToFind) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int valueToFind, int[] source) {
        Arrays.sort(source);
        int firstIndex = 0;
        int lastIndex = source.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (source[middleIndex] == valueToFind) {
                return middleIndex;
            } else if (source[middleIndex] < valueToFind) {
                firstIndex = middleIndex + 1;
            } else if (source[middleIndex] > valueToFind) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    private static void bubbleSort(int[] arrayForBubbleSort) {
        for (int i = arrayForBubbleSort.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayForBubbleSort[j] > arrayForBubbleSort[j + 1]) {
                    swap(arrayForBubbleSort, j, j + 1);
                }
            }
        }
    }

    private static void selectionSort(int[] arrayForSelectionSort) {
        for (int i = 0; i < arrayForSelectionSort.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayForSelectionSort.length; j++) {
                if (arrayForSelectionSort[j] < arrayForSelectionSort[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arrayForSelectionSort, i, minIndex);
        }
    }

    private static void insertionSort(int[] arrayForInsertionSort) {
        int insertIndex;
        for (int i = 1; i < arrayForInsertionSort.length; i++) {
            int buff = arrayForInsertionSort[i];
            insertIndex = i;
            while (insertIndex > 0 && arrayForInsertionSort[insertIndex - 1] >= buff) {
                arrayForInsertionSort[insertIndex] = arrayForInsertionSort[insertIndex - 1];
                --insertIndex;
            }
            arrayForInsertionSort[insertIndex] = buff;
        }
    }

    public static void swap(int[] source, int first, int last) {
        int buff = source[first];
        source[first] = source[last];
        source[last] = buff;
    }
}
