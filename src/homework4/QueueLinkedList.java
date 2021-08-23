package homework4;

public class QueueLinkedList<T> {
    private final SinglyLinkedListForQueue<T> queue = new SinglyLinkedListForQueue<>();

    public void push(T object) {
        queue.add(object);
    }

    public T pop() {
        return queue.delete();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
