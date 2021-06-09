package homework3;

public class Link<T> {
    private final T object;
    private Link<T> next;

    public Link(T object)
    {
        this.object = object;
    }

    public Link<T> getNext()
    {
        return next;
    }

    public void setNext(Link<T> next)
    {
        this.next = next;
    }

    public T getValue()
    {
        return object;
    }
}
