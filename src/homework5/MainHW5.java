package homework5;

import java.util.Arrays;
import java.util.Random;

public class MainHW5 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Homework5\n");

        /*Задание 5.1
        Приведите пример использования рекурсии.

        Из примера на уроке:
        1)	Вычисление факториала: n! = n x (n - 1)!
            5! = 5 х 4 х 3 х 2 х 1
        2)	Числа Фибоначи: F0 = 0, F1 = 1, Fn = Fn-1 + Fn-2
        */

        int n = 10;
        System.out.printf("Факториал числа %d = %d\n\n", n, factorialByRecursion(n));

        /*Задание 5.2
        Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.*/

        //запуск бесконечной рекурсии (для запуска раскомментировать строчку ниже):
        //simpleRecursion(false, 50);

        //запуск рекурсии с условием для выхода:
        simpleRecursion(true, 50);

        /*Задание 5.3
        Приведите пример изображающий стек вызова и стек вызова с рекурсией.*/

        /*чуть выше в примере 5.1 как раз изображается данный пример
        System.out.printf("Факториал числа %d = %d\n\n", n, factorial(n)); - в данном примере происходит вызов метода printf,
        в котором в свою очередь выполняется вызов метода factorial(n). Вызов factorial(n) помещается в стек обратного вызова.
        Т.е. вначале выполняется вычисление факториала, а затем информация выводится в терминал.
        В свою очередь метод factorial(n) также реализован через рекурсию (вызывает сам себя). И стек заполняется до тех пор, пока не будет
        вызван данный метод с аргументом 0. После этого будет выполнено вычивление (если конечно не произойдет переполнение стека, если задать слишком большое число)
        */

        /*Задание 5.4
        Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        Оцените два алгоритма с помощью базового метода System.nanoTime().*/
        long startTime, endTime;

        System.out.println("Вычисление факториала рекурсией: ");
        startTime = System.nanoTime();
        int factorialRecursionResult = factorialByRecursion(n);
        endTime = System.nanoTime();
        System.out.println("Время вычисления составило (нс): " + (endTime - startTime));
        System.out.println("Вычисленное значение: " + factorialRecursionResult);

        System.out.println("Вычисление факториала циклом: ");
        startTime = System.nanoTime();
        int factorialCycleResult = factorialByCycle(n);
        endTime = System.nanoTime();
        System.out.println("Время вычисления составило (нс): " + (endTime - startTime));
        System.out.println("Вычисленное значение: " + factorialCycleResult);

        /*Задание 5.5
        Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.*/

        int arraySize = 400;
        int maxArrayItemValue = 1000;

        int[] testArray = generateIntRandomArray(arraySize, maxArrayItemValue);
        Arrays.sort(testArray);
        int valueToSearch = testArray[random.nextInt(arraySize)];

        System.out.println("Бинарный поиск циклом");
        startTime = System.nanoTime();
        int searchResultByCycle = binarySearchByCycle(valueToSearch, testArray);
        endTime = System.nanoTime();
        System.out.println("Время вычисления составило (нс): " + (endTime - startTime));
        System.out.println("Найденный индекс: " + searchResultByCycle);

        System.out.println("Бинарный поиск рекурсией");
        startTime = System.nanoTime();
        int searchResultByRecursion = binarySearchByRecursion(valueToSearch, 0, testArray.length - 1, testArray);
        endTime = System.nanoTime();
        System.out.println("Время вычисления составило (нс): " + (endTime - startTime));
        System.out.println("Найденный индекс: " + searchResultByRecursion);

        /*Задание 5.6
        На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
        Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().*/

        int[] testArrayForSort = generateIntRandomArray(arraySize, maxArrayItemValue);
        int[] testArrayForSortMerge = Arrays.copyOf(testArrayForSort, testArrayForSort.length);

        System.out.println("Сортировка методом слияния:");
        startTime = System.nanoTime();
        int[] sortedByMergeArray = sortMerge(testArrayForSortMerge);
        endTime = System.nanoTime();
        System.out.println("Время вычисления составило (нс): " + (endTime - startTime));

        System.out.println("Сортировка методом sort:");
        startTime = System.nanoTime();
        Arrays.sort(testArrayForSort);
        endTime = System.nanoTime();
        System.out.println("Время вычисления составило (нс): " + (endTime - startTime));
    }

    private static int simpleRecursion(boolean useExitCondition, int value) {
        System.out.println(value);
        if (useExitCondition && value == 0) {
            return 0;
        } else {
            return simpleRecursion(useExitCondition, value - 1);
        }
    }

    private static int factorialByRecursion(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorialByRecursion(n - 1) * n;
        }
    }

    private static int factorialByCycle(int n) {
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static int binarySearchByCycle(int valueToFind, int[] source) {
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

    public static int binarySearchByRecursion(int valueToFind, int lowIndex, int highIndex, int[] source) {
        if (lowIndex > highIndex) {
            return source.length;
        }
        int middleIndex = (lowIndex + highIndex) / 2;
        if (source[middleIndex] == valueToFind) {
            return middleIndex;
        } else if (source[middleIndex] < valueToFind) {
            return binarySearchByRecursion(valueToFind, middleIndex + 1, highIndex, source);
        } else {
            return binarySearchByRecursion(valueToFind, lowIndex, middleIndex - 1, source);
        }
    }

    private static int[] generateIntRandomArray(int arraySize, int maxArrayItemValue) {
        int[] intArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            intArray[i] = random.nextInt(maxArrayItemValue);
        }
        return intArray;
    }

    private static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)), sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}
