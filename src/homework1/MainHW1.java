package homework1;

import java.util.Random;

public class MainHW1 {
    private static final Random random = new Random();
    private static final int generatedStringLength = 6;
    private static final int generatedMinAge = 5;
    private static final int generatedMaxAge = 45;
    private static final int generatedPersonsArraySize = 100000;
    private static final int generatedStringsArraySize = 100000;
    private static final String stringGenerationAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        System.out.println("Homework1");
        /*Задание 1.3
        Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
        Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.*/

        //Примитивные переменные (только некоторые):
        int pInt1 = 1;
        float pFloat1 = 0.5f;
        boolean pBoolean1 = false;
        System.out.println("Пример некоторых примитивных переменных: ");
        System.out.println("pInt1 = " + pInt1);
        System.out.println("pFloat1 = " + pFloat1);
        System.out.println("pBoolean1 = " + pBoolean1);

        //ссылочные типы данных (только некоторые, простые)
        String str1 = "Пример строки";
        Integer lInt1 = 12; //обертка над примитивом
        Float lFlt1 = 12.5f; //обертка над примитивом
        System.out.println("Пример некоторых ссылочных переменных: ");
        System.out.println("str1 = " + str1 + " class name = " + str1.getClass().getSimpleName());
        System.out.println("int1 = " + lInt1 + " class name = " + lInt1.getClass().getSimpleName());
        System.out.println("flt1 = " + lFlt1 + " class name = " + lFlt1.getClass().getSimpleName());

        //свой класс:
        Person person1 = new Person("Иван", 16);
        System.out.println("Пример переменной свого класса: ");
        System.out.println("person1 = " + person1);

        /*Задание 1.4. Поиск перебором*/
        //Поиск перебором элементов Person
        System.out.println("Поиск перебором элементов Person: ");
        //Сгенерируем массив Person:
        Person[] persons = generateArrayOfRandomPerson();
        //выберем случайно значение, которое будем искать:
        Person personToFind = getValueToFind(persons);
        //Запускаем поиск перебором:
        searchFirstByIterateOver(personToFind, persons);

        //Поиск перебором элементов String (аналогично)
        System.out.println("Поиск перебором элементов String: ");
        //Сгенерируем массив String:
        String[] strings = generateArrayOfRandomString();
        //выберем случайно значение, которое будем искать:
        String stringToFind = getValueToFind(strings);
        //Запускаем поиск перебором:
        searchFirstByIterateOver(stringToFind, strings);

    }

    private static <T> void searchFirstByIterateOver(T valueToFind, T[] source) {
        boolean isValueFound = false;
        long startTime = System.nanoTime();
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(valueToFind)) {
                isValueFound = true;
                System.out.println("Значение найдено, индекс: " + i);
                break;
            }
        }
        if (!isValueFound) {
            System.out.println("Значение найти не удалось");
        }
        System.out.println("Затраченное время на поиск (нс): " + (System.nanoTime() - startTime));
    }

    private static Person generateRandomPerson() {
        int age = random.nextInt(generatedMaxAge + 1 - generatedMinAge) + generatedMinAge;
        return new Person(generateRandomString(), age);
    }

    private static String generateRandomString() {
        char[] lettersArray = stringGenerationAlphabet.toCharArray();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < generatedStringLength; i++) {
            name.append(lettersArray[random.nextInt(lettersArray.length)]);
        }
        return name.toString();
    }

    private static Person[] generateArrayOfRandomPerson() {
        Person[] persons = new Person[generatedPersonsArraySize];
        for (int i = 0; i < generatedPersonsArraySize; i++) {
            persons[i] = generateRandomPerson();
        }
        return persons;
    }

    private static String[] generateArrayOfRandomString() {
        String[] strings = new String[generatedStringsArraySize];
        for (int i = 0; i < generatedStringsArraySize; i++) {
            strings[i] = generateRandomString();
        }
        return strings;
    }

    private static <T> T getValueToFind(T[] source) {
        return source[random.nextInt(source.length)];
    }
}
