package homework4;

import homework1.Person;

import java.util.*;

public class MainHW4 {
    public static void main(String[] args) {
        System.out.println("Homework4\n");
        long startTime, endTime;

        /*Задание 4.1
        На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        System.out.println("Создаем Stack:");
        Stack<Person> personStack = new Stack<>();

        System.out.println("Выполняем 3 раза метод add:");
        startTime = System.nanoTime();
        personStack.add(new Person("Ivan", 25));
        personStack.add(new Person("Peter", 18));
        personStack.add(new Person("Sergey", 30));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем 3 раза метод push:");
        startTime = System.nanoTime();
        personStack.push(new Person("Alex", 25));
        personStack.push(new Person("Igor", 18));
        personStack.push(new Person("Maxim", 30));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод search:");
        startTime = System.nanoTime();
        System.out.println(personStack.search(new Person("Alex", 25)));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод peek:");
        startTime = System.nanoTime();
        System.out.println(personStack.peek());
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем извлечение элементов из стека:");
        startTime = System.nanoTime();
        while (!personStack.isEmpty()) {
            System.out.println(personStack.pop());
        }
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 4.2
        На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        Реализуйте вспомогательные методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        System.out.println("Создаем Queue:");
        Queue<Person> personQueue = new LinkedList<>();

        System.out.println("Выполняем 3 раза метод add:");
        startTime = System.nanoTime();
        personQueue.add(new Person("Ivan", 25));
        personQueue.add(new Person("Peter", 18));
        personQueue.add(new Person("Sergey", 30));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем 3 раза метод offer:");
        startTime = System.nanoTime();
        personQueue.offer(new Person("Alex", 25));
        personQueue.offer(new Person("Igor", 18));
        personQueue.offer(new Person("Maxim", 30));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод peek:");
        startTime = System.nanoTime();
        System.out.println(personQueue.peek());
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод size:");
        startTime = System.nanoTime();
        System.out.println("size(): " + personQueue.size());
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем извлечение элементов из очереди:");
        startTime = System.nanoTime();
        while (!personQueue.isEmpty()) {
            System.out.println(personQueue.poll());
        }
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 4.3
        На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        Deque<Person> personDeque = new ArrayDeque<>();

        System.out.println("Выполняем 3 раза метод add:");
        startTime = System.nanoTime();
        personDeque.add(new Person("Ivan", 25));
        personDeque.add(new Person("Peter", 18));
        personDeque.add(new Person("Sergey", 30));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод addFirst:");
        startTime = System.nanoTime();
        personDeque.addFirst(new Person("Alex", 25));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод addLast:");
        startTime = System.nanoTime();
        personDeque.addLast(new Person("Igor", 18));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод peekFirst:");
        startTime = System.nanoTime();
        System.out.println(personDeque.peekFirst());
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод peekLast:");
        startTime = System.nanoTime();
        System.out.println(personDeque.peekLast());
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод pollFirst:");
        startTime = System.nanoTime();
        System.out.println(personDeque.pollFirst());
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод pollLast:");
        startTime = System.nanoTime();
        System.out.println(personDeque.pollLast());
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем извлечение оставшихся элементов из personDeque:");
        startTime = System.nanoTime();
        while (!personDeque.isEmpty()) {
            System.out.println(personDeque.poll());
        }
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 4.4
        Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();

        System.out.println("Выполняем 3 раза метод add:");
        startTime = System.nanoTime();
        integerPriorityQueue.add(50);
        integerPriorityQueue.add(10);
        integerPriorityQueue.add(100);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем 3 раза метод offer:");
        startTime = System.nanoTime();
        integerPriorityQueue.offer(60);
        integerPriorityQueue.offer(80);
        integerPriorityQueue.offer(20);
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Выполняем метод peek:");
        startTime = System.nanoTime();
        System.out.println("peek(): " + integerPriorityQueue.peek());
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Извлекаем элементы из integerPriorityQueue:");
        startTime = System.nanoTime();
        while (!integerPriorityQueue.isEmpty()) {
            System.out.println(integerPriorityQueue.poll());
        }
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 4.5
        На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().*/
        System.out.println("Реализация StackLinkedList:");
        StackLinkedList<Person> personStackLinkedList = new StackLinkedList<>();

        System.out.println("Выполняем 3 раза метод push:");
        startTime = System.nanoTime();
        personStackLinkedList.push(new Person("Ivan", 25));
        personStackLinkedList.push(new Person("Peter", 18));
        personStackLinkedList.push(new Person("Sergey", 30));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Извлекаем элементы из personStackLinkedList:");
        startTime = System.nanoTime();
        while (!personStackLinkedList.isEmpty()) {
            System.out.println(personStackLinkedList.pop());
        }
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Реализация QueueLinkedList:");
        QueueLinkedList<Person> personQueueLinkedList = new QueueLinkedList<>();

        System.out.println("Выполняем 3 раза метод push:");
        startTime = System.nanoTime();
        personQueueLinkedList.push(new Person("Ivan", 25));
        personQueueLinkedList.push(new Person("Peter", 18));
        personQueueLinkedList.push(new Person("Sergey", 30));
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Извлекаем элементы из personQueueLinkedList:");
        startTime = System.nanoTime();
        while (!personQueueLinkedList.isEmpty()) {
            System.out.println(personQueueLinkedList.pop());
        }
        endTime = System.nanoTime();
        System.out.println("Затраченное время (нс): " + (endTime - startTime));
        System.out.println();
    }
}
