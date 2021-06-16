package homework6;

public class Node {
    private PersonWithId person;
    private Node leftChild; // Это наш левый потомок
    private Node rightChild; // Это наш правый потомок

    public void display()
    {
        System.out.println("Имя: " + person.getName() + " Возраст: " + person.getAge() + " Индекс: " + person.getId());
    }

    public void setPerson(PersonWithId person) {
        this.person = person;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public PersonWithId getPerson() {
        return person;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
}
