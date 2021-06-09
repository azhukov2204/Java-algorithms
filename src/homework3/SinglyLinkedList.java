package homework3;

import java.util.StringJoiner;

public class SinglyLinkedList<T> {
    private Link<T> firstElementLink;

    public SinglyLinkedList() {
        firstElementLink = null;
    }

    public void add(T object) {
        Link<T> link = new Link<>(object);
        link.setNext(firstElementLink);
        this.firstElementLink = link;
    }

    public void deleteFirst() {
        firstElementLink = firstElementLink.getNext();
    }

    @Override
    public String toString() {
        Link<T> current = firstElementLink;
        StringJoiner stringJoiner = new StringJoiner(",");
        while (current != null) {
            stringJoiner.add(current.getValue().toString());
            current = current.getNext();
        }
        return "[" + stringJoiner + "]";
    }

    public boolean contains(T searchObject) {
        Link<T> current = firstElementLink;
        while (current != null) {
            if (current.getValue().equals(searchObject)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}
