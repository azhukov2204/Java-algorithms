package homework4;

import homework3.Link;

import java.util.StringJoiner;

public class SinglyLinkedListForQueue<T> {
    public Link<T> first;
    public Link<T> last;

    public SinglyLinkedListForQueue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void add(T object) {
        Link<T> newLink = new Link<>(object);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.setNext(newLink);
        }
        last = newLink;
    }

    public T delete() {
        Link<T> temp = first;
        if (first.getNext() == null) {
            last = null;
        }
        first = first.getNext();
        return temp.getValue();
    }

    @Override
    public String toString() {
        Link<T> current = first;
        StringJoiner stringJoiner = new StringJoiner(",");
        while (current != null) {
            stringJoiner.add(current.getValue().toString());
            current = current.getNext();
        }
        return "[" + stringJoiner + "]";
    }
}
