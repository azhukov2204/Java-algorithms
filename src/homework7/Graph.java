package homework7;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private static final int MAX_VERTICES = 32; // Максимальное количество вершин
    private final Vertex[] vertexList; // Массив, в котором хранятся наши вершины. Когда мы захотим посмотреть на какую-нибудь вершину, то мы будем обращаться к данному массиву
    private final int[][] adjacencyMatrix; // Матрица смежности, которая будет хранить связи между нашими вершинами
    private int size; // Текущее количество вершин
    private final StackDFT stackDFT;

    // Создание нашего графа с вершинами
    public Graph() {
        stackDFT = new StackDFT(MAX_VERTICES);
        vertexList = new Vertex[MAX_VERTICES];
        adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        size = 0;
        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjacencyMatrix[i][j] = 0; // Заполняем матрицу смежности начальными значениями, чтобы она не была пустой
                // На данном этапе у нас нет ещё ни одного ребра между вершинами
            }
        }
    }

    // Метод для добавления новой вершины
    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    // Метод добавления связей между вершинами
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1; // Здесь мы добавляем связь от A к B
        adjacencyMatrix[end][start] = 1; // Здесь мы добавляем связь от B к A
    }

    public void depthFirstTraversal() {
        // Здесь мы сразу начинаем с нулевого значения, а не с произвольного элемента
        vertexList[0].wasVisited = true;
        //displayVertex(0);
        stackDFT.push(0);
        while (!stackDFT.isEmpty()) {
            int currentVertex = getAdjacencyUnvisitedVertex(stackDFT.peek());
            if (currentVertex == -1) {  //ребро графа просмотрено, возвращаемся наверх
                stackDFT.pop();
            } else {
                vertexList[currentVertex].wasVisited = true;
                //displayVertex(currentVertex);
                fullDisplayVertex(stackDFT.peek(), currentVertex);
                stackDFT.push(currentVertex);
            }
        }
        resetWasVisitedStatus();
    }

    // Метод обхода в глубину. startVertex - стартовая вершина
    public void depthFirstTraversalRecursion(int startVertex) {
        depthFirstTraversalRecursionTechno(startVertex);
        resetWasVisitedStatus();
    }

    private void depthFirstTraversalRecursionTechno(int startVertex) {
        vertexList[startVertex].wasVisited = true;
        for (int i = 0; i < size; i++) {
            int currentVertex = getAdjacencyUnvisitedVertex(startVertex);
            if (!vertexList[i].wasVisited && currentVertex != -1 && i == currentVertex) {
                fullDisplayVertex(startVertex, currentVertex);
                depthFirstTraversalRecursionTechno(i);
            }
        }
    }

    public void breadthFirstTraversal() {
        Queue<Integer> queue = new LinkedList<>(); // Создаём нашу очередь с помощью базового метода LinkedList
        vertexList[0].wasVisited = true;
        //displayVertex(0);
        queue.add(0);
        int currentVertex; // Смежная с v1 вершина
        while (!queue.isEmpty()) {
            int startVertex = queue.remove(); // Достаём наш элемент из очереди
            while ((currentVertex = getAdjacencyUnvisitedVertex(startVertex)) != -1) // Если с currentVertex есть смежное значение startVertex
            {
                vertexList[currentVertex].wasVisited = true;
                //displayVertex(currentVertex);
                fullDisplayVertex(startVertex, currentVertex);
                queue.add(currentVertex);
            }
        }
        resetWasVisitedStatus();
    }

    // Второй метод обхода в ширину
    public void breadthFirstTraversalV2(int startVertex) {
        int[] queue = new int[size]; // Здесь очередь реализована в виде массива
        int qH = 0; // Индекс головы очереди
        int qT = 0; // Индекс хвоста очереди
        vertexList[startVertex].wasVisited = true;
        queue[qT++] = startVertex;

        int currentVertex;
        while (qH < qT) { // Сравнение индексов начала и конца очереди
            startVertex = queue[qH++];
            for (int i = 0; i < size; i++) {
                currentVertex = getAdjacencyUnvisitedVertex(startVertex); // Здесь идёт перебор всех вершин, связанных с вершиной startVertex
                if (currentVertex != -1 && !vertexList[currentVertex].wasVisited) {
                    vertexList[currentVertex].wasVisited = true;
                    //displayVertex(currentVertex);
                    fullDisplayVertex(startVertex, currentVertex);
                    queue[qT++] = currentVertex;
                }
            }
        }
        resetWasVisitedStatus();
    }

    private void resetWasVisitedStatus() {
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    // Проверка смежности вершин
    private int getAdjacencyUnvisitedVertex(int vertexIndex) {
        for (int i = 0; i < size; i++) {
            if (adjacencyMatrix[vertexIndex][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    // Отображение вершины
    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    public void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println("Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }
}
