package homework6;

import java.util.Arrays;
import java.util.Random;

public class MainHW6 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("Homework6\n");

        /*Задание 6.2
        Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.*/
        System.out.println("Инициализируем дерево...");

        startTime = System.nanoTime();
        Tree tree = new Tree();
        endTime = System.nanoTime();
        System.out.println("Время инициализации дерева (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 6.3
        Реализуйте методы поиска и вставки узла в дерево.*/
        System.out.println("Выполняем вставку элементов в дерево...");
        startTime = System.nanoTime();
        tree.insert(new PersonWithId(16, "Andrey", 15));
        tree.insert(new PersonWithId(2, "Peter", 18));
        tree.insert(new PersonWithId(20, "Alexey", 25));
        tree.insert(new PersonWithId(1, "Ivan", 35));
        tree.insert(new PersonWithId(25, "Inna", 35));
        tree.insert(new PersonWithId(17, "Marina", 35));
        tree.insert(new PersonWithId(5, "Fedor", 35));
        endTime = System.nanoTime();
        System.out.println("Время вставки 7 элементов (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем поиск элемента в дереве...");
        findAndDisplay(tree, 1);
        findAndDisplay(tree, 3);
        findAndDisplay(tree, 16);

        /*Задание 6.4
        Реализуйте базовые методы обхода дерева и метода дисплей.
        Реализуйте поиск максимума и минимума.*/
        System.out.println("Обход дерева разными способами...");

        startTime = System.nanoTime();
        tree.displayTree();
        endTime = System.nanoTime();
        System.out.println("Время обхода дерева 3-мя способами (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Максимум:");
        startTime = System.nanoTime();
        Node max = tree.max();
        endTime = System.nanoTime();
        System.out.println("Время поиска максимума (нс): " + (endTime - startTime));
        max.display();
        System.out.println();

        System.out.println("Минимум:");
        startTime = System.nanoTime();
        Node min = tree.min();
        endTime = System.nanoTime();
        System.out.println("Время поиска минимума (нс): " + (endTime - startTime));
        min.display();
        System.out.println();


        /*Задание 6.5
        Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().*/
        System.out.println("Удаление узла...");
        startTime = System.nanoTime();
        tree.delete(20);
        endTime = System.nanoTime();
        System.out.println("Время удаления узла (нс): " + (endTime - startTime));
        System.out.println();

        tree.displayTree();
        System.out.println();

        /*Задание 6.6
        Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.*/
        int arraySize = 400;
        int maxArrayItemValue = 1000;
        int[] testArray = generateIntRandomArray(arraySize, maxArrayItemValue);
        int[] copyOfTestArray = Arrays.copyOf(testArray, testArray.length);

        System.out.println("Выполнение пирамидальной сортировки");
        startTime = System.nanoTime();
        HeapSort.sort(testArray);
        endTime = System.nanoTime();
        System.out.println("Время выполнения сортировки (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполнение сортировки методом sort");
        startTime = System.nanoTime();
        Arrays.sort(copyOfTestArray);
        endTime = System.nanoTime();
        System.out.println("Время выполнения сортировки (нс): " + (endTime - startTime));
        System.out.println();

        if (Arrays.equals(copyOfTestArray, testArray)) {
            System.out.println("Массивы идентичны");
        } else {
            System.out.println("В массивах есть отличия!");
        }
    }

    private static void findAndDisplay(Tree tree, int key) {
        long startTime, endTime;
        startTime = System.nanoTime();
        Node foundNode = tree.find(key);
        endTime = System.nanoTime();
        System.out.println("Время поиска (нс): " + (endTime - startTime));
        if (foundNode != null) {
            foundNode.display();
        } else {
            System.out.printf("Элемент с индексом %d не найден\n", key);
        }
        System.out.println();
    }

    private static int[] generateIntRandomArray(int arraySize, int maxArrayItemValue) {
        int[] intArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            intArray[i] = random.nextInt(maxArrayItemValue);
        }
        return intArray;
    }
}
