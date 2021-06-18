package homework7;

public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label; // Это обычная буква, метка обозначающая нашу вершину
        this.wasVisited = false; // Переменная для того, чтобы проверять: были ли мы в данной вершине или нет
    }
}
