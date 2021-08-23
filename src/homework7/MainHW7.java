package homework7;

public class MainHW7 {
    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("Homework7\n");

        /*Задание 7.2
        Реализуйте базовые методы графа.*/
        System.out.println("Инициализация графа...");
        Graph graph = new Graph();
        System.out.println("Добавление вершин...");
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J'); //эта вершина не связана

        System.out.println("Заполнение матрицы связей...");
        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE
        graph.addEdge(0, 5); //AF
        graph.addEdge(5, 6); //FG
        graph.addEdge(6, 7); //GH
        graph.addEdge(6, 8); //GI

        System.out.println("Вывод информации о вершинах...");
        graph.displayVertex(1);
        graph.displayVertex(2);
        graph.displayVertex(3);
        graph.displayVertex(4);
        graph.displayVertex(5);
        graph.displayVertex(6);
        graph.displayVertex(7);
        graph.displayVertex(8);
        graph.displayVertex(9);
        System.out.println();

        /*Задание 7.3
        В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
        Выполните оценку времени с помощью System.nanoTime().*/

        System.out.println("Обход графа в глубину, первый метод...");
        startTime = System.nanoTime();
        graph.depthFirstTraversal();
        endTime = System.nanoTime();
        System.out.println("Время обхода (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Обход графа в глубину, второй метод (рекурсивный)...");
        startTime = System.nanoTime();
        graph.depthFirstTraversalRecursion(0);
        endTime = System.nanoTime();
        System.out.println("Время обхода (нс): " + (endTime - startTime));
        System.out.println();

        /*Задание 7.4
        В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
        Выполните оценку времени с помощью System.nanoTime().*/
        System.out.println("Обход графа в ширину, первый метод...");
        startTime = System.nanoTime();
        graph.breadthFirstTraversal();
        endTime = System.nanoTime();
        System.out.println("Время обхода (нс): " + (endTime - startTime));
        System.out.println();

        System.out.println("Обход графа в ширину, второй метод (с собственной реализацией очереди с помощью массива)...");
        startTime = System.nanoTime();
        graph.breadthFirstTraversalV2(0);
        endTime = System.nanoTime();
        System.out.println("Время обхода (нс): " + (endTime - startTime));
        System.out.println();
    }
}
