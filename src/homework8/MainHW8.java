package homework8;

import java.util.Random;

public class MainHW8 {
    private static final Random RANDOM = new Random();
    private static final int HASH_TABLE_SIZE = 10;
    private static final int MAX_RANDOM_VALUE = 1000;
    private static final int GENERATE_INT_RANDOM_ARRAY_SIZE;

    static {
        GENERATE_INT_RANDOM_ARRAY_SIZE = HASH_TABLE_SIZE / 2;
    }

    public static void main(String[] args) {
        System.out.println("Homework8\n");

        int[] intArray = generateIntRandomArray();

        /*Задание 8.4
        На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования*/
        HashTableLinearProbing hashTableLinearProbing = new HashTableLinearProbing(HASH_TABLE_SIZE);

        System.out.println("Заполняем таблицу HashTableLinearProbing наполовину случайными числами: ");
        for (int i : intArray) {
            hashTableLinearProbing.insert(new Item(i));
        }
        hashTableLinearProbing.display();
        System.out.println();

        System.out.println("Заполним еще нсколько элементов в HashTableLinearProbing: ");
        hashTableLinearProbing.insert(new Item(500));
        hashTableLinearProbing.insert(new Item(70));
        hashTableLinearProbing.insert(new Item(70)); //коллизия
        hashTableLinearProbing.display();
        System.out.println();

        int searchData = 500;
        System.out.printf("Поиск элемента %d в HashTableLinearProbing: \n", searchData);
        Item searchItem = hashTableLinearProbing.find(searchData);
        String result = (searchItem == null) ? "Элемент не найден" : "Найден элемент " + searchItem.getData();
        System.out.println(result);
        System.out.println();

        int itemForDelete = 70;
        System.out.printf("Удаление элемента %d из  HashTableLinearProbing\n", itemForDelete);
        hashTableLinearProbing.delete(itemForDelete);
        hashTableLinearProbing.display();
        System.out.println();

        /*Задание 8.5
        Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного хеширования.
        Сравните отличительные черты двух алгоритмов.*/

        HashTableDoubleHashing hashTableDoubleHashing = new HashTableDoubleHashing(HASH_TABLE_SIZE);

        System.out.println("Заполняем таблицу HashTableDoubleHashing наполовину случайными числами: ");
        for (int i : intArray) {
            hashTableDoubleHashing.insert(new Item(i));
        }
        hashTableDoubleHashing.display();
        System.out.println();

        System.out.println("Заполним еще нсколько элементов в HashTableDoubleHashing: ");
        hashTableDoubleHashing.insert(new Item(500));
        hashTableDoubleHashing.insert(new Item(70));
        hashTableDoubleHashing.insert(new Item(70)); //коллизия
        hashTableDoubleHashing.display();
        System.out.println();

        System.out.printf("Поиск элемента %d в HashTableLinearProbing: \n", searchData);
        searchItem = hashTableDoubleHashing.find(searchData);
        result = (searchItem == null) ? "Элемент не найден" : "Найден элемент " + searchItem.getData();
        System.out.println(result);
        System.out.println();

        System.out.printf("Удаление элемента %d из  HashTableDoubleHashing\n", itemForDelete);
        hashTableDoubleHashing.delete(itemForDelete);
        hashTableDoubleHashing.display();
    }

    private static int[] generateIntRandomArray() {
        int[] intArray = new int[GENERATE_INT_RANDOM_ARRAY_SIZE];
        for (int i = 0; i < GENERATE_INT_RANDOM_ARRAY_SIZE; i++) {
            intArray[i] = RANDOM.nextInt(MAX_RANDOM_VALUE);
        }
        return intArray;
    }
}
