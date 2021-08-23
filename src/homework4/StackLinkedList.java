package homework4;

import homework3.SinglyLinkedList;

public class StackLinkedList<T> {
    private final SinglyLinkedList<T> list;

    public StackLinkedList()
    {
        list = new SinglyLinkedList<>();
    }

    public void push(T object)
    {
        list.add(object);
    }

    public T pop()
    {
        return list.deleteFirst();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
