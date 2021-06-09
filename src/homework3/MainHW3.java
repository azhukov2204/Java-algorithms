package homework3;

import homework1.Person;

import java.util.*;

public class MainHW3 {

    private static final Random random = new Random();
    private static final int GENERATE_INT_RANDOM_ARRAY_SIZE = 4000;
    private static final int MAX_ARRAY_ITEM_VALUE = 4000;

    public static void main(String[] args) {
        System.out.println("Homework3\n");

        Integer[] originalIntArray = generateIntRandomArray();
        long startTime, endTime;

        /*Задание 3.1
        На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
        Оцените время выполнения преобразования.*/
        System.out.println("Преобразование массива в ArrayList");
        startTime = System.nanoTime();
        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(originalIntArray));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Преобразование массива в LinkedList");
        startTime = System.nanoTime();
        LinkedList<Integer> integerLinkedList = new LinkedList<>(Arrays.asList(originalIntArray));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 3.2
        На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
        Оценить выполненные методы с помощью базового класса System.nanoTime().*/
        System.out.println("Метод add в ArrayList");
        startTime = System.nanoTime();
        integerArrayList.add(999);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод add в LinkedList");
        startTime = System.nanoTime();
        integerLinkedList.add(999);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод get в ArrayList");
        startTime = System.nanoTime();
        System.out.println("Считанный элемент: " + integerArrayList.get(3000));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод get в LinkedList");
        startTime = System.nanoTime();
        System.out.println("Считанный элемент: " + integerLinkedList.get(3000));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод contains в ArrayList");
        startTime = System.nanoTime();
        System.out.println("Считанный элемент: " + integerArrayList.contains(999));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод contains в LinkedList");
        startTime = System.nanoTime();
        System.out.println("Считанный элемент: " + integerLinkedList.contains(999));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод remove по индексу в ArrayList");
        startTime = System.nanoTime();
        integerArrayList.remove(2000);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод remove по индексу в LinkedList");
        startTime = System.nanoTime();
        integerLinkedList.remove(2000);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод remove объекта в ArrayList");
        startTime = System.nanoTime();
        integerArrayList.remove(new Integer(999));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод remove объекта в LinkedList");
        startTime = System.nanoTime();
        integerLinkedList.remove(new Integer(999));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод set в ArrayList");
        startTime = System.nanoTime();
        integerArrayList.set(125, 2222);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Метод set в LinkedList");
        startTime = System.nanoTime();
        integerLinkedList.set(125, 2222);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 3.3
        Реализуйте простой односвязный список и его базовые методы.*/
        System.out.println("Пример SinglyLinkedList");
        System.out.println("Добавление элементов в SinglyLinkedList:");
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(15);
        singlyLinkedList.add(25);
        singlyLinkedList.add(45);
        System.out.println(singlyLinkedList);
        System.out.println("Удаление первого элемента из SinglyLinkedList:");
        singlyLinkedList.deleteFirst();
        System.out.println(singlyLinkedList);
        System.out.println("Проверка наличия объекта в SinglyLinkedList:");
        System.out.println("Содержит ли SinglyLinkedList объект 42: " + singlyLinkedList.contains(42));
        System.out.println("Содержит ли SinglyLinkedList объект 15: " + singlyLinkedList.contains(15));
        System.out.println();

        /*Задание 3.4
        На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        Реализуйте список заполненный объектами из вашего класса из задания 1.3*/
        System.out.println("Преобразование ArrayList в LinkedList:");
        startTime = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>(integerArrayList);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();
        //базовые методы LinkedList тестируются выше

        System.out.println("Реализация списка, заполненного объектами Person (задание 1.3):");
        LinkedList<Person> personLinkedList = new LinkedList<>();
        personLinkedList.add(new Person("Ivan", 25));
        personLinkedList.add(new Person("Peter", 18));
        personLinkedList.add(new Person("Sergey", 30));
        System.out.println(personLinkedList);

        /*Задание 3.5
        Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        Оцените время выполнения операций с помощью базового метода System.nanoTime()*/
        ListIterator<Person> personListIterator = personLinkedList.listIterator();

        System.out.println("ListIterator, в прямом порядке:");
        startTime = System.nanoTime();
        while (personListIterator.hasNext()) {
            System.out.print(personListIterator.nextIndex() + " - ");
            System.out.println(personListIterator.next());
        }
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("ListIterator, в обратном порядке:");
        startTime = System.nanoTime();
        while (personListIterator.hasPrevious()) {
            System.out.print(personListIterator.previousIndex() + " - ");
            System.out.println(personListIterator.previous());
        }
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("ListIterator, замена такущего элемента:");
        startTime = System.nanoTime();
        personListIterator.set(new Person("NoName", 0));
        endTime = System.nanoTime();
        System.out.println(personLinkedList);
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("ListIterator, вставка нового элемента:");
        startTime = System.nanoTime();
        personListIterator.add(new Person("Alexander", 16));
        endTime = System.nanoTime();
        System.out.println(personLinkedList);
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();
    }

    private static Integer[] generateIntRandomArray() {
        Integer[] intArray = new Integer[GENERATE_INT_RANDOM_ARRAY_SIZE];
        for (int i = 0; i < GENERATE_INT_RANDOM_ARRAY_SIZE; i++) {
            intArray[i] = random.nextInt(MAX_ARRAY_ITEM_VALUE);
        }
        return intArray;
    }
}
